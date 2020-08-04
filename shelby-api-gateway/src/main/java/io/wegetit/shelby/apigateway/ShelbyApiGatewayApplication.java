package io.wegetit.shelby.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.PropertySource;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class ShelbyApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShelbyApiGatewayApplication.class, args);
    }
}
