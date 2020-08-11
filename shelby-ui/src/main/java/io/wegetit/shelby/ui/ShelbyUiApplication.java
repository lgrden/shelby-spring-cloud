package io.wegetit.shelby.ui;

import io.wegetit.shelby.commons.config.EnableCommonConfig;
import io.wegetit.shelby.commons.endpoints.refdata.EnableRefdataProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

@EnableDiscoveryClient
@SpringBootApplication
@EnableCommonConfig
@EnableRefdataProxy
@PropertySource("classpath:application.properties")
public class ShelbyUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShelbyUiApplication.class, args);
    }
}
