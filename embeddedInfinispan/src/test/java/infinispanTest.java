//import com.springboot.infinispan.EmbeddedInfinispanApplication;
//import org.infinispan.client.hotrod.RemoteCache;
//import org.infinispan.client.hotrod.RemoteCacheManager;
//import org.infinispan.client.hotrod.VersionedValue;
//import org.infinispan.client.hotrod.configuration.Configuration;
//import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = EmbeddedInfinispanApplication.class)
//public class infinispanTest {
//
//    @Test
//    public void signalTest() {
////        GlobalConfiguration globalConfiguration = GlobalConfigurationBuilder.defaultClusteredBuilder()
////                .transport().nodeName("test2").addProperty("configurationFile", "jgroups.xml")
////                .build();
//        Configuration configuration = new ConfigurationBuilder().addServer().host("127.0.0.1").port(11222).build();
//        RemoteCacheManager manager = new RemoteCacheManager(configuration);
//        RemoteCache<String,String> cache = manager.getCache();
//        cache.put("hukaijia","test");
//        cache.put("car", "ferrari");
//        VersionedValue valueBinary = cache.getVersioned("car");
//        System.out.println("**************************"+valueBinary);
//        System.out.println("**************************"+cache.get("car"));
//        System.out.println("**************************"+cache.get("key1"));
//        System.out.println("**************************"+cache.size());
//        System.out.println("**************************"+cache.getVersion());
//        System.out.println("**************************"+cache.size());
//    }
//}
