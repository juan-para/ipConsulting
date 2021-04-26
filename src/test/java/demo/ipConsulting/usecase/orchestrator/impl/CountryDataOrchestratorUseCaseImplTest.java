package demo.ipConsulting.usecase.orchestrator.impl;

import demo.ipConsulting.exception.IPAddressException;
import demo.ipConsulting.model.entity.Adress;
import demo.ipConsulting.model.entity.Country;
import demo.ipConsulting.model.entity.Currency;
import demo.ipConsulting.model.entity.Rates;
import demo.ipConsulting.usecase.database.AddCheckIPUseCase;
import demo.ipConsulting.usecase.database.CheckIpRecordUseCase;
import demo.ipConsulting.usecase.database.impl.AddCheckIPUseCaseImpl;
import demo.ipConsulting.usecase.database.impl.CheckIpRecordUseCaseImpl;
import demo.ipConsulting.usecase.externalAPIs.GetCountryUseCase;
import demo.ipConsulting.usecase.externalAPIs.GetCurrencyUseCase;
import demo.ipConsulting.usecase.externalAPIs.GetISOAndCurrencyUseCase;
import demo.ipConsulting.usecase.externalAPIs.impl.GetCountryUseCaseImpl;
import demo.ipConsulting.usecase.externalAPIs.impl.GetCurrencyUseCaseImpl;
import demo.ipConsulting.usecase.externalAPIs.impl.GetISOAndCurrencyUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CountryDataOrchestratorUseCaseImplTest {

    /*


     */

    @Test
    void givenIpNull_thenRaiseException() {
        // Given
        CountryDataOrchestratorUseCaseImpl useCase = new CountryDataOrchestratorUseCaseImpl(
                null, null, null,
                null, null
        );

        // When
        Executable executable = () -> useCase.createAddressObject(null);

        // Then
        assertThrows(NullPointerException.class, executable, "IP should not be null");
    }

    @Test
    void givenBadIpFormat_thenRaiseException() {
        // Given
        CountryDataOrchestratorUseCaseImpl useCase = new CountryDataOrchestratorUseCaseImpl(
                null, null, null,
                null, null
        );

        // When
        Executable executable = () -> useCase.createAddressObject("256.-1.5.0577");

        // Then
        assertThrows(IPAddressException.class, executable, "Ip format is incorrect");
    }

    @Test
    void givenOkIpParameter_thenCallRetrieveCountryAPI() {
        // Given
        final String ip = "192.168.0.1";
        GetCountryUseCase getCountryUseCase = mock(GetCountryUseCaseImpl.class);
        GetISOAndCurrencyUseCase getISOAndCurrencyUseCase = mock(GetISOAndCurrencyUseCaseImpl.class);
        GetCurrencyUseCase getCurrencyUseCase = mock(GetCurrencyUseCaseImpl.class);
        AddCheckIPUseCase addCheckIPUseCase = mock(AddCheckIPUseCaseImpl.class);
        CheckIpRecordUseCase checkIpRecordUseCase = mock(CheckIpRecordUseCaseImpl.class);

        CountryDataOrchestratorUseCaseImpl useCase = new CountryDataOrchestratorUseCaseImpl(
                getCountryUseCase, getISOAndCurrencyUseCase, getCurrencyUseCase,
                addCheckIPUseCase, checkIpRecordUseCase
        );

        // When
        when(getCountryUseCase.retrieveCountryByIP(anyString())).thenReturn(Country.builder()
                .iso2("AR")
                .iso3("ARG")
                .build());
        when(getISOAndCurrencyUseCase.retrieveISOAndCurrencyByCountryName(anyString()))
                .thenReturn(Country.builder()
                        .name("Argentina")
                        .currency(Currency.builder()
                                .code("ARS")
                                .build())
                        .build());
        when(getCurrencyUseCase.retrieveCurrenciesRatesByCurrencyCode("ARS"))
                .thenReturn(Rates.builder()
                        .eur(1f)
                        .usd(2f)
                        .build());

        // Then
        useCase.createAddressObject(ip);
        verify(getCountryUseCase, times(1)).retrieveCountryByIP(ip);
        verify(addCheckIPUseCase, times(1)).AddAddress(any(Adress.class));
    }


    private Country createCountry() {
        Rates rates = Rates.builder()
                .usd(0.00089607335f)
                .eur(0.00074089575f)
                .build();
        Currency currency = Currency.builder()
                .code("KRW")
                .rates(rates)
                .build();
        return Country.builder()
                .name("KOREA")
                .iso2("KR")
                .iso3("KOR")
                .currency(currency)
                .build();
    }

}