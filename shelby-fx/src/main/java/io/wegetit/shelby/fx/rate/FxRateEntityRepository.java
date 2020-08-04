package io.wegetit.shelby.fx.rate;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface FxRateEntityRepository extends MongoRepository<FXRateEntity, String> {
}

