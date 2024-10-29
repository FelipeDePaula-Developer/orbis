package com.orbis.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContract;

    @ManyToOne
    @JoinColumn(name = "idclient", referencedColumnName = "idclient")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;

    @Column
    private DecimalFormat valueTotal;

    @Column
    private DecimalFormat interestTotal;

    @Column
    private DecimalFormat fineTotal;

    @Column
    private DecimalFormat outStandingBalance;

    @Column
    private Date originalDueDate;

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
