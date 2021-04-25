package demo.ipConsulting.gateway.externalAPIs.Impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.ResponseActions;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

class GetCountryGatewayImplTest {
    private static final String wellFormedResponse = ""
            + "{%n"
            + "    \"countryCode\": \"DE\",%n"
            + "    \"countryCode3\": \"DEU\",%n"
            + "    \"countryName\": \"Germany\",%n"
            + "    \"countryEmoji\": \"🇩🇪\"%n"
            + "}";

    @Test
    void whenIPIsNUll_thenReturnRaiseException() {
        // Given
        final GetCountryGatewayImpl getCountryGateway = new GetCountryGatewayImpl(null);

        // When
        Executable executable = () -> getCountryGateway.retrieveCountryByIP(null);

        // Then
        assertThrows(NullPointerException.class, executable, "IP should not be null");
    }

    @Test
    void whenCallingExternalAPI_thenReturnResponse() {
        // https://api.ip2country.info/ip?5.6.7.8

        // Given
        final String ip = "5.6.7.8";
        final String host = "https://api.ip2country.info/ip?";
        final RestTemplate restTemplate = new RestTemplate();

        final var mockServer = MockRestServiceServer.createServer(restTemplate);
        buildResponseActions(mockServer, host, ip)
                .andRespond(
                        withSuccess()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(String.format(wellFormedResponse))
                );
        final var gateway = new GetCountryGatewayImpl(restTemplate);

        // When
        final var returned = gateway.retrieveCountryByIP(ip);

        // Then
        assertNotNull(returned, "The response must not be null");
        mockServer.verify();
    }

    private static ResponseActions buildResponseActions(
            final MockRestServiceServer mockServer,
            final String host,
            final String ip) {
        return mockServer.expect(MockRestRequestMatchers.requestToUriTemplate(host + ip))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.GET));
    }
}
