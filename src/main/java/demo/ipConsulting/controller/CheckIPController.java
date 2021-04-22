package demo.ipConsulting.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.ipConsulting.model.entity.Adress;
import demo.ipConsulting.usecase.orchestrator.CountryDataOrchestratorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CheckIPController {

    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    CountryDataOrchestratorUseCase countryDataOrchestratorUseCase;

    // For example: localhost:8080/checkip/5.6.7.8
    @GetMapping(value = "/checkip/{ip}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String apply(@PathVariable String ip) throws JsonProcessingException {
        Adress response = countryDataOrchestratorUseCase.createAddressObject(ip);
        return JSON_MAPPER.writeValueAsString(response);
    }
}
