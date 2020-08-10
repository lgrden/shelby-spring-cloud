package io.wegetit.shelby.refdata.city;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
@AllArgsConstructor
public class CityEntityService {

    private final CityEntityRepository repository;

    public List<CityEntity> findAll() {
        return repository.findAll().stream().sorted((p, k) -> StringUtils.compare(p.getName(), k.getName())).collect(
            Collectors.toList());
    }

    public List<CityEntity> getByCountry(String country) {
        return repository.findByCountry(country).stream().sorted((p, k) -> StringUtils.compare(p.getName(), k.getName())).collect(
                Collectors.toList());
    }
}
