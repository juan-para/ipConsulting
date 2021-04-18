package demo.ipConsulting.model.mapper;

import demo.ipConsulting.model.dto.RestCountriesResponse;
import demo.ipConsulting.model.entity.Country;

import java.util.Optional;
import java.util.function.Function;

public interface IsoAndCurrencyMapper extends Function<Optional<RestCountriesResponse>, Country> {
}
