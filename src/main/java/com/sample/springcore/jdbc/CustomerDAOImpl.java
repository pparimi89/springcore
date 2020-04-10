package com.sample.springcore.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

// Jdbc Template CRUD operations//
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

    //delete from customer where id=1

    @Override
    public void deleteCustomers(int id){
        String sql = "delete from customer where id= ?";
        jdbcTemplate.update(sql, new Object[]{id});
    }

    @Override
    public void updateCustomers(String name, int id){
        String sql = "update customer set name=? where id= ?";
        Object[] params = {name, id};
        jdbcTemplate.update(sql, params);
    }

    //End//

    //Named Parameter JDBC Template
    @Override
    public void addCustomerNPJT(Integer id, String name, String city){
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("city", city);
        params.put("id", id);
        String query = "insert into customer values(:id, :name, :city)";
        namedParameterJdbcTemplate.update(query, params);
    }

    @Override
    public List<Customer> getCustomersNPJT(){
        String sql = "select * from customer";
        RowMapper<Customer> mapper = BeanPropertyRowMapper.newInstance(Customer.class);
        return namedParameterJdbcTemplate.query(sql, mapper);
    }

    //delete from customer where id=1

    @Override
    public void deleteCustomersNPJT(int id){
        final String sql = "delete from customer where id= :id";
        final Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public void updateCustomersNPJT(String name, int id){
        String sql = "update customer set name=:name where id= :id";
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("id", id);
        namedParameterJdbcTemplate.update(sql, params);
    }
}
