package demo.ipConsulting.model.mapper;

import demo.ipConsulting.model.dataBase.DataBaseGenericTable;
import demo.ipConsulting.model.dto.CheckIPResponse;
import demo.ipConsulting.model.entity.Country;

import java.util.function.Function;

public interface CountryNameResponseMapper extends Function<DataBaseGenericTable, CheckIPResponse> {
}
