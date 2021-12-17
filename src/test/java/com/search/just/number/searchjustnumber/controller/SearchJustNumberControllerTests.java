package com.search.just.number.searchjustnumber.controller;

import com.search.just.number.searchjustnumber.service.CachePrimeNumberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/script.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class SearchJustNumberControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CachePrimeNumberService cachePrimeNumberService;

    @Test
    void shouldReturnLastPrimeNumber() throws Exception {
        mockMvc.perform(get("/{number}", 20))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.prime-number", is(19)));
    }

    @Test
    void shouldReturnException() throws Exception {
        mockMvc.perform(get("/{number}", 2))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.exception", is("число должно быть больше 2")));
    }

    @Test
    void returnCachePrimeNumber() throws Exception {
        mockMvc.perform(get("/{number}", 100))
                .andExpect(status().isOk());

        assertThat(cachePrimeNumberService.getPrimeNumber(50)).isEqualTo(47);

        mockMvc.perform(get("/{number}", 50))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.prime-number", is(47)));
    }

}
