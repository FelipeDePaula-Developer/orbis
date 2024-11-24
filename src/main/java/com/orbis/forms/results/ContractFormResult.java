package com.orbis.forms.results;

import java.util.ArrayList;
import java.util.List;

public class ContractFormResult {

    private final List<ValidationError> contractErros = new ArrayList<>();
    private final List<ValidationError> installmentsErrors = new ArrayList<>();

    public List<ValidationError> getContractErrors() {
        return new ArrayList<>(contractErros);
    }

    public void addContractError(String field, String message) {
        contractErros.add(new ValidationError(field, message));
    }

    public List<ValidationError> getInstallmentsErrors() {
        return new ArrayList<>(installmentsErrors);
    }

    public void addInstallmentsError(String field, String message) {
        installmentsErrors.add(new ValidationError(field, message));
    }

    public boolean hasErrors() {
        return !contractErros.isEmpty() || !installmentsErrors.isEmpty();
    }

    public List<ValidationError> getAllErrors() {
        List<ValidationError> allErrors = new ArrayList<>(contractErros);
        allErrors.addAll(installmentsErrors);
        return allErrors;
    }
}
