package com.orbis.controllers;

import com.orbis.forms.ContractForm;
import com.orbis.forms.results.ContractFormResult;
import com.orbis.services.ContractServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ContractController {

    @Autowired
    private ContractServices contractServices;

    @PostMapping("cad/contract")
    public ResponseEntity cadContract(@RequestBody ContractForm contractForm){
        ContractFormResult contractFormResult = contractServices.registerContract(contractForm.getContract());
        if (contractFormResult.hasErrors())
            return new ResponseEntity<>(contractFormResult.getContractErrors(), HttpStatus.BAD_REQUEST);


        return new ResponseEntity<>("Validation passed", HttpStatus.OK);
    }

}
