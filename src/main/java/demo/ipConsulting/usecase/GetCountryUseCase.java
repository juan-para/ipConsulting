package demo.ipConsulting.usecase;


import demo.ipConsulting.model.dto.IpToCountryResponse;
import lombok.NonNull;

import java.util.Optional;

@FunctionalInterface
public interface GetCountryUseCase {
    Optional<IpToCountryResponse> retrieveCountryByIP(@NonNull String ip);
}
