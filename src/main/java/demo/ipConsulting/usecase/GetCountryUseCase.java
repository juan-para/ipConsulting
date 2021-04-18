package demo.ipConsulting.usecase;


import demo.ipConsulting.model.entity.Country;
import lombok.NonNull;

@FunctionalInterface
public interface GetCountryUseCase {
    Country retrieveCountryByIP(@NonNull String ip);
}
