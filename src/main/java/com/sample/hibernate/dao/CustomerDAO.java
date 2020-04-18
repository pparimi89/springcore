package com.sample.hibernate.dao;

import com.sample.hibernate.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();

    void addCustomers(int id, String name, String city);

    void updateCustomer(int id, String name);

    void deleteCustomer(int id);

    void addEmployee(String ename, Integer esal, String city, String state);

    void addCust(String name, String sal, String aName, String bank, String aName2, String bank2);
}
