package io.wegetit.shelby.commons.endpoints.fx;

import org.springframework.cloud.openfeign.EnableFeignClients;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableFeignClients("io.wegetit.shelby.commons.endpoints.fx")
public @interface EnableFxProxy {

}
