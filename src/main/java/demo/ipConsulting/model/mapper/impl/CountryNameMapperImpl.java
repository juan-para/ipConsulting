package demo.ipConsulting.model.mapper.impl;

import demo.ipConsulting.exception.IPAddressException;
import demo.ipConsulting.model.dto.IpToCountryResponse;
import demo.ipConsulting.model.entity.Country;
import demo.ipConsulting.model.entity.Currency;
import demo.ipConsulting.model.mapper.CountryNameMapper;

import java.util.Optional;

public class CountryNameMapperImpl implements CountryNameMapper {

    @Override
    public Country apply(Optional<IpToCountryResponse> ipToCountryResponse) {
        if (ipToCountryResponse.isEmpty() || ipToCountryResponse.get().getCountryCode().isEmpty()) {
            throw new IPAddressException("Country name is not present in the response");
        }

        try {
            return Country.builder()
                    .iso2(ipToCountryResponse.get().getCountryCode())
                    .iso3(ipToCountryResponse.get().getCountryCode3())
                    .currency(Currency.builder().build()) // Empty
                    .build();
        } catch (Exception e) {
            throw new IPAddressException("Error when mapping the Country");
        }
    }
}
