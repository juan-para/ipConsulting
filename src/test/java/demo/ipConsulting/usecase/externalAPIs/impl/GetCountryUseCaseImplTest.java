package demo.ipConsulting.usecase.externalAPIs.impl;

import demo.ipConsulting.gateway.externalAPIs.GetCountryGateway;
import demo.ipConsulting.model.dto.IpToCountryResponse;
import demo.ipConsulting.usecase.externalAPIs.GetCountryUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class GetCountryUseCaseImplTest {

    @Test
    void WhenNullArgument_ThenRaiseException() {
        // Given
        GetCountryGateway gateway = mock(GetCountryGateway.class);
        GetCountryUseCase useCase = new GetCountryUseCaseImpl(gateway);

        // When
        Executable executable = () -> useCase.retrieveCountryByIP(null);

        // Then
        assertThrows(NullPointerException.class, executable, "IP should not be null");
    }

    @Test
    void WhenRetrieveCountryIsOk_ThenReturnCountry() {
        // Given
        String ip = "5.6.7.8";
        GetCountryGateway gateway = mock(GetCountryGateway.class);
        GetCountryUseCase useCase = new GetCountryUseCaseImpl(gateway);

        Optional<IpToCountryResponse> ipToCountryResponse = Optional.ofNullable(IpToCountryResponse.builder()
                .countryCode("DE")
                .countryCode3("DEU")
                .build());

        // When
        when(gateway.retrieveCountryByIP(anyString())).thenReturn(ipToCountryResponse);

        // Then
        assertEquals(useCase.retrieveCountryByIP(ip).getIso2(), ipToCountryResponse.get().getCountryCode(),
                "Failed to create the response object ISO2");
        assertEquals(useCase.retrieveCountryByIP(ip).getIso3(), ipToCountryResponse.get().getCountryCode3(),
                "Failed to create the response object ISO3");
    }
}