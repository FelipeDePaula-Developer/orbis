package com.orbis.controlllers;

import com.orbis.entities.Client;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ClientController {

    @PostMapping("cad/client")
    public ResponseEntity cadClient(@RequestBody Client client){

        if ()

        return new ResponseEntity<>("Validation passed", HttpStatus.OK);
    }

}
