package demo.ipConsulting.usecase.impl;

import demo.ipConsulting.gateway.externalAPIs.GetFixerGateway;
import demo.ipConsulting.model.dto.FixerResponse;
import demo.ipConsulting.model.entity.Rates;
import demo.ipConsulting.model.mapper.CurrencyMapper;
import demo.ipConsulting.model.mapper.impl.CurrencyMapperImpl;
import demo.ipConsulting.usecase.GetCurrencyUseCase;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class GetCurrencyUseCaseImpl implements GetCurrencyUseCase {

    GetFixerGateway getFixerGateway;

    @Override
    public Rates retrieveCurrenciesRatesByCurrencyCode(@NonNull String currecyCode) {
        // External API invocation
        Optional<FixerResponse> response = getFixerGateway.retrieveCountryISOsAndCurrency(currecyCode);

        //Mapper invocation
        CurrencyMapper currencyMapper = new CurrencyMapperImpl();
        Rates rates = currencyMapper.apply(response, currecyCode);

        return rates;
    }
}
