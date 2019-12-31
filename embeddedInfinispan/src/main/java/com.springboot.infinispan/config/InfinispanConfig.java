//package com.springboot.infinispan.config;
//
//import org.infinispan.Cache;
//import org.infinispan.configuration.cache.CacheMode;
//import org.infinispan.configuration.cache.ConfigurationBuilder;
//import org.infinispan.configuration.global.GlobalConfigurationBuilder;
//import org.infinispan.manager.DefaultCacheManager;
//import org.infinispan.manager.EmbeddedCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by DELL on 2019/4/26.
// */
//@Configuration
//public class InfinispanConfig {
//
//    @Bean
//    public Cache<String, String> transactionalCache() throws IOException {
//        EmbeddedCacheManager cacheManager = new DefaultCacheManager("infinispan.xml");
//        org.infinispan.configuration.cache.Configuration configuration =
//                new ConfigurationBuilder().expiration().lifespan(1, TimeUnit.SECONDS).build();
//        cacheManager.getCache("local");
//        Cache<String, String> cache = cacheManager.getCache("local");
//        return cache;
//    }
//}
