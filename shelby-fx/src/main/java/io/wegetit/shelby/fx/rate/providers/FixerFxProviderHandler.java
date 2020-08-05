package io.wegetit.shelby.fx.rate.providers;

import io.wegetit.shelby.fx.rate.FXRateEntity;
import io.wegetit.shelby.fx.rate.FXRateEntityService;
import io.wegetit.shelby.fx.rate.FxProvider;
import io.wegetit.shelby.fx.rate.FxProviderHandler;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FixerFxProviderHandler extends FxProviderHandler {

    public FixerFxProviderHandler(FXRateEntityService service) {
        super(service);
    }

    @Override
    public FxProvider getType() {
        return FxProvider.FIXER;
    }

    @Override
    public List<FXRateEntity> fetch(LocalDate date) throws Exception {
        throw new UnsupportedOperationException();
    }
}
