package net.anissa.csajava.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "element_constitutif")
public class ElementConstitutif {
    @EmbeddedId
    private ElementConstitutifId id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "code_formation", referencedColumnName = "code_formation", nullable = false),
            @JoinColumn(name = "code_ue", referencedColumnName = "code_ue", nullable = false)
    })
    private UniteEnseignement uniteEnseignement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_enseignant")
    private Enseignant noEnseignant;

    @Column(name = "designation", nullable = false, length = 64)
    private String designation;

    @Column(name = "description", nullable = false, length = 240)
    private String description;

    @Column(name = "nbh_cm")
    private Short nbhCm;

    @Column(name = "nbh_td")
    private Short nbhTd;

    @Column(name = "nbh_tp")
    private Short nbhTp;

}