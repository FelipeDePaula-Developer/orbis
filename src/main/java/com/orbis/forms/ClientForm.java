package com.orbis.forms;

import com.orbis.entities.Address;
import com.orbis.entities.Client;
import com.orbis.entities.PhoneNumber;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClientForm {
    private Client client = new Client();
    private List<PhoneNumber> phone = new ArrayList<>();
    private Address address = new Address();
}
