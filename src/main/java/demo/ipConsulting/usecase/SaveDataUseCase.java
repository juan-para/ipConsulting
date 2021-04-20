package demo.ipConsulting.usecase;

import demo.ipConsulting.model.dataBase.DataBaseGenericTable;
import lombok.NonNull;

@FunctionalInterface
public interface SaveDataUseCase {
    void saveData(@NonNull DataBaseGenericTable dataBaseGenericTable);
}
