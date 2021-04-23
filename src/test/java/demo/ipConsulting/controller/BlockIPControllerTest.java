package demo.ipConsulting.controller;

import demo.ipConsulting.exception.IPAddressException;
import demo.ipConsulting.model.dto.BlockIPResponse;
import demo.ipConsulting.model.entity.common.ErrorResponse;
import demo.ipConsulting.usecase.database.AddBlockedIPUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class BlockIPControllerTest {

    @Test
    void whenCallingUseCase_thenReturnCorrectResponseType() {
        // Given
        final var ip = "192.168.0.1";
        final var blockIPResponse = mock(BlockIPResponse.class);
        final var useCase = mock(AddBlockedIPUseCase.class);
        final var blockIPController = new BlockIPController(useCase);

        // When
        when(useCase.blockIP(ip)).thenReturn(blockIPResponse);

        // Then
        final var response = useCase.blockIP(ip);
        verify(useCase, times(1)).blockIP(ip);
    }

/*    @Test
    void whenIpIsNotCorrect_thenReturnErrorResponseType() {
        // Given
        final var badIP = "256.256.256.256";
        final var blockIPResponse = mock(BlockIPResponse.class);
        final var useCase = mock(AddBlockedIPUseCase.class);
        final var blockIPController = new BlockIPController(useCase);

        // When

        // Then
        final Executable executable = () -> useCase.blockIP(badIP);
        assertThrows(IPAddressException.class, executable, "IP is incorrect");
    }*/
}