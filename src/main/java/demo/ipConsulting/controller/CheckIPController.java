package demo.ipConsulting.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import demo.ipConsulting.model.entity.Adress;
import demo.ipConsulting.usecase.orchestrator.CountryDataOrchestratorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CheckIPController {

    CountryDataOrchestratorUseCase countryDataOrchestratorUseCase;

    // For example: localhost:8080/checkip/5.6.7.8
    @GetMapping(value = "/checkip/{ip}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Adress> apply(@PathVariable String ip) {
        return ResponseEntity.ok(countryDataOrchestratorUseCase.createAddressObject(ip));
    }
}
