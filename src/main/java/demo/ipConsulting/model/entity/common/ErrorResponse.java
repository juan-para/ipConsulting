package demo.ipConsulting.model.entity.common;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class ErrorResponse {

    private final String errorType;
    private final String description;
}
