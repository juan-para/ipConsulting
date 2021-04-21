package demo.ipConsulting.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.ipConsulting.usecase.database.AddBlockedIP;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class BlockIPController {

    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    AddBlockedIP AddBlockedIP;

    @GetMapping(value = "/blockip/{ip}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String apply(@PathVariable String ip) throws JsonProcessingException {
        return JSON_MAPPER.writeValueAsString(AddBlockedIP.blockIP(ip));
    }
}
