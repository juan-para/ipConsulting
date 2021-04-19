package demo.ipConsulting.usecase;

import demo.ipConsulting.model.entity.Rates;
import lombok.NonNull;

@FunctionalInterface
public interface GetCurrencyUseCase {
    Rates retrieveCurrenciesRatesByCurrencyCode(@NonNull String currecyCode);
}
