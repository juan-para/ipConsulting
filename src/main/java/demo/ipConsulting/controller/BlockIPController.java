package demo.ipConsulting.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.ipConsulting.model.dto.BlockIPResponse;
import demo.ipConsulting.usecase.database.AddBlockedIPUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class BlockIPController {

    private final AddBlockedIPUseCase AddBlockedIPUseCase;

    @GetMapping(value = "/blockip/{ip}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BlockIPResponse> apply(@PathVariable String ip) {
        return ResponseEntity.ok(AddBlockedIPUseCase.blockIP(ip));
    }
}
