package io.wegetit.shelby.fx.rate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.EnumMap;

@AllArgsConstructor
@Service
@Slf4j
public class FXRateEntityService {

    private final EnumMap<FxProvider, FxProviderHandler> handlers = new EnumMap<>(FxProvider.class);

    private final FxRateEntityRepository repository;

    public void register(FxProviderHandler handler) {
        log.info("FXRate for " + handler.getType() + " registered. ");
        handlers.put(handler.getType(), handler);
    }

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
