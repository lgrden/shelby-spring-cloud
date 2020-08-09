package io.wegetit.shelby.commons.config.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@ControllerAdvice
public class GlobalErrorHandler implements ErrorDecoder {

    private static final ExceptionType DEFAULT = ExceptionType.builder()
            .errorClass(Exception.class).status(HttpStatus.INTERNAL_SERVER_ERROR).logException(true).build();

    private final ObjectMapper mapper;

    private final Map<Class<? extends Throwable>, ExceptionType> types = new HashMap<>();

    public GlobalErrorHandler(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public void register(ExceptionType type) {
        types.put(type.getErrorClass(), type);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Throwable e, HttpServletRequest request) {
        ExceptionType type = Optional.ofNullable(types.get(e.getClass())).orElse(DEFAULT);
        if (type.isLogException()) {
            log.error(type.getStatus().getReasonPhrase() + ": " + e.getMessage(), e);
        } else {
            log.error(type.getStatus().getReasonPhrase() + ": " + e.getMessage());
        }
        return new ResponseEntity<>(ErrorResponse.builder()
            .timestamp(System.currentTimeMillis())
            .status(type.getStatus().value())
            .error(type.getStatus().getReasonPhrase())
            .code(type.getCode())
            .message(e.getMessage())
            .path(request.getContextPath() + request.getServletPath())
            .build(), type.getStatus());
    }

    @Override
    public Exception decode(String s, Response resp) {
        try {
            String body = IOUtils.toString(resp.body().asInputStream());
            ErrorResponse response = mapper.readValue(body, ErrorResponse.class);
            ExceptionType type = types. values().stream().filter(p -> StringUtils.equals(p.getCode(), response.getCode())).findFirst().orElse(DEFAULT);
            return (Exception) type.getErrorClass().getDeclaredConstructor(String.class).newInstance(response.getMessage());
        } catch (Exception e) {
            log.info("Problem decoding response", e);
            return e;
        }
    }
}
