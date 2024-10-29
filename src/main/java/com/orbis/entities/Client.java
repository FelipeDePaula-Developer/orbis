package com.orbis.entities;

import com.orbis.entities.interfaces.Person;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.GenerationType;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Client implements Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;

    @Column(length = 11)
    private String cpf;

    @Column
    private String email;

    @Column(name = "insert_timestamp", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date updatedAt;
    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    @Column
    private String name;

    @Column(length = 1, nullable = false)
    private String status = "T";
}