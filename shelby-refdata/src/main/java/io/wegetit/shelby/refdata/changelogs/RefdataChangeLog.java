package io.wegetit.shelby.refdata.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import io.wegetit.shelby.commons.utils.DataLoaderUtils;
import io.wegetit.shelby.refdata.city.CityEntity;
import io.wegetit.shelby.refdata.country.CountryEntity;
import io.wegetit.shelby.refdata.language.LanguageEntity;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

@ChangeLog(order = "001")
public class RefdataChangeLog {

    @ChangeSet(order = "001", id = "loadCountries", author = "grlu", runAlways = true)
    public void loadCountries(MongoTemplate template) throws IOException {
        DataLoaderUtils.loadAllIfEmpty(template,"countries.json", CountryEntity.class);
    }

    @ChangeSet(order = "002", id = "loadLanguages", author = "grlu", runAlways = true)
    public void loadLanguages(MongoTemplate template) throws IOException {
        DataLoaderUtils.loadAllIfEmpty(template,"languages.json", LanguageEntity.class);
    }

    @ChangeSet(order = "003", id = "loadCities", author = "grlu", runAlways = true)
    public void loadCities(MongoTemplate template) throws IOException {
        DataLoaderUtils.loadAllIfEmpty(template,"cities.json", CityEntity.class);
    }
}
