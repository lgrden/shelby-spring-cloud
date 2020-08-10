package io.wegetit.shelby.refdata.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import io.wegetit.shelby.commons.utils.DataLoaderUtils;
import io.wegetit.shelby.refdata.country.CountryEntity;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

@ChangeLog(order = "001")
public class CountriesChangeLog {

    @ChangeSet(order = "001", id = "loadCountryes", author = "grlu", runAlways = true)
    public void loadCountries(MongoTemplate template) throws IOException {
        template.dropCollection(CountryEntity.class);
        DataLoaderUtils.loadAll(template,"countries.json", CountryEntity.class);
    }
}
