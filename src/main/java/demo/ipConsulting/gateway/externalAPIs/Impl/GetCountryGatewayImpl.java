
package demo.ipConsulting.gateway.externalAPIs.Impl;

import demo.ipConsulting.gateway.externalAPIs.GetCountryGateway;
import demo.ipConsulting.model.dto.IpToCountryResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class GetCountryGatewayImpl implements GetCountryGateway {
    // https://api.ip2country.info/ip?5.6.7.8

    @Value("${external-api.ip-to-country.base-url}")
    private String baseURL;
    private static final String resourceURI = "/ip";
    private RestTemplate restTemplate;

    @Override
    public Optional<IpToCountryResponse> retrieveCountryByIP(@NonNull String ip) {

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

