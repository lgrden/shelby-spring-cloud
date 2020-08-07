package io.wegetit.shelby.commons.config.error;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ErrorResponse {
    private long timestamp;
    private int status;
    private String error;
    private String code;
    private String message;
    private String path;
}
