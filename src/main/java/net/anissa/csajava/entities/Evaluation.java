package net.anissa.csajava.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "evaluation")
public class Evaluation {
    @Id
    @Column(name = "id_evaluation", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "no_enseignant", nullable = false)
    private Enseignant noEnseignant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "code_formation", referencedColumnName = "code_formation", nullable = false),
            @JoinColumn(name = "code_ue", referencedColumnName = "code_ue", nullable = false),
            @JoinColumn(name = "code_ec", referencedColumnName = "code_ec", nullable = false)
    })
    private ElementConstitutif elementConstitutif;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "annee_pro", nullable = false)
    private Promotion anneePro;

    @Column(name = "no_evaluation", nullable = false)
    private Integer noEvaluation;

    @Column(name = "etat", nullable = false, length = 3)
    private String etat;

    @Column(name = "periode", length = 64)
    private String periode;

    @Column(name = "debut_reponse", nullable = false)
    private LocalDate debutReponse;

    @Column(name = "fin_reponse", nullable = false)
    private LocalDate finReponse;

}