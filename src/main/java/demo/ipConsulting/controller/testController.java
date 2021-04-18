package demo.ipConsulting.controller;

import demo.ipConsulting.usecase.GetCountryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class testController {

    GetCountryUseCase getCountryUseCase;

    @GetMapping("/checkip/{ip}")
    public String apply(@PathVariable String ip) {
        final var response = getCountryUseCase.retrieveCountryByIP(ip);
        return response.toString();
    }
}
