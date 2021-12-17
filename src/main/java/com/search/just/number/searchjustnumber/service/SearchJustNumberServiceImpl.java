package com.search.just.number.searchjustnumber.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SearchJustNumberServiceImpl implements SearchJustNumberService {

    private final CachePrimeNumberService cachePrimeNumberService;

    public SearchJustNumberServiceImpl(CachePrimeNumberService cachePrimeNumberService) {
        this.cachePrimeNumberService = cachePrimeNumberService;
    }

    @Override
    public int returnedNumberClosestLeft(int number) {
        if (number <= 2) {
            throw new IllegalArgumentException("число должно быть больше 2");
        }
        int maxPrimeNumberCache = cachePrimeNumberService.getMaxPrimeNumber();
        return primeNumberClosestLeft(number, maxPrimeNumberCache);
    }

    private int primeNumberClosestLeft(int number, int maxPrimeNumberCache) {
        int primeNumberClosestLeft;

        if (number <= maxPrimeNumberCache) {
            primeNumberClosestLeft = cachePrimeNumberService.getPrimeNumber(number);
        } else {
            List<Integer> primeNumber = eratosthenesSieve(number);
            primeNumberClosestLeft = primeNumber.isEmpty() ? maxPrimeNumberCache : primeNumber.get(primeNumber.size() - 1);
            if (primeNumberClosestLeft != maxPrimeNumberCache) {
                cachePrimeNumberService.addPrimeNumber(primeNumber, maxPrimeNumberCache);
            }
        }

        return primeNumberClosestLeft;
    }

    private List<Integer> eratosthenesSieve(int number) {
        boolean[] isPrime = new boolean[number];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < number; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j < number; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primeNumber = new ArrayList<>();
        for (int i = 2; i < number; i++) {
            if (isPrime[i]) {
                primeNumber.add(i);
            }
        }

        return primeNumber;
    }

}
