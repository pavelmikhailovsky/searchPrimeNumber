package com.search.just.number.searchjustnumber.dao;

import com.search.just.number.searchjustnumber.model.PrimeNumberModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NumberDaoImpl implements NumberDao {

    private final JdbcTemplate jdbcTemplate;

    public NumberDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getMaxPrimaryNumber() {
        return jdbcTemplate.query(
                "SELECT prime_number FROM prime_numbers ORDER BY prime_number DESC", new BeanPropertyRowMapper<>(PrimeNumberModel.class)
        ).stream().findFirst().get().getPrimeNumber();
    }

    @Override
    public int getPrimaryNumber(int number) {
        return jdbcTemplate.query(
            "SELECT prime_number FROM prime_numbers WHERE prime_number < ? ORDER BY prime_number DESC",
                new BeanPropertyRowMapper<>(PrimeNumberModel.class), number
        ).stream().findFirst().get().getPrimeNumber();
    }

    @Override
    public void addPrimaryNumber(int primaryNumber) {
        jdbcTemplate.update("" +
                "INSERT INTO prime_numbers(prime_number) VALUES (?)", primaryNumber
        );
    }
}
