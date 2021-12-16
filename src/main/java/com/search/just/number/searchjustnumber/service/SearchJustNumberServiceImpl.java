package com.search.just.number.searchjustnumber.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SearchJustNumberServiceImpl implements SearchJustNumberService {
    @Override
    public int returnedNumberClosestLeft(int number) {
        List<Integer> primeNumber = eratosthenesSieve(number);
        return primeNumber.get(primeNumber.size() - 1);
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
