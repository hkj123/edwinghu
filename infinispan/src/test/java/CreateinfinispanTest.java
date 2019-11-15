import com.springboot.infinispan.InfinispanApplication;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.infinispan.server.hotrod.HotRodServer;
import org.infinispan.server.hotrod.configuration.HotRodServerConfiguration;
import org.infinispan.server.hotrod.configuration.HotRodServerConfigurationBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = InfinispanApplication.class)
@TestPropertySource(locations = "classpath:test-hotrod-client.properties")
public class CreateinfinispanTest {

    @Test
    public void createTest() {
        EmbeddedCacheManager cacheManager  = new DefaultCacheManager(
                GlobalConfigurationBuilder.defaultClusteredBuilder()
//                        .transport().nodeName("test1").addProperty("configurationFile", "jgroups.xml")
//                        .build(),
                .transport().nodeName("test1")
                .globalJmxStatistics()
                .enable()
                .build(),
                new ConfigurationBuilder()
                        .clustering()
                        .cacheMode(CacheMode.REPL_SYNC)
                        .build()
        );
        // The only way to get the "repl" cache to be exactly the same as the default cache is to not define it at all
        cacheManager.defineConfiguration("dist", new ConfigurationBuilder()
                .clustering()
                .cacheMode(CacheMode.DIST_SYNC)
                .hash().numOwners(2)
                .build()
        );
        System.out.printf("status"+cacheManager.getStats()+"address"+cacheManager.getAddress());
        final Cache<String, String> cache = cacheManager.getCache("dist");
        System.out.printf("Cache %s started on %s, cache members are now %s\n", "dist", cacheManager.getAddress(),
                cache.getAdvancedCache().getRpcManager().getMembers());

        HotRodServerConfiguration serverConfig = new HotRodServerConfigurationBuilder()
                .host("127.0.0.1").port(9999).build();
        HotRodServer server = new HotRodServer();
        server.start(serverConfig, cacheManager);
        Thread putThread = new Thread() {
            @Override
            public void run() {
                int counter = 0;
                while (true) {
                    try {
                        cache.put("key-" + counter, "" + cache.getAdvancedCache().getRpcManager().getAddress() + "-" + counter);
                    } catch (Exception e) {
                    }
                    counter++;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        };
        putThread.start();
    }
}
