package demo.ipConsulting.model.mapper.impl;

import demo.ipConsulting.model.dataBase.DataBaseGenericTable;
import demo.ipConsulting.model.dto.BlockIPResponse;
import demo.ipConsulting.model.mapper.BlockIPResponseMapper;

public class BlockIPResponseMapperImpl implements BlockIPResponseMapper {

    @Override
    public BlockIPResponse apply(DataBaseGenericTable dataBaseGenericTable) {
        return BlockIPResponse.builder()
                .ip(dataBaseGenericTable.getIp())
                .blockedStatus(dataBaseGenericTable.isBlocked())
                .build();
    }
}
