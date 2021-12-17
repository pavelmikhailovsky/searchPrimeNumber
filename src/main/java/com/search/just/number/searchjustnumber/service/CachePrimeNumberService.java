package com.search.just.number.searchjustnumber.service;

import java.util.List;

public interface CachePrimeNumberService {

    int getMaxPrimeNumber();

    int getPrimeNumber(int number);

    void addPrimeNumber(List<Integer> primeNumber, int maxPrimeNumber);

}
