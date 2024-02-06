package net.anissa.csajava.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "formation")
public class Formation {
    @Id
    @Column(name = "code_formation", nullable = false, length = 8)
    private String codeFormation;

    @Column(name = "diplome", nullable = false, length = 3)
    private String diplome;

    @Column(name = "n0_annee", nullable = false)
    private Short n0Annee;

    @Column(name = "nom_formation", nullable = false, length = 64)
    private String nomFormation;

    @Column(name = "double_diplome", nullable = false, length = Integer.MAX_VALUE)
    private String doubleDiplome;

    @Column(name = "debut_habilitation")
    private LocalDate debutHabilitation;

    @Column(name = "fin_habilitation")
    private LocalDate finHabilitation;

}