package com.springboot.infinispan.controller;


import org.infinispan.Cache;
import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.Configuration;
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

    public static void main(String[] args) throws Exception {

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
                        .cacheMode(CacheMode.DIST_SYNC)
                        .hash().numOwners(1)
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
        final Cache<String, String> cache = cacheManager.getCache("dist",true);
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
                        cache.put("key" + counter, "" + cache.getAdvancedCache().getRpcManager().getAddress() + "-" + counter);
                        System.out.println("key" + counter+"*************"+"value"+cache.getAdvancedCache().getRpcManager().getAddress() + "-" + counter);
                        String key="key" + counter;
                        System.out.println("***********"+cache.get(key));
                        System.out.println("***********"+cache.getVersion());
                        if(Objects.nonNull(cache.get("hukaijia"))){
                            System.out.println("客户端添加返回***********"+cache.get("hukaijia"));
                        }
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
