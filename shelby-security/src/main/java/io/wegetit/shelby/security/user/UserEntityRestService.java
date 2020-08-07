package io.wegetit.shelby.security.user;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserEntityRestService {

    private final UserEntityService service;

    @GetMapping
    public List<UserEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity getById(@PathVariable String id) {
        return service.getById(id);
    }
}
