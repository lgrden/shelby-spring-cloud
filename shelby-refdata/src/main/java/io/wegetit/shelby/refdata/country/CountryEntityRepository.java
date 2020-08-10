package io.wegetit.shelby.refdata.country;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryEntityRepository extends MongoRepository<CountryEntity, String> {

    Optional<CountryEntity> findByCode(String code);
}