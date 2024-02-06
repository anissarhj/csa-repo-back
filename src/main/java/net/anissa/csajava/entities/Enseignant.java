package net.anissa.csajava.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "enseignant")
public class Enseignant {
    @Id
    @Column(name = "no_enseignant", nullable = false)
    private Integer id;

    @Column(name = "type", nullable = false, length = 10)
    private String type;

    @Column(name = "sexe", nullable = false, length = Integer.MAX_VALUE)
    private String sexe;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Column(name = "cp", nullable = false, length = 10)
    private String cp;

    @Column(name = "ville", nullable = false)
    private String ville;

    @Column(name = "pays", nullable = false)
    private String pays;

    @Column(name = "tel_port", length = 20)
    private String telPort;

    @Column(name = "enc_perso_tel", length = 20)
    private String encPersoTel;

    @Column(name = "enc_ubo_tel", length = 20)
    private String encUboTel;

    @Column(name = "enc_perso_email")
    private String encPersoEmail;

    @Column(name = "enc_ubo_email")
    private String encUboEmail;

    @Column(name = "int_no_insee", length = 50)
    private String intNoInsee;

    @Column(name = "int_soc_nom", length = 50)
    private String intSocNom;

    @Column(name = "int_soc_adresse")
    private String intSocAdresse;

    @Column(name = "int_soc_cp", length = 10)
    private String intSocCp;

    @Column(name = "int_soc_ville")
    private String intSocVille;

    @Column(name = "int_soc_pays")
    private String intSocPays;

    @Column(name = "int_fonction", length = 50)
    private String intFonction;

    @Column(name = "int_prof_email")
    private String intProfEmail;

    @Column(name = "int_prof_tel", length = 20)
    private String intProfTel;

}