package demo.ipConsulting.usecase.database;

import demo.ipConsulting.model.dto.CheckIPResponse;
import demo.ipConsulting.model.entity.Adress;
import lombok.NonNull;

@FunctionalInterface
public interface AddCheckIPUseCase {
    CheckIPResponse AddAddress(@NonNull Adress adress);
}
