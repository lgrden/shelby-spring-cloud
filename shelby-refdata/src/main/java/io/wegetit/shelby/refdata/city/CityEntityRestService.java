package io.wegetit.shelby.refdata.city;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cities")
public class CityEntityRestService {

    private final CityEntityService service;

    @GetMapping
    public List<CityEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/country/{name}")
    public List<CityEntity> getByCountry(@PathVariable String name) {
        return service.getByCountry(name);
    }
}
