package com.search.just.number.searchjustnumber.model;

public class PrimeNumberModel {

    private int primeNumbersId;
    private int primeNumber;

    public PrimeNumberModel() {}

    public PrimeNumberModel(int primeNumber) {
        this.primeNumber = primeNumber;
    }

    public int getPrimeNumbersId() {
        return primeNumbersId;
    }

    public void setPrimeNumbersId(int primeNumbersId) {
        this.primeNumbersId = primeNumbersId;
    }

    public int getPrimeNumber() {
        return primeNumber;
    }

    public void setPrimeNumber(int primeNumber) {
        this.primeNumber = primeNumber;
    }
}
