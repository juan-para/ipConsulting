package demo.ipConsulting.usecase;

import demo.ipConsulting.model.entity.Country;
import lombok.NonNull;

@FunctionalInterface
public interface GetISOAndCurrencyUseCase {
    Country retrieveISOAndCurrencyByCountryName(@NonNull String countryName);
}
