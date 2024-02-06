package net.anissa.csajava.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "unite_enseignement")
public class UniteEnseignement {
    @EmbeddedId
    private UniteEnseignementId id;

    @MapsId("codeFormation")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "code_formation", nullable = false)
    private Formation codeFormation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_enseignant")
    private Enseignant noEnseignant;

    @Column(name = "designation", nullable = false, length = 64)
    private String designation;

    @Column(name = "semestre", nullable = false, length = 3)
    private String semestre;

    @Column(name = "description", length = 256)
    private String description;

    @Column(name = "nbh_cm")
    private Integer nbhCm;

    @Column(name = "nbh_td")
    private Short nbhTd;

    @Column(name = "nbh_tp")
    private Short nbhTp;

}