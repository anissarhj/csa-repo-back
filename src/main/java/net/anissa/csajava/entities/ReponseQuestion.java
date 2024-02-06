package net.anissa.csajava.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reponse_question")
public class ReponseQuestion {
    @Id
    @Column(name = "id_reponse_question", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_reponse_question", nullable = false)
    private ReponseEvaluation reponseEvaluation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_question_evaluation", nullable = false)
    private QuestionEvaluation idQuestionEvaluation;

    @Column(name = "positionnement")
    private Integer positionnement;

}