package com.search.just.number.searchjustnumber.service;

import com.search.just.number.searchjustnumber.dao.NumberDao;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CachePrimeNumberServiceImpl implements CachePrimeNumberService {

    private final NumberDao numberDao;

    public CachePrimeNumberServiceImpl(NumberDao numberDao) {
        this.numberDao = numberDao;
    }

    @Override
    public int getMaxPrimeNumber() {
        return numberDao.getMaxPrimaryNumber();
    }

    @Override
    public int getPrimeNumber(int number) {
        return numberDao.getPrimaryNumber(number);
    }

    @Override
    public void addPrimeNumber(List<Integer> primeNumber, int maxPrimeNumber) {
        for (Iterator<Integer> it = primeNumber.iterator(); it.hasNext(); ) {
            Integer pn = it.next();
            if (pn > maxPrimeNumber) {
                numberDao.addPrimaryNumber(pn);
            }
        }
    }
}
