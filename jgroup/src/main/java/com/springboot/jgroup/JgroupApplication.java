package com.springboot.jgroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class JgroupApplication {
    public static void main(String[] args) {
        SpringApplication.run(JgroupApplication.class, args);
    }
//    http://localhost:8781/product-dev.properties
}
