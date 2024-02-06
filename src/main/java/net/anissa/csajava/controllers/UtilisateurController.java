package net.anissa.csajava.controllers;

import net.anissa.csajava.dtos.UtilisateurDTo;
import net.anissa.csajava.entities.Utilisateur;
import net.anissa.csajava.repositories.UtilisateurRepository;
import net.anissa.csajava.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();
        return ResponseEntity.ok(utilisateurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Integer id) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        return ResponseEntity.ok(utilisateur);
    }

    @PostMapping("/register")
    public ResponseEntity<Utilisateur> saveUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur savedUtilisateur = utilisateurService.saveUtilisateur(utilisateur);
        return ResponseEntity.ok(savedUtilisateur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Integer id) {
        utilisateurService.deleteUtilisateur(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UtilisateurDTo credentials) {
        Utilisateur utilisateur = utilisateurRepository.findByIdentifiantAndMotDePasse(credentials.getIdentifiant(), credentials.getMotDePasse());
        if (utilisateur != null) {
            return ResponseEntity.ok("COnnexion Reussie!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identifiant ou mot de passe incorrect");
        }
    }

}