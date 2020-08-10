package io.wegetit.shelby.refdata.language;

import io.wegetit.shelby.commons.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
@AllArgsConstructor
public class LanguageEntityService {

    private final LanguageEntityRepository repository;

    public List<LanguageEntity> findAll() {
        return repository.findAll().stream().sorted((p, k) -> StringUtils.compare(p.getCode(), k.getCode())).collect(
            Collectors.toList());
    }

    public LanguageEntity getByCode(String code) {
        return repository.findByCode(code).orElseThrow(() -> new EntityNotFoundException("Language with code " + code + " not found."));
    }
}
