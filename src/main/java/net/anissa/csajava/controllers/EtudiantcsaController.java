package net.anissa.csajava.controllers;

import net.anissa.csajava.entities.Etudiantcsa;
import net.anissa.csajava.services.EtudiantcsaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/etudiantcsa")
public class EtudiantcsaController {
    @Autowired
    private EtudiantcsaService etudiantcsaService;

    @GetMapping
    public ResponseEntity<List<Etudiantcsa>> getAllEtudiantcsas() {
        List<Etudiantcsa> etudiantcsas = etudiantcsaService.getAllEtudiantcsas();
        return new ResponseEntity<>(etudiantcsas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiantcsa> getEtudiantcsaById(@PathVariable String id) {
        Optional<Etudiantcsa> etudiantcsa = etudiantcsaService.getEtudiantcsaById(id);
        return etudiantcsa.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Etudiantcsa> saveEtudiantcsa(@RequestBody Etudiantcsa etudiantcsa) {
        Etudiantcsa savedEtudiantcsa = etudiantcsaService.saveEtudiantcsa(etudiantcsa);
        return new ResponseEntity<>(savedEtudiantcsa, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiantcsa(@PathVariable String id) {
        etudiantcsaService.deleteEtudiantcsa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiantcsa> updateEtudiantcsa(@PathVariable String id, @RequestBody Etudiantcsa updatedEtudiantcsa) {
        try {
            Etudiantcsa updatedEtudiant = etudiantcsaService.updateEtudiantcsa(id, updatedEtudiantcsa);
            return new ResponseEntity<>(updatedEtudiant, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
