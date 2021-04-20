package demo.ipConsulting.usecase.externalAPIs;

import demo.ipConsulting.model.entity.Country;
import lombok.NonNull;

@FunctionalInterface
public interface GetISOAndCurrencyUseCase {
    Country retrieveISOAndCurrencyByCountryName(@NonNull String countryName);
}
