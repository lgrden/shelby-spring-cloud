package io.wegetit.shelby.commons.endpoints.security;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("shelby-security")
public interface UserProxy {

    @GetMapping(value = "/api/users")
    @CrossOrigin
    List<User> getUsers();

    @GetMapping(value = "/api/users/{id}")
    @CrossOrigin
    User getUser(@PathVariable("id") String id);
}