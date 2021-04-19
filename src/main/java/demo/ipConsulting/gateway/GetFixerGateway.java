package demo.ipConsulting.gateway;

import demo.ipConsulting.model.dto.FixerResponse;
import lombok.NonNull;

import java.util.Optional;

@FunctionalInterface
public interface GetFixerGateway {
    Optional<FixerResponse> retrieveCountryISOsAndCurrency(@NonNull String currencyCode);
}
