package org.example.internservice.config.AppConfig;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    @LoadBalanced  // enables service name resolution via Eureka
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}