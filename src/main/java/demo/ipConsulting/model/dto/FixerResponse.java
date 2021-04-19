package demo.ipConsulting.model.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
@JsonDeserialize(builder = FixerResponse.FixerResponseBuilder.class)
public class FixerResponse {
    private final JsonNode rates;

    @JsonPOJOBuilder(withPrefix = "")
    public static class FixerResponseBuilder {
    }
}
