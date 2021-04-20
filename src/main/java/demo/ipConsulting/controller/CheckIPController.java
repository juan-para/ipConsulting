package demo.ipConsulting.controller;

import demo.ipConsulting.model.entity.Adress;
import demo.ipConsulting.usecase.orchestrator.CountryDataOrchestratorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CheckIPController {

    CountryDataOrchestratorUseCase countryDataOrchestratorUseCase;
    //LinkedList queue;

    // For example: localhost:8080/checkip/5.6.7.8
    @GetMapping("/checkip/{ip}")
    public Adress apply(@PathVariable String ip) {

        // TODO: We could use AWS queues in here (in case we expect a lot of traffic)
        // I will just use a java linkedList instead

        /*Adress response = null;
        queue.offer(ip);
        while (queue.peek() != null) {
            response = countryDataOrchestratorUseCase.createAddressObject(ip)
        }*/

        // TODO: Controlar que la ip tenga el formato correcto
        Adress response = countryDataOrchestratorUseCase.createAddressObject(ip);
        return response;
    }
}
