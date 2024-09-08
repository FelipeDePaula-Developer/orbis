package com.orbis.entities;

import com.orbis.entities.interfaces.Person;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity(name = "sys_user")
public class User implements Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

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