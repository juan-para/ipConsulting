package demo.ipConsulting.usecase.database.impl;

import demo.ipConsulting.gateway.database.service.DataBaseGenericTableService;
import demo.ipConsulting.model.dataBase.DataBaseGenericTable;
import demo.ipConsulting.usecase.database.AddBlockedIP;
import demo.ipConsulting.util.IPAddressValidator;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AddBlockedIPImpl implements AddBlockedIP {

    DataBaseGenericTableService dataBaseGenericTableService;

    @Override
    public void blockIP(@NonNull String ip) {
        // ip has the correct format
        if (!IPAddressValidator.isValidIPAddress(ip)) {
            throw new RuntimeException();
        }

        try {
            dataBaseGenericTableService.saveOrUpdateData(DataBaseGenericTable.builder()
                    .ip(ip)
                    .blocked(true)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
