package demo.ipConsulting.usecase.impl;

import demo.ipConsulting.gateway.externalAPIs.GetRestCountriesGateway;
import demo.ipConsulting.model.dto.RestCountriesResponse;
import demo.ipConsulting.model.entity.Country;
import demo.ipConsulting.model.mapper.IsoAndCurrencyMapper;
import demo.ipConsulting.model.mapper.impl.IsoAndCurrencyMapperImpl;
import demo.ipConsulting.usecase.GetISOAndCurrencyUseCase;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class GetISOAndCurrencyUseCaseImpl implements GetISOAndCurrencyUseCase {

    GetRestCountriesGateway getRestCountriesGateway;

    @Override
    public Country retrieveISOAndCurrencyByCountryName(@NonNull String countryName) {

        // External API invocation
        final Optional<RestCountriesResponse> response = getRestCountriesGateway
                .retrieveCountryISOsAndCurrency(countryName);

        //Mapper invocation
        IsoAndCurrencyMapper mapper = new IsoAndCurrencyMapperImpl();
        Country country = mapper.apply(response);

        // Business Logic
        return country;
    }
}
