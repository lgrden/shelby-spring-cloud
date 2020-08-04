package io.wegetit.shelby.fx.rate;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@AllArgsConstructor
@Service
public class FXRateEntityService {
    private final FxRateEntityRepository repository;

    public FXRateEntity getFxRate(FxProvider provider, LocalDate date, String source, String target) {
        source = StringUtils.capitalize(source);
        target = StringUtils.capitalize(target);
        if (source.equals(target)) {
            return FXRateEntity.builder()
                .provider(provider)
                .date(date)
                .target(target)
                .source(source)
                .rate(BigDecimal.valueOf(1.0))
                .build();
        }
        return FXRateEntity.builder()
            .provider(provider)
            .date(date)
            .target(target)
            .source(source)
            .rate(BigDecimal.valueOf(10.0))
            .build();
    }
}
