package io.wegetit.shelby.refdata.city;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityEntityRepository extends MongoRepository<CityEntity, String> {

    @Query(value = "{'country' : ?0}")
    List<CityEntity> findByCountry(String country);
}