package com.springboot.activiti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
@EnableDiscoveryClient
public class ActivitiApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//    }

    private static final Logger log = LoggerFactory.getLogger(ActivitiApplication.class);


    public static void main(String[] args) throws UnknownHostException {
//        SpringApplication.run(MybatisApplication.class, args);
        SpringApplication app = new SpringApplication(ActivitiApplication.class);
        Environment env = app.run(args).getEnvironment();
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}\n\t" +
                        "External: \thttp://{}:{}\n\t" +
                        "SwaggerUI: \thttp://localhost:{}/swagger-ui.html\n" +
                        "----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                env.getProperty("server.port"));
    }
}
