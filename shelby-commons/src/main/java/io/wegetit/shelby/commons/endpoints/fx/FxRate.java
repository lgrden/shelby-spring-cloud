package io.wegetit.shelby.commons.endpoints.fx;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class FxRate {
    private String id;
    private FxProvider provider;
    private LocalDate date;
    private String source;
    private String target;
    private BigDecimal rate;
}
