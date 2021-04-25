package demo.ipConsulting.model.mapper.impl;

import demo.ipConsulting.exception.IPAddressException;
import demo.ipConsulting.model.dto.FixerResponse;
import demo.ipConsulting.model.entity.Rates;
import demo.ipConsulting.model.mapper.CurrencyMapper;

import java.util.Optional;

public class CurrencyMapperImpl implements CurrencyMapper {

    @Override
    public Rates apply(Optional<FixerResponse> fixerResponse, String currencyCode) {
        if (fixerResponse.isEmpty() || fixerResponse.get().getRates().isEmpty()) {
            throw new RuntimeException("Response is not present");
        }

        try {
        /*--Example COP:
                "base": "EUR",
                "rates": {
                    "USD": 1.196032,
                    "COP": 4333.497053
        */
            float rateUSD = 0;
            float rateEUR = 0;
            float dollarEuroRate = Float.parseFloat(fixerResponse.get().getRates()
                    .findValues("USD").get(0).toString());
            float secondCurrencyEuroRate = Float.parseFloat(fixerResponse.get().getRates()
                    .findValues(currencyCode).get(0).toString());

            rateEUR = 1 / secondCurrencyEuroRate;
            rateUSD = rateEUR * dollarEuroRate;

            return Rates.builder()
                    .usd(rateUSD)
                    .eur(rateEUR)
                    .build();
        } catch (Exception e) {
            throw new IPAddressException("Error when mapping the Rates");
        }
    }
}
