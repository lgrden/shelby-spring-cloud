package io.wegetit.shelby.refdata.language;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/languages")
public class LanguageEntityRestService {

    private final LanguageEntityService service;

    @GetMapping
    public List<LanguageEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/{code}")
    public LanguageEntity getByCode(@PathVariable String code) {
        return service.getByCode(code);
    }
}
