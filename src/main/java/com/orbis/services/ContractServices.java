package com.orbis.services;

import com.orbis.entities.Contract;
import com.orbis.entities.Installments;
import com.orbis.forms.results.ContractFormResult;
import com.orbis.repositories.ContractRepository;
import com.orbis.repositories.InstallmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContractServices {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    InstallmentsRepository installmentsRepository;

    public ContractFormResult registerInstallments(List<Installments> installmentsList){
        ContractFormResult contractFormResult= new ContractFormResult();

        for (Installments installment : installmentsList){
            if (installment.getContract() == null){
                contractFormResult.addInstallmentsError("contract", "É necessário informar o contrato responsável pela parcela " + installment.getInstallmentNumber() + ".");
                continue;
            }
            installmentsRepository.save(installment);
        }

        return contractFormResult;
    }

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
