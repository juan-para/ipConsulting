package demo.ipConsulting.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
@JsonDeserialize(builder = RestCountriesResponse.restCountriesResponseBuilder.class)
public class RestCountriesResponse {
    private final String code;

    @JsonPOJOBuilder(withPrefix = "")
    public static class restCountriesResponseBuilder {
    }
}
