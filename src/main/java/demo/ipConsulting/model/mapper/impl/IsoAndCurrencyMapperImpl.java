package demo.ipConsulting.model.mapper.impl;

import demo.ipConsulting.model.dto.RestCountriesResponse;
import demo.ipConsulting.model.entity.Country;
import demo.ipConsulting.model.entity.Currency;
import demo.ipConsulting.model.mapper.IsoAndCurrencyMapper;

import java.util.Optional;

public class IsoAndCurrencyMapperImpl implements IsoAndCurrencyMapper {

    @Override
    public Country apply(Optional<RestCountriesResponse> restCountriesResponse) {
        if (restCountriesResponse.isEmpty() || restCountriesResponse.get().getCurrencies().get(0).getCode().isEmpty()) {
            throw new RuntimeException("Response or Currency code is empty");
        }

        // TODO: Check if a country has more than one currency
        Currency currency = Currency.builder()
                .code(restCountriesResponse.get().getCurrencies().get(0).getCode())
                .build();

        return Country.builder()
                .name(restCountriesResponse.get().getName())
                .currency(currency)
                .build();
    }
}
