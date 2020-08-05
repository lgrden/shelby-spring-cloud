package io.wegetit.shelby.fx.rate;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class FxProviderHandler {

    private final FXRateEntityService service;

    public FxProviderHandler(FXRateEntityService service) {
        this.service = service;
        service.register(this);
    }

    public List<FXRateEntity> fetchRates(LocalDate date) {
        log.info("Fetching rates for " + getType() + " on " + date);
        List<FXRateEntity> list = new ArrayList<>();
        try {
            list.addAll(fetch(date));
            log.info("Rates for " + getType() + " on " + date + " fetched successfully.");
        } catch (Exception e) {
            throw new IllegalStateException("Problem fetching rates for " + getType(), e);
        }
        return list;
    }

    public abstract FxProvider getType();

    public abstract List<FXRateEntity> fetch(LocalDate date) throws Exception;
}
