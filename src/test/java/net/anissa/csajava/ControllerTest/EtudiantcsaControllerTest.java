package net.anissa.csajava.ControllerTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.anissa.csajava.CsaJavaApplication;
import net.anissa.csajava.controllers.EtudiantcsaController;
import net.anissa.csajava.entities.Etudiantcsa;
import net.anissa.csajava.services.EtudiantcsaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest(classes = CsaJavaApplication.class)

class EtudiantcsaControllerTest {

    @Mock
    private EtudiantcsaService etudiantcsaService;

    @InjectMocks
    private EtudiantcsaController etudiantcsaController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(etudiantcsaController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testGetAllEtudiantcsas() throws Exception {
        Etudiantcsa etudiant1 = new Etudiantcsa("1", "2022", "John", "Doe", LocalDate.of(2000, 1, 1));
        Etudiantcsa etudiant2 = new Etudiantcsa("2", "2022", "Jane", "Doe", LocalDate.of(2001, 2, 2));
        List<Etudiantcsa> etudiantcsaList = Arrays.asList(etudiant1, etudiant2);

        when(etudiantcsaService.getAllEtudiantcsas()).thenReturn(etudiantcsaList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/etudiantcsa"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(etudiantcsaList.size()));

        verify(etudiantcsaService, times(1)).getAllEtudiantcsas();
    }

    @Test
    void testGetEtudiantcsaById() throws Exception {
        String etudiantId = "1";
        Etudiantcsa etudiant = new Etudiantcsa(etudiantId, "2022", "John", "Doe", LocalDate.of(2000, 1, 1));

        when(etudiantcsaService.getEtudiantcsaById(etudiantId)).thenReturn(Optional.of(etudiant));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/etudiantcsa/{id}", etudiantId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.noEtudiantNat").value(etudiantId));

        verify(etudiantcsaService, times(1)).getEtudiantcsaById(etudiantId);
    }


    @Test
    void testDeleteEtudiantcsa() throws Exception {
        String etudiantId = "1";

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/etudiantcsa/{id}", etudiantId))
                .andExpect(status().isNoContent());

        verify(etudiantcsaService, times(1)).deleteEtudiantcsa(etudiantId);
    }

}

