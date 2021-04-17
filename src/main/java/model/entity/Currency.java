package model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Currency {
    // Base currency is EURO
    private final String name;
    private final Rates rates;
}
