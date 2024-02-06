package net.anissa.csajava.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "question")
public class Question {
    @Id
    @Column(name = "id_question", nullable = false)
    private Integer id;

    @Column(name = "type", nullable = false, length = 10)
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_enseignant")
    private Enseignant noEnseignant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_qualificatif", nullable = false)
    private Qualificatif idQualificatif;

    @Column(name = "intitule", nullable = false, length = 64)
    private String intitule;

}