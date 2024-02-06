package net.anissa.csajava.repositories;

import net.anissa.csajava.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Utilisateur findByIdentifiantAndMotDePasse(String identifiant, String motDePasse);
}
