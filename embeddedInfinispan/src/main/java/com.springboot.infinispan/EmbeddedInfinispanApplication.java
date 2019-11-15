package com.springboot.infinispan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmbeddedInfinispanApplication {

    private static final Logger log = LoggerFactory.getLogger(EmbeddedInfinispanApplication.class);


    public static void main(String[] args) throws Exception {
        SpringApplication.run(EmbeddedInfinispanApplication.class, args);
    }
}
