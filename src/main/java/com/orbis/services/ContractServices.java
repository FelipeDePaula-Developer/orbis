package com.orbis.services;

import com.orbis.entities.Contract;
import com.orbis.forms.results.ContractFormResult;
import com.orbis.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServices {

    @Autowired
    private ContractRepository contractRepository;

    public ContractFormResult registerContract(Contract contract){
        ContractFormResult contractFormResult= new ContractFormResult();

        if (checkContractStatus(contract.getStatus())){
            contractFormResult.addContractError("status", "Status ("+contract.getStatus()+") não é valido");
            return contractFormResult;
        }

        contractRepository.save(contract);

        return contractFormResult;
    }

    private Boolean checkContractStatus(String contractStatus) {
        String[] validStatuses = {"INADIMPLENTE", "QUITADO", "CANCELADO"};

        for (String validStatus : validStatuses) {
            if (validStatus.equalsIgnoreCase(contractStatus)) {
                return true;
            }
        }

        return false;
    }
}
