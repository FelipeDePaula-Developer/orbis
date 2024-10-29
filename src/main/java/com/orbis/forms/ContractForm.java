package com.orbis.forms;

import com.orbis.entities.Client;
import com.orbis.entities.Contract;
import com.orbis.entities.Credential;
import com.orbis.entities.Installments;
import com.orbis.entities.PhoneNumber;
import com.orbis.entities.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ContractForm {
//    private Client client = new Client();
    private Contract contract = new Contract();
    private List<Installments> installments = new ArrayList<>();
}
