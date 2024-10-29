package com.orbis.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Installments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInstallments;

    @ManyToOne
    @JoinColumn(name = "idcontract", referencedColumnName = "idcontract")
    private Contract contract;

    @Column
    private DecimalFormat value;

    @Column
    private DecimalFormat interest;

    @Column
    private DecimalFormat fine;

    @Column
    private String sequence;

    @Column
    private String status;

    @Column(columnDefinition = "CHAR(1)", length = 1)
    private String statusFlag;

    @Column(columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP", name = "createdAt")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date updatedAt;
    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }
}
