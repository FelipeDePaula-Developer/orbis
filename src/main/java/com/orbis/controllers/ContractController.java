package com.orbis.controllers;

import com.orbis.forms.ContractForm;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ContractController {
    @PostMapping("cad/contract")
    public ResponseEntity cadContract(@RequestBody ContractForm contractForm){


        return new ResponseEntity<>("Validation passed", HttpStatus.OK);
    }

}
