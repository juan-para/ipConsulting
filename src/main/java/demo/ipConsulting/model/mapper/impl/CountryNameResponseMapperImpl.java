package demo.ipConsulting.model.mapper.impl;

import demo.ipConsulting.model.dataBase.DataBaseGenericTable;
import demo.ipConsulting.model.dto.CheckIPResponse;
import demo.ipConsulting.model.mapper.CountryNameResponseMapper;

public class CountryNameResponseMapperImpl implements CountryNameResponseMapper {

    @Override
    public CheckIPResponse apply(DataBaseGenericTable dataBaseGenericTable) {
        return CheckIPResponse.builder()
                .countryName(dataBaseGenericTable.getCountryName())
                .alpha2(dataBaseGenericTable.getAlpha2())
                .alpha3(dataBaseGenericTable.getAlpha3())
                .currencyCode(dataBaseGenericTable.getCurrencyCode())
                .build();
    }
}
