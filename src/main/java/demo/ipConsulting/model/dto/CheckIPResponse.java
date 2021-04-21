package demo.ipConsulting.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
@JsonDeserialize(builder = CheckIPResponse.CheckIPResponseBuilder.class)
public class CheckIPResponse {

    private final String ip;
    private final String countryName;
    private final String currencyCode;
    private final String alpha2;
    private final String alpha3;
    private final float dollarRate;
    private final float euroRate;

    @JsonPOJOBuilder(withPrefix = "")
    public static class CheckIPResponseBuilder {
    }
}
