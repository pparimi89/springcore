package com.sample.springcore.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void addCustomer(Integer id, String name, String city){
        String query = "insert into customer values(?, ?, ?)";
        jdbcTemplate.update(query, new Object[]{id, name, city});
    }

    @Override
    public List<Customer> getCustomers(){
        String sql = "select * from customer";
        RowMapper<Customer> mapper = BeanPropertyRowMapper.newInstance(Customer.class);
        return jdbcTemplate.query(sql, mapper);
    }

}
