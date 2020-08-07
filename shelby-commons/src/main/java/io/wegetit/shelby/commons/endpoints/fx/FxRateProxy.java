package io.wegetit.shelby.commons.endpoints.fx;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("shelby-fx")
public interface FxRateProxy {

    @GetMapping(value = "/api/providers")
    @CrossOrigin
    List<FxProvider> getProviders();
}