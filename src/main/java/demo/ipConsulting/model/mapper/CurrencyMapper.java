package demo.ipConsulting.model.mapper;

import demo.ipConsulting.model.dto.FixerResponse;
import demo.ipConsulting.model.entity.Rates;

import java.util.Optional;

public interface CurrencyMapper {
    public Rates apply(Optional<FixerResponse> fixerResponse, String currecyCode);
}
