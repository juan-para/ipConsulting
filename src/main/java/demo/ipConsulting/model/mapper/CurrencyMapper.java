package demo.ipConsulting.model.mapper;

import demo.ipConsulting.model.dto.FixerResponse;
import demo.ipConsulting.model.entity.Rates;

import java.util.Optional;
import java.util.function.Function;

public interface CurrencyMapper extends Function<Optional<FixerResponse>, Rates> {
}
