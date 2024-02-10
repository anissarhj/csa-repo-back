package net.anissa.csajava.repositories;

import net.anissa.csajava.entities.Etudiantcsa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantcsaRepository extends JpaRepository<Etudiantcsa, String> {

}

