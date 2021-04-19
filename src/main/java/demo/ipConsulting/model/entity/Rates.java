package demo.ipConsulting.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Rates {
    private final float usd;
    private final float eur; //TODO: Check how to separate this value (because is loaded dynamic and jackson doesn't know)
}
