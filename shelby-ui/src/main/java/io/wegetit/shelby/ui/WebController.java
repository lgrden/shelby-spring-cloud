package io.wegetit.shelby.ui;

import io.wegetit.shelby.commons.endpoints.refdata.RefdataProxy;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class WebController  {

    private final RefdataProxy refdataProxy;

    @GetMapping(value = "/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping(value = "/countries")
    public String countries(Model model) {
        model.addAttribute("countries", refdataProxy.getCountries());
        return "countries";
    }

    @GetMapping(value = "/cities")
    public String cities(@RequestParam(value = "country", required = false) String country, Model model) {
        model.addAttribute("cities", StringUtils.isEmpty(country) ? refdataProxy.getCities() : refdataProxy.getCitiesInCountry(country));
        model.addAttribute("country", country);
        return "cities";
    }

    @GetMapping(value = "/languages")
    public String languages(Model model) {
        model.addAttribute("languages", refdataProxy.getLanguages());
        return "languages";
    }
}
