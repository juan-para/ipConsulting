package demo.ipConsulting.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import demo.ipConsulting.model.entity.Currency;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@EqualsAndHashCode
@JsonDeserialize(builder = RestCountriesResponse.RestCountriesResponseBuilder.class)
public class RestCountriesResponse {
    private final String name;
    private final List<Currency> currencies;

    @JsonPOJOBuilder(withPrefix = "")
    public static class RestCountriesResponseBuilder {
    }
}
