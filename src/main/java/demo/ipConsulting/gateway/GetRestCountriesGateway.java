package demo.ipConsulting.gateway;

import demo.ipConsulting.model.dto.RestCountriesResponse;
import lombok.NonNull;

import java.util.Optional;

@FunctionalInterface
public interface GetRestCountriesGateway {
    Optional<RestCountriesResponse> retrieveCountryISOsAndCurrency(@NonNull String countryCode);
}
