package model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
@JsonDeserialize(builder = IpToCountryResponse.IpToCountryResponseBuilder.class)
public class IpToCountryResponse {
    private final String countryName;

    @JsonPOJOBuilder(withPrefix = "")
    public static class IpToCountryResponseBuilder{}
}
