package io.wegetit.shelby.fx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

@EnableDiscoveryClient
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class ShelbyFxApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShelbyFxApplication.class, args);
    }
}
