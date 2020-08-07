package io.wegetit.shelby.commons.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({CommonConfiguration.class})
public @interface EnableCommonConfig {

}
