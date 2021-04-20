package demo.ipConsulting;

import demo.ipConsulting.gateway.database.service.DataBaseGenericTableService;
import demo.ipConsulting.model.dataBase.DataBaseGenericTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {
    // This class runs as soon as the proyect is deployed, i use it to generate a couple of records in the database
    // Connection URL: http://localhost:8080/h2-console/

    private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);

    @Autowired
    DataBaseGenericTableService dataBaseGenericTableService;

    @Override
    public void run(String... args) throws Exception {
        log.info("creating some database records");

        dataBaseGenericTableService.save(DataBaseGenericTable.builder()
                .ip("5.6.7.8")
                .countryName("Germany")
                .currencyCode("EUR")
                .alpha2("DE")
                .alpha3("DEU")
                .dollarRate(1.19f)
                .euroRate(1f)
                .blocked(false)
                .build());

        dataBaseGenericTableService.save(DataBaseGenericTable.builder()
                .ip("1.2.3.4")
                .blocked(true)
                .build());
    }
}
