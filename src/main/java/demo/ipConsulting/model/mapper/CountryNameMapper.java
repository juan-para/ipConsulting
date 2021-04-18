package demo.ipConsulting.model.mapper;

import demo.ipConsulting.model.dto.IpToCountryResponse;
import demo.ipConsulting.model.entity.Country;

import java.util.Optional;
import java.util.function.Function;

public interface CountryNameMapper extends Function<Optional<IpToCountryResponse>, Country> {
}
