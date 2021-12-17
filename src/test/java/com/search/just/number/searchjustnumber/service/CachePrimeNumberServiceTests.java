package com.search.just.number.searchjustnumber.service;

import com.search.just.number.searchjustnumber.dao.NumberDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource("/application-test.properties")
@Sql(value = {"/script.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class CachePrimeNumberServiceTests {

    @Autowired
    private NumberDao numberDao;

    private CachePrimeNumberService cachePrimeNumberService;

    @BeforeEach
    void setUp() {
        cachePrimeNumberService = new CachePrimeNumberServiceImpl(numberDao);
    }

    @Test
    void addingNewPrimes() {
        cachePrimeNumberService.addPrimeNumber(List.of(2, 3, 5, 7, 11, 13, 19, 23), 13);

        assertThat(numberDao.getMaxPrimaryNumber()).isEqualTo(23);
    }

    @Test
    void checksDatabaseContent() {
        cachePrimeNumberService.addPrimeNumber(List.of(2, 3, 5, 7, 11, 13, 19, 23), 13);

        assertThat(cachePrimeNumberService.getPrimeNumber(21)).isEqualTo(19);
    }
}
