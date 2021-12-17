package com.search.just.number.searchjustnumber.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class SearchJustNumberServiceTests {

    @Mock
    private CachePrimeNumberService cachePrimeNumberService;

    @InjectMocks
    private SearchJustNumberServiceImpl service;

    @Test
    void shouldTrowException() {
        assertThrows(IllegalArgumentException.class, () -> service.returnedNumberClosestLeft(2));
    }

    @Test
    void shouldReturnedNumberClosestLeftWithoutCache() {
        when(cachePrimeNumberService.getMaxPrimeNumber()).thenReturn(19);

        assertThat(service.returnedNumberClosestLeft(25)).isEqualTo(23);
    }

    @Test
    void shouldReturnedNumberClosestLeftFromCache() {
        when(cachePrimeNumberService.getMaxPrimeNumber()).thenReturn(23);
        when(cachePrimeNumberService.getPrimeNumber(anyInt())).thenReturn(19);

        assertThat(service.returnedNumberClosestLeft(20)).isEqualTo(19);
    }

}
