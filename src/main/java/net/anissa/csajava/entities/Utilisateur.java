package net.anissa.csajava.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "identifiant", nullable = false)
    private String identifiant;

    @Column(name = "mot_de_passe", nullable = false)
    private String motDePasse;

}