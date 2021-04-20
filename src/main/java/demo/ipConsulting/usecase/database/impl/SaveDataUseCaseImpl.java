package demo.ipConsulting.usecase.database.impl;

import demo.ipConsulting.gateway.database.service.DataBaseGenericTableService;
import demo.ipConsulting.model.dataBase.DataBaseGenericTable;
import demo.ipConsulting.usecase.database.SaveDataUseCase;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SaveDataUseCaseImpl implements SaveDataUseCase {

    DataBaseGenericTableService dataBaseGenericTableService;

    @Override
    public void saveData(@NonNull DataBaseGenericTable dataBaseGenericTable) {
        dataBaseGenericTableService.saveOrUpdateData(dataBaseGenericTable);
    }
}
