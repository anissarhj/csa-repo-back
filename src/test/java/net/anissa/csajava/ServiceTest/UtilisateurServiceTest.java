package net.anissa.csajava.ServiceTest;
import net.anissa.csajava.entities.Utilisateur;
import net.anissa.csajava.repositories.UtilisateurRepository;
import net.anissa.csajava.services.UtilisateurService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UtilisateurServiceTest {

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @InjectMocks
    private UtilisateurService utilisateurService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUtilisateurs() {
        Utilisateur utilisateur1 = new Utilisateur();
        Utilisateur utilisateur2 = new Utilisateur();
        List<Utilisateur> utilisateurList = Arrays.asList(utilisateur1, utilisateur2);

        when(utilisateurRepository.findAll()).thenReturn(utilisateurList);

        List<Utilisateur> result = utilisateurService.getAllUtilisateurs();

        assertEquals(utilisateurList, result);
    }

    @Test
    void testGetUtilisateurById() {
        Integer userId = 1;
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(userId);

        when(utilisateurRepository.findById(userId)).thenReturn(Optional.of(utilisateur));

        Utilisateur result = utilisateurService.getUtilisateurById(userId);

        assertEquals(utilisateur, result);
    }

    @Test
    void testSaveUtilisateur() {
        Utilisateur utilisateur = new Utilisateur();

        when(utilisateurRepository.save(utilisateur)).thenReturn(utilisateur);

        Utilisateur result = utilisateurService.saveUtilisateur(utilisateur);

        assertEquals(utilisateur, result);
    }

    @Test
    void testDeleteUtilisateur() {
        Integer userId = 1;

        utilisateurService.deleteUtilisateur(userId);

        verify(utilisateurRepository, times(1)).deleteById(userId);
    }
}
