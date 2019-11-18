import com.springboot.infinispan.InfinispanApplication;
import org.infinispan.client.hotrod.ProtocolVersion;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.VersionedValue;
import org.infinispan.client.hotrod.configuration.*;

import org.infinispan.persistence.manager.PersistenceManager;
import org.infinispan.persistence.remote.RemoteStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InfinispanApplication.class)
@TestPropertySource(locations = "classpath:test-hotrod-client.properties")
public class infinispanTest {

    @Test
    public void signalTest() {
//        GlobalConfiguration globalConfiguration = GlobalConfigurationBuilder.defaultClusteredBuilder()
//                .transport().nodeName("test2").addProperty("configurationFile", "jgroups.xml")
//                .build();
        Configuration configuration = new ConfigurationBuilder().addServer().host("127.0.0.1").port(9999).version(ProtocolVersion.PROTOCOL_VERSION_27).build();
        RemoteCacheManager manager = new RemoteCacheManager(configuration);
        RemoteCache<String,String> cache = manager.getCache("dist");
//        cache.put("hukaijia","test");
//        cache.put("car", "ferrari");
//        cache.replace("key0", "ferrari");
//        cache.values();
//        VersionedValue valueBinary = cache.getVersioned("car");
//        System.out.println("**************************"+valueBinary);
//        System.out.println("**************************"+cache.get("car"));
        System.out.println("**************************"+cache.get("key1"));
        System.out.println("**************************"+cache.size());
        System.out.println("**************************"+cache.getVersion());
    }
}
