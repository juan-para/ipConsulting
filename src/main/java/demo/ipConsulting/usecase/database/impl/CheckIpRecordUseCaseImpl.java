package demo.ipConsulting.usecase.database.impl;

import demo.ipConsulting.gateway.database.service.DataBaseGenericTableService;
import demo.ipConsulting.model.dataBase.DataBaseGenericTable;
import demo.ipConsulting.usecase.database.CheckIpRecordUseCase;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CheckIpRecordUseCaseImpl implements CheckIpRecordUseCase {

    DataBaseGenericTableService dataBaseGenericTableService;

    @Override
    public boolean checkIpExistence(@NonNull String ip) {
        DataBaseGenericTable getTable = dataBaseGenericTableService.findByIP(ip);

        if (!getTable.getIp().equals("") && getTable != null) {
            return true;
        }
        return false;
    }
}
