package demo.ipConsulting.usecase.externalAPIs;


import demo.ipConsulting.model.entity.Country;
import lombok.NonNull;

@FunctionalInterface
public interface GetCountryUseCase {
    Country retrieveCountryByIP(@NonNull String ip);
}
