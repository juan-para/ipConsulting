package demo.ipConsulting.controller;

import demo.ipConsulting.usecase.database.AddBlockedIPUseCase;
import demo.ipConsulting.usecase.orchestrator.CountryDataOrchestratorUseCase;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.mockito.Mockito.mock;

class BlockIPControllerTest {

    @Test
    void whenBodyIsMissing_thenReturnBadRequest() {

        // Given
        final var useCase = new BlockIPController(null);


        // When
        Executable executable = () -> useCase.createAddressObject(ip);
        // Then

    }
}