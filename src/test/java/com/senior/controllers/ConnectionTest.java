package com.senior.controllers;

import com.senior.controller.TesteController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TesteController.class)
public class ConnectionTest {

    @Autowired
    private MockMvc mock;

    @Test
    public void testConnection() throws Exception {
        mock.perform(get("/test?name=Teste"))
                .andExpect(content().string("Testando, Teste"));
    }
}
