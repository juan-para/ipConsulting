package demo.ipConsulting.usecase.impl;

import demo.ipConsulting.model.entity.Adress;
import demo.ipConsulting.model.entity.Country;
import demo.ipConsulting.usecase.CountryDataOrchestrator;
import demo.ipConsulting.usecase.GetCountryUseCase;
import demo.ipConsulting.usecase.GetISOAndCurrencyUseCase;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CountryDataOrchestratorImpl implements CountryDataOrchestrator {

    GetCountryUseCase getCountryUseCase;
    GetISOAndCurrencyUseCase getISOAndCurrencyUseCase; //debo llamar al caso de uso

    @Override
    public Adress createAdressObject(@NonNull String ip) {

        // API call: Get the ISOs properties
        final Country countryISOs = getCountryUseCase.retrieveCountryByIP(ip);

        // API call: Get the currency and Country name by ISO
        if (!countryISOs.getIso2().isEmpty()) {
            final Country countryNameAndCurrency = getISOAndCurrencyUseCase.retrieveISOAndCurrencyByCountryName(
                    countryISOs.getIso2());
        } else {
            final Country countryNameAndCurrency = getISOAndCurrencyUseCase.retrieveISOAndCurrencyByCountryName(
                    countryISOs.getIso3());
        }

        // API call: Get the rates for the currency

        // Create the Adress object

        // TODO: Create this object when calling the final API
        /*Country country = Country.builder()
                .name(countryNameAndCurrency.getName())
                .currency(countryNameAndCurrency.getCurrency())
                .iso2(countryISOs.getIso2())
                .iso3(countryISOs.getIso3())
                .build();
        System.out.println(country.toString());*/

        // Store the value in the data base (check if the IP already exist in the db before calling the APIs)

        //TODO: Change the return object
        return null;
    }


}
