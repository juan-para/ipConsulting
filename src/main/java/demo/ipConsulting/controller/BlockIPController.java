package demo.ipConsulting.controller;

import demo.ipConsulting.model.dataBase.DataBaseGenericTable;
import demo.ipConsulting.model.entity.Adress;
import demo.ipConsulting.usecase.database.SaveDataUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BlockIPController {

    SaveDataUseCase saveDataUseCase;

    @GetMapping("/blockip/{ip}")
    public HttpStatus apply(@PathVariable String ip) {
        try {
            saveDataUseCase.saveData(DataBaseGenericTable.builder()
                    .ip(ip)
                    .blocked(true)
                    .build());
        }catch(Exception e){
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }
}
