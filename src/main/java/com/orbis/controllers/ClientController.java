package com.orbis.controllers;

import com.orbis.forms.ClientForm;
import com.orbis.forms.results.PersonFormResult;
import com.orbis.services.PersonServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ClientController {

    private final PersonServices personServices;
    @PostMapping("cad/client")
    public ResponseEntity cadClient(@RequestBody ClientForm clientForm){
        PersonFormResult personFormResult =  personServices.registerClient(clientForm);
        if (personFormResult.hasErrors()){
            return new ResponseEntity<>(personFormResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Validation passed", HttpStatus.OK);
    }

}
