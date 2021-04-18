package demo.ipConsulting.usecase.impl;

import demo.ipConsulting.model.entity.Adress;
import demo.ipConsulting.model.entity.Country;
import demo.ipConsulting.usecase.CountryDataOrchestrator;
import demo.ipConsulting.usecase.GetCountryUseCase;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CountryDataOrchestratorImpl implements CountryDataOrchestrator {

    GetCountryUseCase getCountryUseCase;

    @Override
    public Adress createAdressObject(@NonNull String ip) {
        // API call: Get the country name by IP
        final Country partialCountryData = getCountryUseCase.retrieveCountryByIP(ip);

        // API call: Get the iso properties for the country name and currency

        // API call: Get the rates for the currency

        // Create the Adress object

        // Store the value in the data base (check if the IP already exist in the db before calling the APIs)

        //TODO: Change the return object
        return null;
    }


}
