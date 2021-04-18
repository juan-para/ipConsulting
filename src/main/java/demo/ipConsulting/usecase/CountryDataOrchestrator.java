package demo.ipConsulting.usecase;

import demo.ipConsulting.model.entity.Adress;
import lombok.NonNull;

@FunctionalInterface
public interface CountryDataOrchestrator {
    Adress createAdressObject(@NonNull String ip);
}
