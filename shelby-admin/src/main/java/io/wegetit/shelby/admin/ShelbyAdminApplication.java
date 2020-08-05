package io.wegetit.shelby.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAdminServer
@PropertySource("classpath:application.properties")
public class ShelbyAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShelbyAdminApplication.class, args);
    }
}
