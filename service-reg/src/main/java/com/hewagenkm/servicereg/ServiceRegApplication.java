package com.hewagenkm.servicereg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegApplication.class, args);
    }

    @Bean
    CacheManager cacheManager() {
        return new CaffeineCacheManager();
    }
}
