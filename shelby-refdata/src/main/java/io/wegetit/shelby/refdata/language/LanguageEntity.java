package io.wegetit.shelby.refdata.language;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@Document(collection = "languages")
@TypeAlias("language")
@EqualsAndHashCode(of = "code")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class LanguageEntity {
    @Id
    private String code;

    @NotNull
    private String name;
}
