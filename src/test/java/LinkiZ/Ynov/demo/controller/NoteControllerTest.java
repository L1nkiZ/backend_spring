package LinkiZ.Ynov.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Lancement du serveur sur un port aléatoire pour faire les tests d'intégration avec un vrai contexte Http
@AutoConfigureMockMvc
public class NoteControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/notes/"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray());

    }
}
