package demo.ipConsulting.gateway.externalAPIs.Impl;

import demo.ipConsulting.gateway.externalAPIs.GetRestCountriesGateway;
import demo.ipConsulting.model.dto.RestCountriesResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Component
public class GetRestCountriesGatewayImpl implements GetRestCountriesGateway {

    // TODO: Check the documentation for a more performance request like
    //  https://restcountries.eu/rest/v2/all?fields=name;capital;currencies

    // https://restcountries.eu/rest/v2/alpha/us

    private final String baseURL = "https://restcountries.eu/rest/v2";
    private static final String resourceURI = "/alpha/{alphaCode}";
    private final RestTemplate restTemplate;

    @Override
    public Optional<RestCountriesResponse> retrieveCountryISOsAndCurrency(@NonNull String alphaCode) {

        Optional<RestCountriesResponse> optional = null;

        try {
            final var endpoint = UriComponentsBuilder.fromHttpUrl(baseURL)
                    .path(resourceURI)
                    .build().toUriString();

            final var params = Map.of("alphaCode", alphaCode);

            optional = Optional.of(
                    restTemplate.getForEntity(
                            endpoint,
                            RestCountriesResponse.class,
                            params))
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
