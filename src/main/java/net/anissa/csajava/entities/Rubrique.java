package net.anissa.csajava.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rubrique")
public class Rubrique {
    @Id
    @Column(name = "id_rubrique", nullable = false)
    private Integer id;

    @Column(name = "type", nullable = false, length = 10)
    private String type;

    @Column(name = "designation", nullable = false, length = 32)
    private String designation;

    @Column(name = "ordre")
    private Integer ordre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_enseignant")
    private Enseignant noEnseignant;

}