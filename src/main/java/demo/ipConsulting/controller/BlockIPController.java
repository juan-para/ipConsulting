package demo.ipConsulting.controller;

import demo.ipConsulting.usecase.database.AddBlockedIP;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BlockIPController {

    AddBlockedIP AddBlockedIP;

    @GetMapping("/blockip/{ip}")
    public HttpStatus apply(@PathVariable String ip) {
        AddBlockedIP.blockIP(ip);
        return HttpStatus.OK;
    }
}
