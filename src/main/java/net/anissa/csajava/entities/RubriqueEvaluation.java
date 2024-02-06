package net.anissa.csajava.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rubrique_evaluation")
public class RubriqueEvaluation {
    @Id
    @Column(name = "id_rubrique_evaluation", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_evaluation", nullable = false)
    private Evaluation idEvaluation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rubrique")
    private Rubrique idRubrique;

    @Column(name = "ordre", nullable = false)
    private Integer ordre;

    @Column(name = "designation", length = 64)
    private String designation;

}