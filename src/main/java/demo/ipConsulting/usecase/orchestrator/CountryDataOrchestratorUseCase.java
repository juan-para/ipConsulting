package demo.ipConsulting.usecase.orchestrator;

import demo.ipConsulting.model.entity.Adress;
import lombok.NonNull;

@FunctionalInterface
public interface CountryDataOrchestratorUseCase {
    Adress createAddressObject(@NonNull String ip);
}
