package demo.ipConsulting.model.mapper;

import demo.ipConsulting.model.dataBase.DataBaseGenericTable;
import demo.ipConsulting.model.dto.BlockIPResponse;

import java.util.function.Function;

public interface BlockIPResponseMapper extends Function<DataBaseGenericTable, BlockIPResponse> {
}
