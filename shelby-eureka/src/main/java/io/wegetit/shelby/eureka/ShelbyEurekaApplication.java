package io.wegetit.shelby.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaServer
@PropertySource("classpath:application.properties")
public class ShelbyEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShelbyEurekaApplication.class, args);
    }
}
