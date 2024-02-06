package net.anissa.csajava.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "question_evaluation")
public class QuestionEvaluation {
    @Id
    @Column(name = "id_question_evaluation", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_rubrique_evaluation", nullable = false)
    private RubriqueEvaluation idRubriqueEvaluation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_question")
    private Question idQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_qualificatif")
    private Qualificatif idQualificatif;

    @Column(name = "ordre", nullable = false)
    private Integer ordre;

    @Column(name = "intitule", length = 64)
    private String intitule;

}