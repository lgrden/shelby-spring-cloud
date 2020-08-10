package io.wegetit.shelby.refdata.country;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/countries")
public class CountryEntityRestService {

    private final CountryEntityService service;

    @GetMapping
    public List<CountryEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/{code}")
    public CountryEntity getByCode(@PathVariable String code) {
        return service.getByCode(code);
    }
}
