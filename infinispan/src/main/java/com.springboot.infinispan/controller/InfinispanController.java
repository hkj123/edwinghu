package com.springboot.infinispan.controller;


import org.infinispan.Cache;
import org.infinispan.client.hotrod.ProtocolVersion;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfiguration;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.infinispan.server.hotrod.HotRodServer;
import org.infinispan.server.hotrod.configuration.HotRodServerConfiguration;
import org.infinispan.server.hotrod.configuration.HotRodServerConfigurationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


@RestController   //注意模板 需要这个
@RequestMapping("/user")

public class InfinispanController {

//    @GetMapping("/get")
//    public String get() throws Exception{
//        Cache cache = this.initGlobal();
//        String a = cache.get("key").toString();
//        return a;
//    }
//
//    @GetMapping(path = "/add")
//    public String add() throws Exception{
//        Cache cache = this.initGlobal();
//        cache.put("key","hukaijia");
//        return "success";
//    }

//    public Cache init()throws Exception{
//        EmbeddedCacheManager manager = new DefaultCacheManager("infinispan-config-9.4.xml");
//        Cache defaultCache = manager.getCache();
//        return defaultCache;
//    }

//    public Cache initGlobal()throws Exception{
//
//
//    }

//    public static void main(String[] args) throws Exception {
//
//        System.out.println("Starting a cache manager with a programmatic configuration");
//        DefaultCacheManager manager = new DefaultCacheManager(
//                GlobalConfigurationBuilder.defaultClusteredBuilder()
//                        .transport().addProperty("configurationFile", "jgroups-tcp.xml")
//                        .build(),
//                new ConfigurationBuilder()
//                        .clustering()
//                        .cacheMode(CacheMode.REPL_SYNC)
//                        .build()
//        );
//        // The only way to get the "repl" cache to be exactly the same as the default cache is to not define it at all
//        manager.defineConfiguration("dist", new ConfigurationBuilder()
//                .clustering()
//                .cacheMode(CacheMode.DIST_SYNC)
//                .hash().numOwners(2)
//                .build()
//        );
//        Cache<String, String> cache = manager.getCache("cachename");
//
//        HotRodServerConfiguration serverConfig = new HotRodServerConfigurationBuilder()
//                .host("127.0.0.1").port(9999).build();
//        HotRodServer server = new HotRodServer();
//        server.start(serverConfig, cacheManager);
//
//   }
}
