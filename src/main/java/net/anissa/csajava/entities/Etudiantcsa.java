package net.anissa.csajava.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity @NoArgsConstructor @AllArgsConstructor
@Table(name = "etudiantcsa")
public class Etudiantcsa {
    @Id
    @Column(name = "no_etudiant_nat", nullable = false, length = 50)
    private String noEtudiantNat;

    @Column(name = "annee_pro", nullable = false)
    private String anneePro;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;

    @Column(name = "date_naissance", nullable = false)
    private LocalDate dateNaissance;

}