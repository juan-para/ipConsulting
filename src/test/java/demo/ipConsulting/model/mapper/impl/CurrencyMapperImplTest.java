package demo.ipConsulting.model.mapper.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import demo.ipConsulting.exception.IPAddressException;
import demo.ipConsulting.model.dto.FixerResponse;
import demo.ipConsulting.model.entity.Rates;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CurrencyMapperImplTest {

    @Test
    void GivenNullResponse_thenRaiseException() {
        // Given
        CurrencyMapperImpl currencyMapperImpl = new CurrencyMapperImpl();

        // When
        Executable executable = () -> currencyMapperImpl.apply(null, "ARS");

        // Then
        assertThrows(IPAddressException.class, executable, "Response should be null");
    }

    @Test
    void GivenOKResponse_thenReturnRates() {
        // Given
        String currencyCode = "ARS";
        CurrencyMapperImpl currencyMapperImpl = new CurrencyMapperImpl();
        Rates rates = Rates.builder()
                .eur(2.0f)
                .usd(2.5f)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode ratesNode = mapper.convertValue(rates, JsonNode.class);
        ((ObjectNode) ratesNode).put("USD", 1.55f);
        ((ObjectNode) ratesNode).put(currencyCode, 1.5f);

        Optional<FixerResponse> fixerResponse = Optional.ofNullable(FixerResponse.builder()
                .rates(ratesNode)
                .build());

        // When
        Executable executable = () -> currencyMapperImpl.apply(fixerResponse, "ARS");

        // Then
        assertDoesNotThrow(executable);
    }
}