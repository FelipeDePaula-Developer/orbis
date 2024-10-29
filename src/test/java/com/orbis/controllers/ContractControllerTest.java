package com.orbis.controllers;

import com.orbis.forms.ContractForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class ContractControllerTest {

    private ContractController contractController;

    @BeforeEach
    void setUp() {
        contractController = new ContractController();
    }

    @Test
    void shouldReturnOkWhenContractFormIsValid() {
        // Given: um ContractForm válido
        ContractForm contractForm = mock(ContractForm.class);

        // When: o método cadContract é chamado
        ResponseEntity<String> response = contractController.cadContract(contractForm);

        // Then: o resultado esperado é um ResponseEntity com status HTTP 200 e mensagem "Validation passed"
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Validation passed", response.getBody());
    }
}
