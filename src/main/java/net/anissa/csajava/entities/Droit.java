package net.anissa.csajava.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "droit")
public class Droit {
    @EmbeddedId
    private DroitId id;

    @MapsId("idEvaluation")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_evaluation", nullable = false)
    private Evaluation idEvaluation;

    @MapsId("noEnseignant")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "no_enseignant", nullable = false)
    private Enseignant noEnseignant;

    @Column(name = "consultation", nullable = false, length = Integer.MAX_VALUE)
    private String consultation;

    @Column(name = "duplication", nullable = false, length = Integer.MAX_VALUE)
    private String duplication;

}