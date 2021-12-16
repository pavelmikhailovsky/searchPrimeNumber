package com.search.just.number.searchjustnumber.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SearchJustNumberServiceTests {

    private SearchJustNumberServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new SearchJustNumberServiceImpl();
    }

    @Test
    void shouldReturnedNumberClosestLeft() {
        assertThat(service.returnedNumberClosestLeft(25)).isEqualTo(23);
    }

    @Test
    void checksIfReturnIncorrect() {
        assertThat(service.returnedNumberClosestLeft(8)).isNotEqualTo(3);
    }

}
