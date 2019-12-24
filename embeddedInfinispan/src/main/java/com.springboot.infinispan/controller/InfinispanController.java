package com.springboot.infinispan.controller;


import com.springboot.infinispan.config.InfinispanConfig;
import org.infinispan.Cache;
import org.infinispan.manager.EmbeddedCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController   //注意模板 需要这个
@RequestMapping("")

public class InfinispanController {

    @Autowired
    private InfinispanConfig infinispanConfig;


    @GetMapping("/get")
    public String get() throws Exception{
       EmbeddedCacheManager cacheManager = infinispanConfig.createCacheManager();
       Cache<String, String> cache = cacheManager.getCache("nodeName1");
       String a = cache.get("key").toString();
       return a;
    }

    @GetMapping(path = "/add")
    public String add() throws Exception{
        EmbeddedCacheManager cacheManager = infinispanConfig.createCacheManager();
        Cache<String, String> cache = cacheManager.getCache("nodeName1");
        cache.put("key","hukaijia");
        return "success";
    }
}
