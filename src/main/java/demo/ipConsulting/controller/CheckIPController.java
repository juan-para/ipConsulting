package demo.ipConsulting.controller;

import demo.ipConsulting.usecase.CountryDataOrchestrator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CheckIPController {

    CountryDataOrchestrator countryDataOrchestrator;

    @GetMapping("/checkip/{ip}")
    public String apply(@PathVariable String ip) {
        final var response = countryDataOrchestrator.createAddressObject(ip);
        return response.toString();
    }
}
