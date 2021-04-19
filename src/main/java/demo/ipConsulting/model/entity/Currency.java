package demo.ipConsulting.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class Currency {
    private String code;
    private String name;
    private Rates rates;

    public Currency(){
        super();
    }
}
