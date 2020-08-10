package io.wegetit.shelby.refdata.language;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageEntityRepository extends MongoRepository<LanguageEntity, String> {

    Optional<LanguageEntity> findByCode(String code);
}