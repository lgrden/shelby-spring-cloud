package io.wegetit.shelby.fx;

import io.wegetit.shelby.commons.config.EnableCommonConfig;
import io.wegetit.shelby.commons.endpoints.security.EnableSecurityProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

@EnableDiscoveryClient
@SpringBootApplication
@EnableCommonConfig
@PropertySource("classpath:application.properties")
public class ShelbyFxApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShelbyFxApplication.class, args);
    }
}
