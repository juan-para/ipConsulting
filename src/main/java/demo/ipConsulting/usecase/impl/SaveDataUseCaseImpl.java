package demo.ipConsulting.usecase.impl;

import demo.ipConsulting.gateway.database.SaveDataGateway;
import demo.ipConsulting.model.dataBase.DataBaseGenericTable;
import demo.ipConsulting.usecase.SaveDataUseCase;
import lombok.NonNull;

public class SaveDataUseCaseImpl implements SaveDataUseCase {

    SaveDataGateway saveDataGateway;

    @Override
    public void saveData(@NonNull DataBaseGenericTable dataBaseGenericTable) {
        saveDataGateway.saveData(dataBaseGenericTable);
    }
}
