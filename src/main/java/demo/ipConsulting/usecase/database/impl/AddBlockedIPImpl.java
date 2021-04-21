package demo.ipConsulting.usecase.database.impl;

import demo.ipConsulting.exception.IPAddressException;
import demo.ipConsulting.gateway.database.service.DataBaseGenericTableService;
import demo.ipConsulting.model.dataBase.DataBaseGenericTable;
import demo.ipConsulting.model.dto.BlockIPResponse;
import demo.ipConsulting.model.mapper.BlockIPResponseMapper;
import demo.ipConsulting.model.mapper.impl.BlockIPResponseMapperImpl;
import demo.ipConsulting.usecase.database.AddBlockedIP;
import demo.ipConsulting.util.IPAddressValidator;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AddBlockedIPImpl implements AddBlockedIP {

    DataBaseGenericTableService dataBaseGenericTableService;

    @Override
    public BlockIPResponse blockIP(@NonNull String ip) {
        BlockIPResponse blockIPResponse = null;

        // ip has the correct format
        if (!IPAddressValidator.isValidIPAddress(ip)) {
            throw new IPAddressException("IP does not match regex");
        }

        try {
            final DataBaseGenericTable dataBaseGenericTable = dataBaseGenericTableService.saveOrUpdateData(
                    DataBaseGenericTable
                            .builder()
                            .ip(ip)
                            .blocked(true)
                            .build()
            );

            BlockIPResponseMapper mapper = new BlockIPResponseMapperImpl();
            blockIPResponse = mapper.apply(dataBaseGenericTable);

        } catch (Exception e) {
            throw new IPAddressException("Error when calling the use case DataBaseGenericTableServiceImpl", e);
        }

        return blockIPResponse;
    }
}
