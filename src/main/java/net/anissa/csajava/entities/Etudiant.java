package net.anissa.csajava.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "etudiant")
public class Etudiant {
    @Id
    @Column(name = "no_etudiant_nat", nullable = false, length = 50)
    private String noEtudiantNat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "annee_pro", nullable = false)
    private Promotion anneePro;

    @Column(name = "code_com", length = 10)
    private String codeCom;

    @Column(name = "no_etudiant_ubo", length = 20)
    private String noEtudiantUbo;

    @Column(name = "sexe", nullable = false, length = Integer.MAX_VALUE)
    private String sexe;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;

    @Column(name = "date_naissance", nullable = false)
    private LocalDate dateNaissance;

    @Column(name = "lieu_naissance", nullable = false)
    private String lieuNaissance;

    @Column(name = "situation", nullable = false, length = 3)
    private String situation;

    @Column(name = "nationalite", nullable = false, length = 50)
    private String nationalite;

    @Column(name = "tel_port", length = 20)
    private String telPort;

    @Column(name = "tel_fixe", length = 20)
    private String telFixe;

    @Column(name = "email")
    private String email;

    @Column(name = "actu_adresse")
    private String actuAdresse;

    @Column(name = "actu_cp", length = 10)
    private String actuCp;

    @Column(name = "actu_ville")
    private String actuVille;

    @Column(name = "actu_pays")
    private String actuPays;

    @Column(name = "perm_adresse", nullable = false)
    private String permAdresse;

    @Column(name = "perm_cp", nullable = false, length = 10)
    private String permCp;

    @Column(name = "perm_ville", nullable = false)
    private String permVille;

    @Column(name = "perm_pays", nullable = false)
    private String permPays;

    @Column(name = "dernier_diplome", nullable = false)
    private String dernierDiplome;

    @Column(name = "universite", nullable = false)
    private String universite;

    @Column(name = "sigle_etu", nullable = false, length = 3)
    private String sigleEtu;

    @Column(name = "compte_cri", nullable = false, length = 10)
    private String compteCri;

    @Column(name = "ubo_email")
    private String uboEmail;

    @Column(name = "grpe_anglais")
    private Short grpeAnglais;

    @Column(name = "abandon_motif")
    private String abandonMotif;

    @Column(name = "abandon_date")
    private LocalDate abandonDate;

    @Column(name = "est_diplome", length = Integer.MAX_VALUE)
    private String estDiplome;

}