package com.fisa.workmanager.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder @ToString
@Getter @Setter
@Entity
public class PmCustomerEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "p_id", referencedColumnName = "p_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "evaluatee_id", referencedColumnName = "e_id")
    private Employee evaluatee;

    @Enumerated(EnumType.STRING)
    private EvaluationType evalType; // PM, CUSTOMER

    private Integer score;

    private String comment;

    public enum EvaluationType {
        PM, CUSTOMER
    }
}
