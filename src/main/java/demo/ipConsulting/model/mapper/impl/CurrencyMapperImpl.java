package demo.ipConsulting.model.mapper.impl;

import demo.ipConsulting.model.dto.FixerResponse;
import demo.ipConsulting.model.entity.Rates;
import demo.ipConsulting.model.mapper.CurrencyMapper;

import java.util.Optional;

public class CurrencyMapperImpl implements CurrencyMapper {

    @Override
    public Rates apply(Optional<FixerResponse> fixerResponse) {
        if (fixerResponse.isEmpty()) {
            throw new RuntimeException("Response is not present");
        }

        return Rates.builder()
                .USD(fixerResponse.get().getRates().getUSD())
                //.EUR(fixerResponse.get().)
                .build();
    }
}
