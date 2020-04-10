package com.sample.springcore.jdbc;

import java.util.List;

public interface CustomerDAO {

    void addCustomer(Integer id, String name, String city);
    List<Customer> getCustomers();

    void deleteCustomers(int id);

    void updateCustomers(String name, int id);

    //Named Parameter JDBC Template
    void addCustomerNPJT(Integer id, String name, String city);

    List<Customer> getCustomersNPJT();

    void deleteCustomersNPJT(int id);

    void updateCustomersNPJT(String name, int id);
}
