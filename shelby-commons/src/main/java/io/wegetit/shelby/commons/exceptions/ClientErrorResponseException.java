package io.wegetit.shelby.commons.exceptions;

import io.wegetit.shelby.commons.config.error.ErrorResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClientErrorResponseException extends RuntimeException {

    private ErrorResponse response;

    @Override
    public String getMessage() {
        return response.toString();
    }
}
