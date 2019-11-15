//package com.springboot.infinispan.controller;
//
//
//import org.infinispan.Cache;
//import org.infinispan.configuration.cache.CacheMode;
//import org.infinispan.configuration.cache.Configuration;
//import org.infinispan.configuration.cache.ConfigurationBuilder;
//import org.infinispan.configuration.global.GlobalConfiguration;
//import org.infinispan.configuration.global.GlobalConfigurationBuilder;
//import org.infinispan.manager.DefaultCacheManager;
//import org.infinispan.manager.EmbeddedCacheManager;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.concurrent.TimeUnit;
//
//
//@RestController   //注意模板 需要这个
//@RequestMapping("")
//
//public class InfinispanController {
//
//
//    @GetMapping("/get")
//    public String get() throws Exception{
//        Cache cache = this.initGlobal();
//       String a = cache.get("key").toString();
//       return a;
//    }
//
//    @GetMapping(path = "/add")
//    public String add() throws Exception{
//        Cache cache = this.initGlobal();
//        cache.put("key","hukaijia");
//        return "success";
//    }
//
//    public Cache init()throws Exception{
//        EmbeddedCacheManager manager = new DefaultCacheManager("infinispan-config-9.4.xml");
//        Cache defaultCache = manager.getCache();
//        return defaultCache;
//    }
//
//    public Cache initGlobal()throws Exception{
//        GlobalConfiguration global = new GlobalConfigurationBuilder()
//                .clusteredDefault() // Builds a default clustered configuration
//                .transport().addProperty("configurationFile", "jgroups.xml") //provide a specific JGroups configuration
//                .globalJmxStatistics().allowDuplicateDomains(true).enable()  //This method enables the jmx statistics of
//                // the global configuration and allows for duplicate JMX domains
//                .build();  // Builds the GlobalConfiguration object
//        ConfigurationBuilder configBuilder = new ConfigurationBuilder();
//        Configuration config = new ConfigurationBuilder()
//                .jmxStatistics().enable()  //Enable JMX statistics
//                .clustering().cacheMode(CacheMode.DIST_SYNC)  //Set Cache mode to DISTRIBUTED with SYNCHRONOUS replication
//                .hash().numOwners(2) //Keeps two copies of each key/value pair
//                .expiration().lifespan(60 * 1000) //Set expiration - cache entries expire after some time (given by
//                // the lifespan parameter) and are removed from the cache (cluster-wide).
//                .build();
//        EmbeddedCacheManager manager = new DefaultCacheManager(global,config);
//        Cache defaultCache = manager.getCache();
//        return defaultCache;
//    }
////    public static void main(String[] args) throws Exception {
////
////        Cache cache = initGlobal();
////        cache.put("key","hukaijia");
////        String a = cache.get("key").toString();
////        System.out.println(a);
////
////
////    }
//}
