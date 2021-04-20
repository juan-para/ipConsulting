package demo.ipConsulting.usecase.externalAPIs;

import demo.ipConsulting.model.entity.Rates;
import lombok.NonNull;

@FunctionalInterface
public interface GetCurrencyUseCase {
    Rates retrieveCurrenciesRatesByCurrencyCode(@NonNull String currecyCode);
}
