package net.anissa.csajava.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "promotion")
public class Promotion {
    @Id
    @Column(name = "annee_pro", nullable = false, length = 10)
    private String anneePro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_formation")
    private Formation codeFormation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_enseignant")
    private Enseignant noEnseignant;

    @Column(name = "sigle_pro", nullable = false, length = 5)
    private String siglePro;

    @Column(name = "nb_etu_souhaite", nullable = false)
    private Short nbEtuSouhaite;

    @Column(name = "etat_preselection", nullable = false, length = 3)
    private String etatPreselection;

    @Column(name = "date_rentree")
    private LocalDate dateRentree;

    @Column(name = "lieu_rentree")
    private String lieuRentree;

    @Column(name = "date_reponse_lp")
    private LocalDate dateReponseLp;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "date_reponse_lalp")
    private LocalDate dateReponseLalp;

    @Column(name = "processus_stage", length = 5)
    private String processusStage;

    @Column(name = "no_evaluation")
    private Integer noEvaluation;

    @Column(name = "no_bareme")
    private Integer noBareme;

}