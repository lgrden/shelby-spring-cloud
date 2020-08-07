package io.wegetit.shelby.commons.config.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
;

@Getter
@AllArgsConstructor
@Builder
public class ExceptionType {
    private Class<? extends Throwable> errorClass;
    private HttpStatus status;
    private boolean logException;

    public String getCode() {
        String code = errorClass.getSimpleName();
        code = code.replaceAll("()([A-Z])", "$1_$2");
        code = StringUtils.substringAfter(code, "_");
        return code.toUpperCase();
    }
}
