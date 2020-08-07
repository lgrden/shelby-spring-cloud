package io.wegetit.shelby.security;

import io.wegetit.shelby.commons.config.EnableCommonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

@EnableDiscoveryClient
@SpringBootApplication
@EnableCommonConfig
@PropertySource("classpath:application.properties")
public class ShelbySecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShelbySecurityApplication.class, args);
    }
}
