package com.sample.hibernate.dao;

import com.sample.hibernate.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();

    void addCustomers(int id, String name, String city);
}
