package demo.ipConsulting.model.dataBase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class DataBaseGenericTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "IP", unique = true, length = 15) // 123.123.123.123
    private String ip;

    @Column(name = "IS_BLOCKED")
    private boolean blocked;

    @Column(name = "COUNTRY_NAME")
    private String countryName;

    @Column(name = "CURRENCY_CODE")
    private String currencyCode;

    @Column(name = "ISO2", length = 2)
    private String alpha2;

    @Column(name = "ISO3", length = 3)
    private String alpha3;

    @Column(name = "DOLLAR_RATE") // TODO: Check amount of decimals
    private float dollarRate;

    @Column(name = "EURO_RATE")   // Same as dollar_rate
    private float euroRate;
}
