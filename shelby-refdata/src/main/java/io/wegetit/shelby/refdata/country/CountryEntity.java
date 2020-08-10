package io.wegetit.shelby.refdata.country;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@Document(collection = "countries")
@TypeAlias("country")
@EqualsAndHashCode(of = "code")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CountryEntity {
    @Id
    private String code;

    @NotNull
    private String name;
}
