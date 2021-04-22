package demo.ipConsulting.usecase.orchestrator.impl;

import demo.ipConsulting.exception.IPAddressException;
import demo.ipConsulting.model.entity.Adress;
import demo.ipConsulting.model.entity.Country;
import demo.ipConsulting.model.entity.Currency;
import demo.ipConsulting.model.entity.Rates;
import demo.ipConsulting.usecase.database.AddCheckIPUseCase;
import demo.ipConsulting.usecase.database.CheckIpRecordUseCase;
import demo.ipConsulting.usecase.externalAPIs.GetCountryUseCase;
import demo.ipConsulting.usecase.externalAPIs.GetCurrencyUseCase;
import demo.ipConsulting.usecase.externalAPIs.GetISOAndCurrencyUseCase;
import demo.ipConsulting.usecase.orchestrator.CountryDataOrchestratorUseCase;
import demo.ipConsulting.util.IPAddressValidator;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CountryDataOrchestratorUseCaseImpl implements CountryDataOrchestratorUseCase {

    GetCountryUseCase getCountryUseCase;
    GetISOAndCurrencyUseCase getISOAndCurrencyUseCase;
    GetCurrencyUseCase getCurrencyUseCase;
    AddCheckIPUseCase addCheckIPUseCase;
    CheckIpRecordUseCase checkIpRecordUseCase;

    @Override
    public Adress createAddressObject(@NonNull String ip) {

        // ip has the correct format
        if (!IPAddressValidator.isValidIPAddress(ip)) {
            throw new IPAddressException("IP does not match regex");
        }

        // If exist IP with all the fields already loaded, then i do not consume the APIs
        if (checkIpRecordUseCase.checkIpExistence(ip)) {
            throw new IPAddressException("IP already in the database");
        }

        // API call: Get the ISOs properties
        Country countryISOs = null;
        try {
            countryISOs = getCountryUseCase.retrieveCountryByIP(ip);
        } catch (Exception e) {
            throw new IPAddressException("Error when calling the use case GetCountryUseCaseImpl", e);
        }

        // API call: Get the currency and Country name by ISO
        Country countryNameAndCurrency;
        try {
            if (!countryISOs.getIso2().isEmpty()) {
                countryNameAndCurrency = getISOAndCurrencyUseCase.retrieveISOAndCurrencyByCountryName(
                        countryISOs.getIso2());
            } else {
                countryNameAndCurrency = getISOAndCurrencyUseCase.retrieveISOAndCurrencyByCountryName(
                        countryISOs.getIso3());
            }
        } catch (Exception e) {
            throw new IPAddressException("Error when calling the use case GetISOAndCurrencyUseCaseImpl", e);
        }

        // API call: Get the rates for the currency
        Rates rates = null;
        try {
            rates = getCurrencyUseCase.retrieveCurrenciesRatesByCurrencyCode(countryNameAndCurrency
                    .getCurrency().getCode());
        } catch (Exception e) {
            throw new IPAddressException("Error when calling the use case GetCurrencyUseCaseImpl", e);
        }

        // Create the Adress object
        Currency currency = Currency.builder()
                .code(countryNameAndCurrency.getCurrency().getCode())
                .rates(rates)
                .build();

        Country country = Country.builder()
                .name(countryNameAndCurrency.getName())
                .currency(currency)
                .iso2(countryISOs.getIso2())
                .iso3(countryISOs.getIso3())
                .build();

        Adress adress = Adress.builder()
                .country(country)
                .ip(ip)
                .build();

        addCheckIPUseCase.AddAddress(adress);

        // TODO: Store the value in the data base (CHECK IF the IP already exist in the db before calling the APIs)

        // TODO: Add Return string?
        // TODO: Add Test
        // TODO: Check cuntries with more than one currency
        // TODO: Check Errors, use restControllerAdvice (MainExceptionHandler.class controller package)
        // TODO: Add docker file and how to run it
        // TODO: Add security?
        // TODO: If the country already exist in the database, skip the respective api call

        //TODO: Change the return object
        return adress;
    }
}
