package io.wegetit.shelby.commons.config.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@ControllerAdvice
public class GlobalErrorHandler {

    private static final ExceptionType DEFAULT = ExceptionType.builder().errorClass(Exception.class).status(HttpStatus.INTERNAL_SERVER_ERROR).logException(true).build();

    private final Map<Class<? extends Throwable>, ExceptionType> types = new HashMap<>();

    public void registerType(ExceptionType type) {
        types.put(type.getErrorClass(), type);
    }

    private Optional<ExceptionType> findExceptionType(Throwable e) {
        return Optional.ofNullable(types.get(e.getClass()));
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Throwable e, HttpServletRequest request) {
        ExceptionType type = findExceptionType(e).orElse(DEFAULT);
        if (type.isLogException()) {
            log.error(type.getStatus().getReasonPhrase() + " : " + e.getMessage(), e);
        } else {
            log.error(type.getStatus().getReasonPhrase() + " : " + e.getMessage());
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
}
