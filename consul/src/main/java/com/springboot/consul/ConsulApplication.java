package com.springboot.consul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.UnknownHostException;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableConfigurationProperties({ StudentConfig.class, TeachConfig.class })
public class ConsulApplication {

    private static final Logger log = LoggerFactory.getLogger(ConsulApplication.class);

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StudentConfig studentConfig;

    @Autowired
    private TeachConfig teachConfig;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/user/description")
    public String Description() {
        return "description";
    }

    @GetMapping("/user/student/intro")
    public String StudentIntro() {
        return studentConfig.toString();
    }

    @GetMapping("/user/teach/intro")
    public String TeachIntro() {
        return teachConfig.toString();
    }

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication.run(ConsulApplication.class, args);
//        SpringApplication app = new SpringApplication(ConsulApplication.class);
//        Environment env = app.run(args).getEnvironment();
//        log.info("\n----------------------------------------------------------\n\t" +
//                        "Application '{}' is running! Access URLs:\n\t" +
//                        "Local: \t\thttp://localhost:{}\n\t" +
//                        "External: \thttp://{}:{}\n\t" +
//                        "SwaggerUI: \thttp://localhost:{}/swagger-ui.html\n" +
//                        "----------------------------------------------------------",
//                env.getProperty("spring.application.name"),
//                env.getProperty("server.port"),
//                InetAddress.getLocalHost().getHostAddress(),
//                env.getProperty("server.port"),
//                env.getProperty("server.port"));
    }
}
