package demo.ipConsulting.gateway.externalAPIs;

import demo.ipConsulting.model.dto.IpToCountryResponse;
import lombok.NonNull;

import java.util.Optional;

@FunctionalInterface
public interface GetCountryGateway {
    Optional<IpToCountryResponse> retrieveCountryByIP(@NonNull String ip);
}
