package demo.ipConsulting.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
@JsonDeserialize(builder = FixerResponse.fixerResponseBuilder.class)
public class FixerResponse {
    private final String USD;
    //private final String USD; // This value is dynamic check how to load it with jackson

    @JsonPOJOBuilder(withPrefix = "")
    public static class fixerResponseBuilder {
    }
}
