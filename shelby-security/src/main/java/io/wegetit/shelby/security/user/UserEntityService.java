package io.wegetit.shelby.security.user;

import io.wegetit.shelby.commons.exceptions.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@AllArgsConstructor
public class UserEntityService {

    private final UserEntityRepository repository;

    public List<UserEntity> findAll() {
        return repository.findAll().stream().sorted((p, k) -> StringUtils.compare(p.getInitials(), k.getInitials())).collect(
            Collectors.toList());
    }

    public Optional<UserEntity> findById(String id) {
        return repository.findById(id);
    }

    public UserEntity getById(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found."));
    }

    public UserEntity getByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("User with email " + email + " not found."));
    }

    public UserEntity getByInitials(String initials) {
        return repository.findByInitials(initials).orElseThrow(() -> new EntityNotFoundException("User with initials " + initials + " not found."));
    }
}
