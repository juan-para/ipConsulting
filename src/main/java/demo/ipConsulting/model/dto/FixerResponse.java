package demo.ipConsulting.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import demo.ipConsulting.model.entity.Rates;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
@JsonDeserialize(builder = FixerResponse.FixerResponseBuilder.class)
public class FixerResponse {
    private final Rates rates;

    @JsonPOJOBuilder(withPrefix = "")
    public static class FixerResponseBuilder {
    }
}
