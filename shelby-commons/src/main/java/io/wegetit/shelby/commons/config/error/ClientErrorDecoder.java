package io.wegetit.shelby.commons.config.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import io.wegetit.shelby.commons.exceptions.ClientErrorResponseException;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

@AllArgsConstructor
public class ClientErrorDecoder implements ErrorDecoder {

    private ObjectMapper mapper;

    @Override
    public Exception decode(String s, Response response) {
        try {
            String body = IOUtils.toString(response.body().asInputStream());
            ErrorResponse errorResponse = mapper.readValue(body, ErrorResponse.class);
            return new ClientErrorResponseException(errorResponse);
        } catch (IOException e) {
            return e;
        }
    }
}
