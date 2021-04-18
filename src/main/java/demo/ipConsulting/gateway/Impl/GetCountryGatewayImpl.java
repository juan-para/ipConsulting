
package demo.ipConsulting.gateway.Impl;

import demo.ipConsulting.gateway.GetCountryGateway;
import demo.ipConsulting.model.dto.IpToCountryResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Component
public class GetCountryGatewayImpl implements GetCountryGateway {
    // https://api.ip2country.info/ip?5.6.7.8

    private final String baseURL = "https://api.ip2country.info";
    private static final String resourceURI = "/ip";
    private final RestTemplate restTemplate;

    @Override
    public Optional<IpToCountryResponse> retrieveCountryByIP(@NonNull String ip){

        Optional<IpToCountryResponse> optional = null;
        
        try {
            final var endpoint = UriComponentsBuilder.fromHttpUrl(baseURL)
                    .path(resourceURI)
                    .queryParam(ip)
                    .build().toUriString();

            optional = Optional.of(
                    restTemplate.getForEntity(
                            endpoint,
                            IpToCountryResponse.class))
                    .map(ResponseEntity::getBody);

            if (optional.isEmpty()) {
                throw new RuntimeException();
            }
         } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return optional;
    }
}

