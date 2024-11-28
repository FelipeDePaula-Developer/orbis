package com.orbis.controllers;

import com.orbis.entities.Installments;
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

import java.util.List;

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

        if (!contractForm.getInstallments().isEmpty()) {
            return cadInstallments(contractForm);
        }

        return new ResponseEntity<>("Contrato cadastrado", HttpStatus.OK);
    }

    @PostMapping("cad/installments")
    public ResponseEntity cadInstallments(@RequestBody ContractForm contractForm){
        ContractFormResult contractFormResult = contractServices.registerInstallments(contractForm.getInstallments());

        if (contractFormResult.hasErrors())
            return new ResponseEntity<>(contractFormResult.getInstallmentsErrors(), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>("Percelas cadastradas", HttpStatus.OK);
    }
}
