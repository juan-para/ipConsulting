package demo.ipConsulting.usecase;

import demo.ipConsulting.model.entity.Adress;
import lombok.NonNull;

@FunctionalInterface
public interface CountryDataOrchestrator {
    Adress createAddressObject(@NonNull String ip);
}
