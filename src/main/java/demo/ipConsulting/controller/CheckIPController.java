package demo.ipConsulting.controller;

import demo.ipConsulting.model.entity.Adress;
import demo.ipConsulting.usecase.CountryDataOrchestratorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
@AllArgsConstructor
public class CheckIPController {

    CountryDataOrchestratorUseCase countryDataOrchestratorUseCase;
    LinkedList queue;

    @GetMapping("/checkip/{ip}")
    public Adress apply(@PathVariable String ip) {

        // TODO: We could use AWS queues here (in case we expect a lot of traffic)
        // I will just use a java linkedList instead

        Adress response = null;
        queue.offer(ip);

        while (queue.peek() != null) {
            response = countryDataOrchestratorUseCase.createAddressObject(ip);
        }
        return response;
    }
}
