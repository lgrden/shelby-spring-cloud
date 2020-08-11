package io.wegetit.shelby.commons.endpoints.refdata;

import lombok.Data;

@Data
public class City {
   private Integer geonameid;
    private String name;
    private String country;
    private String region;
}
