package io.wegetit.shelby.security.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import io.wegetit.shelby.commons.model.ActivityStatus;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "users")
@TypeAlias("user")
@EqualsAndHashCode(of = "id")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserEntity {
    @Id
    private String id;

    @NotNull
    @Email
    @Indexed(unique = true)
    private String email;

    @NotNull
    @Length(min = 4, max = 4)
    @Indexed(unique = true)
    private String initials;

    @NotNull
    @Length(max = 64)
    private String fullName;

    @Length(max = 1024)
    private String address;

    @NotNull
    private ActivityStatus status;
}
