package com.orbis.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAddress;

    @Column
    private String cep;

    @Column
    private String address;

    @Column
    private String numberAddress;

    @Column
    private String complementaryAddress;

    @Column
    private String district;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String nameAddress;

    @Column(columnDefinition = "CHAR(1) default 'T'", length = 1, nullable = false)
    private String status = "T";

    @ManyToOne
    @JoinColumn(name = "idclient", referencedColumnName = "idclient")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;

}
