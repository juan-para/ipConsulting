package demo.ipConsulting.gateway.Impl;

import demo.ipConsulting.gateway.GetFixerGateway;
import demo.ipConsulting.model.dto.FixerResponse;
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
public class GetFixerGatewayImpl implements GetFixerGateway {

    // http://data.fixer.io/api/latest?access_key=b88b9a0158807bba377d1f219797b7b0&symbols=USD,ARS&format=1

    // TODO: Move this info to an environment variable:  @Value(${...}) + aplication.yml
    private final String accessKey = "b88b9a0158807bba377d1f219797b7b0";

    private final String baseURL = "http://data.fixer.io/api/";
    private static final String resourceURI = "/latest";
    private final RestTemplate restTemplate;

    @Override
    public Optional<FixerResponse> retrieveCountryISOsAndCurrency(@NonNull String currencyCode) {
        Optional<FixerResponse> optional = null;

        try {
            final var endpoint = UriComponentsBuilder.fromHttpUrl(baseURL)
                    .path(resourceURI)
                    .queryParam("access_key", accessKey)
                    .build().toUriString();

            if(!currencyCode.equals("USD")){
                currencyCode = "USD, " + currencyCode;
            }
            final var params = Map.of(
                    "symbols", currencyCode,
                    "format", 1);

            // TODO: Jackson fails HERE
            optional = Optional.of(
                    restTemplate.getForEntity(
                            endpoint,
                            FixerResponse.class,
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
