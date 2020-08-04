package io.wegetit.shelby.fx.rate;


import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "fxRates")
@TypeAlias("fXRate")
@EqualsAndHashCode(of = "id")
@ToString
@AllArgsConstructor
@Builder(toBuilder = true)
public class FXRateEntity {

    @Id
    private String id;

    @NotNull
    private FxProvider provider;

    @NotNull
    private LocalDate date;

    @NotNull
    private String source;

    @NotNull
    private String target;

    @NotNull
    private BigDecimal rate;
}
