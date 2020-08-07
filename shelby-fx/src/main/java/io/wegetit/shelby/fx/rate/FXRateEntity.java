package io.wegetit.shelby.fx.rate;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
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
@TypeAlias("fxRate")
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

    public static FXRateEntity of(FxProvider provider, LocalDate date, String source, String target, BigDecimal rate) {
        return FXRateEntity.builder()
                .id(UUID.randomUUID().toString())
                .provider(provider)
                .date(date)
                .source(source)
                .target(target)
                .rate(rate)
                .build();
    }
}
