package io.wegetit.shelby.commons.endpoints.security;

import io.wegetit.shelby.commons.model.ActivityStatus;
import lombok.Data;

@Data
public class User {
    private String id;
    private String email;
    private String initials;
    private String fullName;
    private String address;
    private ActivityStatus status;
}
