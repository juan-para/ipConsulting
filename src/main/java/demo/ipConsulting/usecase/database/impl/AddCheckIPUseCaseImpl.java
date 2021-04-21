package demo.ipConsulting.usecase.database.impl;

import demo.ipConsulting.exception.IPAddressException;
import demo.ipConsulting.gateway.database.service.DataBaseGenericTableService;
import demo.ipConsulting.model.dataBase.DataBaseGenericTable;
import demo.ipConsulting.model.dto.CheckIPResponse;
import demo.ipConsulting.model.entity.Adress;
import demo.ipConsulting.model.mapper.CountryNameResponseMapper;
import demo.ipConsulting.model.mapper.impl.CountryNameResponseMapperImpl;
import demo.ipConsulting.usecase.database.AddCheckIPUseCase;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AddCheckIPUseCaseImpl implements AddCheckIPUseCase {

    DataBaseGenericTableService dataBaseGenericTableService;

    @Override
    public CheckIPResponse AddAddress(@NonNull Adress adress) {
        CheckIPResponse checkIPResponse = null;

        try {
            final DataBaseGenericTable temporalDataTable = DataBaseGenericTable.builder()
                    .ip(adress.getIp())
                    .countryName(adress.getCountry().getName())
                    .currencyCode(adress.getCountry().getCurrency().getCode())
                    .alpha2(adress.getCountry().getIso2())
                    .alpha3(adress.getCountry().getIso3())
                    .dollarRate(adress.getCountry().getCurrency().getRates().getUsd())
                    .euroRate(adress.getCountry().getCurrency().getRates().getEur())
                    .build();

            final DataBaseGenericTable dataBaseGenericTable = dataBaseGenericTableService
                    .saveOrUpdateData(temporalDataTable);

            CountryNameResponseMapper mapper = new CountryNameResponseMapperImpl();
            checkIPResponse = mapper.apply(dataBaseGenericTable);

        } catch (Exception e) {
            throw new IPAddressException("Error when calling the use case DataBaseGenericTableServiceImpl", e);
        }

        return checkIPResponse;
    }
}
