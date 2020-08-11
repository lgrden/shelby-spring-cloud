package io.wegetit.shelby.commons.endpoints.refdata;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("shelby-refdata")
public interface RefdataProxy {

    @GetMapping(value = "/api/cities")
    @CrossOrigin
    List<City> getCities();

    @GetMapping(value = "/api/cities/country/{name}")
    @CrossOrigin
    List<City> getCitiesInCountry(@PathVariable("name") String name);

    @GetMapping(value = "/api/countries")
    @CrossOrigin
    List<Country> getCountries();

    @GetMapping(value = "/api/countries/{code}")
    @CrossOrigin
    Country getCountryByCode(@PathVariable("code") String code);

    @GetMapping(value = "/api/languages")
    @CrossOrigin
    List<Language> getLanguages();

    @GetMapping(value = "/api/languages/{code}")
    @CrossOrigin
    Language getLanguageByCode(@PathVariable("code") String code);
}