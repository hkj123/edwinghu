import com.springboot.infinispan.InfinispanApplication;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InfinispanApplication.class)
@TestPropertySource(locations = "classpath:test-hotrod-client.properties")
public class infinispanTest {

    @Test
    public void signalTest() {
//        GlobalConfiguration globalConfiguration = GlobalConfigurationBuilder.defaultClusteredBuilder()
//                .transport().nodeName("test2").addProperty("configurationFile", "jgroups.xml")
//                .build();
        Configuration configuration = new ConfigurationBuilder().addServer().host("127.0.0.1").port(9999).build();
        RemoteCacheManager manager = new RemoteCacheManager(configuration);
        RemoteCache<String,String> cache = manager.getCache("dist");
//        Set<Map.Entry<String,String>> entrySet = cache.entrySet();
//        Map<String,String> map = cache.getBulk();
        System.out.printf("111"+manager.getCache().get("dist"));
        System.out.println("111"+cache.size());
        System.out.println("hukaijia"+cache.getVersion());
        System.out.println("**************************"+cache.size());
    }
}
