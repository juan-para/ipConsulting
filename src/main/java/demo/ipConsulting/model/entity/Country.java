package demo.ipConsulting.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Country {
    private final String name;
    private final String iso2;
    private final String iso3;
    private final Currency currency;
}
