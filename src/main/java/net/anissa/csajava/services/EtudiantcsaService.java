package net.anissa.csajava.services;

import net.anissa.csajava.entities.Etudiantcsa;
import net.anissa.csajava.repositories.EtudiantcsaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantcsaService {

    @Autowired
    private EtudiantcsaRepository etudiantcsaRepository;

    public List<Etudiantcsa> getAllEtudiantcsas() {
        return etudiantcsaRepository.findAll();
    }

    public Optional<Etudiantcsa> getEtudiantcsaById(String id) {
        return etudiantcsaRepository.findById(id);
    }

    public Etudiantcsa saveEtudiantcsa(Etudiantcsa etudiantcsa) {
        return etudiantcsaRepository.save(etudiantcsa);
    }

    public void deleteEtudiantcsa(String id) {
        etudiantcsaRepository.deleteById(id);
    }

    public Etudiantcsa updateEtudiantcsa(String id, Etudiantcsa updatedEtudiantcsa) {
        Optional<Etudiantcsa> existingEtudiantcsa = etudiantcsaRepository.findById(id);

        if (existingEtudiantcsa.isPresent()) {
            Etudiantcsa etudiantcsaToUpdate = existingEtudiantcsa.get();
            etudiantcsaToUpdate.setNom(updatedEtudiantcsa.getNom());
            etudiantcsaToUpdate.setPrenom(updatedEtudiantcsa.getPrenom());
            etudiantcsaToUpdate.setAnneePro(updatedEtudiantcsa.getAnneePro());
            etudiantcsaToUpdate.setDateNaissance(updatedEtudiantcsa.getDateNaissance());

            return etudiantcsaRepository.save(etudiantcsaToUpdate);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Étudiant non trouvé avec l'ID: " + id
            );
        }
    }
}
