package io.wegetit.shelby.security.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import io.wegetit.shelby.commons.utils.DataLoaderUtils;
import io.wegetit.shelby.security.user.UserEntity;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

@ChangeLog(order = "001")
public class SecurityChangeLog {

    @ChangeSet(order = "001", id = "loadUsers", author = "grlu", runAlways = true)
    public void loadUsers(MongoTemplate template) throws IOException {
        DataLoaderUtils.loadAll(template,"users.json", UserEntity.class);
    }
}
