package com.fisa.workmanager.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PeerEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evaluatee_id", referencedColumnName = "e_id")
    private Employee evaluatee;

    @ManyToOne
    @JoinColumn(name = "evaluator_id", referencedColumnName = "e_id")
    private Employee evaluator;

    private Integer score;

    private String comment;
}
