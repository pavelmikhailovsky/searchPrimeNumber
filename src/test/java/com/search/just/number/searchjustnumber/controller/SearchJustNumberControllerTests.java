package com.search.just.number.searchjustnumber.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SearchJustNumberControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnLastPrimeNumber() throws Exception {
        mockMvc.perform(get("/{number}", 20))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.prime-number", is(19)));
    }

    @Test
    void t() throws Exception {
        mockMvc.perform(get("/{number}", 19))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.prime-number", not(19)));
    }

}
