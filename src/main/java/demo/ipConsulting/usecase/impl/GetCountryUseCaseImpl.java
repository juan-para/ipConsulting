package demo.ipConsulting.usecase.impl;

import demo.ipConsulting.gateway.externalAPIs.GetCountryGateway;
import demo.ipConsulting.model.dto.IpToCountryResponse;
import demo.ipConsulting.model.entity.Country;
import demo.ipConsulting.model.mapper.CountryNameMapper;
import demo.ipConsulting.model.mapper.impl.CountryNameMapperImpl;
import demo.ipConsulting.usecase.GetCountryUseCase;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class GetCountryUseCaseImpl implements GetCountryUseCase {

    private final GetCountryGateway getCountryGateway;

    @Override
    public Country retrieveCountryByIP(@NonNull String ip) {

        // External API invocation
        // United States: 198.41.0.4
        // Germany:       5.6.7.8
        Optional<IpToCountryResponse> response = getCountryGateway.retrieveCountryByIP(ip);

        //Mapper invocation
        CountryNameMapper countryNameMapper = new CountryNameMapperImpl();
        Country country = countryNameMapper.apply(response);

        // Business Logic
        return country;
    }
}
