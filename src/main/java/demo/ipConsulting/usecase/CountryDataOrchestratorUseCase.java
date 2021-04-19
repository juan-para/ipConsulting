package demo.ipConsulting.usecase;

import demo.ipConsulting.model.entity.Adress;
import lombok.NonNull;

@FunctionalInterface
public interface CountryDataOrchestratorUseCase {
    Adress createAddressObject(@NonNull String ip);
}
