package com.search.just.number.searchjustnumber.dao;

public interface NumberDao {

    int getMaxPrimaryNumber();

    int getPrimaryNumber(int number);

    void addPrimaryNumber(int primaryNumber);

}
