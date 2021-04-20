package demo.ipConsulting.usecase.database;

import demo.ipConsulting.model.dataBase.DataBaseGenericTable;
import lombok.NonNull;

@FunctionalInterface
public interface SaveDataUseCase {
    void saveData(@NonNull DataBaseGenericTable dataBaseGenericTable);
}
