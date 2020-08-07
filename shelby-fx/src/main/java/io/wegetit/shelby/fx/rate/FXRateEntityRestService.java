package io.wegetit.shelby.fx.rate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/")
public class FXRateEntityRestService {

    private final FXRateEntityService fxRateEntityService;

    @GetMapping(value = "/providers")
    public List<FxProvider> getProviders() {
        return List.of(FxProvider.values());
    }

    @GetMapping(value = "/{provider}/{dateString}/{source}/{target}")
    public FXRateEntity getRate(@PathVariable FxProvider provider, @PathVariable String dateString, @PathVariable String source, @PathVariable String target) {
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return fxRateEntityService.getFxRate(provider, date, source, target);
    }
}
