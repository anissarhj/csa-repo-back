package net.anissa.csajava.ServiceTest;

import net.anissa.csajava.entities.Etudiantcsa;
import net.anissa.csajava.repositories.EtudiantcsaRepository;
import net.anissa.csajava.services.EtudiantcsaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class EtudiantcsaServiceTest {

    @Mock
    private EtudiantcsaRepository etudiantcsaRepository;

    @InjectMocks
    private EtudiantcsaService etudiantcsaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEtudiantcsas() {
        Etudiantcsa etudiant1 = new Etudiantcsa("1", "2022", "John", "Doe", LocalDate.of(2000, 1, 1));
        Etudiantcsa etudiant2 = new Etudiantcsa("2", "2022", "Jane", "Doe", LocalDate.of(2001, 2, 2));
        List<Etudiantcsa> etudiantList = Arrays.asList(etudiant1, etudiant2);

        when(etudiantcsaRepository.findAll()).thenReturn(etudiantList);

        List<Etudiantcsa> result = etudiantcsaService.getAllEtudiantcsas();

        assertEquals(etudiantList, result);
    }

    @Test
    void testGetEtudiantcsaById() {
        String id = "1";
        Etudiantcsa etudiant = new Etudiantcsa(id, "2022", "John", "Doe", LocalDate.of(2000, 1, 1));
        Optional<Etudiantcsa> optionalEtudiant = Optional.of(etudiant);

        when(etudiantcsaRepository.findById(id)).thenReturn(optionalEtudiant);

        Optional<Etudiantcsa> result = etudiantcsaService.getEtudiantcsaById(id);

        assertEquals(optionalEtudiant, result);
    }

    @Test
    void testSaveEtudiantcsa() {
        Etudiantcsa etudiant = new Etudiantcsa("1", "2022", "John", "Doe", LocalDate.of(2000, 1, 1));

        when(etudiantcsaRepository.save(etudiant)).thenReturn(etudiant);

        Etudiantcsa result = etudiantcsaService.saveEtudiantcsa(etudiant);

        assertEquals(etudiant, result);
    }

    @Test
    void testDeleteEtudiantcsa() {
        String id = "1";

        etudiantcsaService.deleteEtudiantcsa(id);

        verify(etudiantcsaRepository, times(1)).deleteById(id);
    }

    @Test
    void testUpdateEtudiantcsa() {
        String id = "1";
        Etudiantcsa existingEtudiant = new Etudiantcsa(id, "2022", "John", "Doe", LocalDate.of(2000, 1, 1));
        Etudiantcsa updatedEtudiant = new Etudiantcsa(id, "2022", "Updated John", "Updated Doe", LocalDate.of(2000, 1, 1));

        when(etudiantcsaRepository.findById(id)).thenReturn(Optional.of(existingEtudiant));
        when(etudiantcsaRepository.save(existingEtudiant)).thenReturn(existingEtudiant);

        Etudiantcsa result = etudiantcsaService.updateEtudiantcsa(id, updatedEtudiant);

        assertEquals(updatedEtudiant.getNom(), result.getNom());
        assertEquals(updatedEtudiant.getPrenom(), result.getPrenom());
    }

    @Test
    void testUpdateEtudiantcsaNotFound() {
        String id = "1";
        Etudiantcsa updatedEtudiant = new Etudiantcsa(id, "2022", "Updated John", "Updated Doe", LocalDate.of(2000, 1, 1));

        when(etudiantcsaRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> etudiantcsaService.updateEtudiantcsa(id, updatedEtudiant));
    }
}
