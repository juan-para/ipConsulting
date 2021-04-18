package demo.ipConsulting.model.mapper.impl;

import demo.ipConsulting.model.dto.IpToCountryResponse;
import demo.ipConsulting.model.entity.Country;
import demo.ipConsulting.model.mapper.CountryNameMapper;

import java.util.Optional;

public class CountryNameMapperImpl implements CountryNameMapper {

    @Override
    public Country apply(Optional<IpToCountryResponse> ipToCountryResponse) {
        if (ipToCountryResponse.isEmpty()) {
            throw new RuntimeException("Response is empty");
        }

        return Country.builder()
                .name(ipToCountryResponse.get().getCountryName())
                .build();
    }
}
