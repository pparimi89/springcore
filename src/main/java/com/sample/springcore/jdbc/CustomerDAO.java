package com.sample.springcore.jdbc;

import java.util.List;

public interface CustomerDAO {

    void addCustomer(Integer id, String name, String city);
    List<Customer> getCustomers();

}
