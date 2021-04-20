package demo.ipConsulting.gateway.database;

import demo.ipConsulting.model.dataBase.DataBaseGenericTable;
import lombok.NonNull;

@FunctionalInterface
public interface SaveDataGateway {
    void saveData(@NonNull DataBaseGenericTable dataBaseGenericTable);
}
