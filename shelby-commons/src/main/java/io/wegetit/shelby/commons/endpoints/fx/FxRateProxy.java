package io.wegetit.shelby.commons.endpoints.fx;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("shelby-fx")
public interface FxRateProxy {

    @GetMapping(value = "/api/providers")
    @CrossOrigin
    List<FxProvider> getProviders();
}