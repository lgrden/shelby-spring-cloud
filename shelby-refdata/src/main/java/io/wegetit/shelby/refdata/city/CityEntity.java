package io.wegetit.shelby.refdata.city;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@Document(collection = "cities")
@TypeAlias("city")
@EqualsAndHashCode(of = "geonameid")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CityEntity {
    @Id
    private Integer geonameid;

    @NotNull
    private String name;

    @NotNull
    private String country;

    @NotNull
    private String region;
}
