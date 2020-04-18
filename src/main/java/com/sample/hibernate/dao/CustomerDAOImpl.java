package com.sample.hibernate.dao;

import com.sample.hibernate.entity.Customer;
import com.sample.hibernate.entity.onetomany.Account;
import com.sample.hibernate.entity.onetomany.Cust;
import com.sample.hibernate.entity.onetoone.Address;
import com.sample.hibernate.entity.onetoone.Employee;
import com.sample.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public List<Customer> getCustomers(){
        final Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Customer");
        return query.getResultList();
    }

    @Override
    public void addCustomers(int id, String name, String city){
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Customer customer = new Customer();
        customer.setCity(city);
        customer.setName(name);
        customer.setId(id);
        session.save(customer);
        session.getTransaction().commit();
    }

    @Override
    public void updateCustomer(int id, String name){
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        customer.setName(name);
        session.update(customer);
        session.getTransaction().commit();
    }

    @Override
    public void deleteCustomer(int id){
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
        session.getTransaction().commit();

    }

    @Override
    public void addEmployee(String ename, Integer esal, String city, String state){

        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        final Address address = new Address();
        address.setCity(city);
        address.setState(state);

        final Employee employee = new Employee();
        employee.setName(ename);
        employee.setSal(esal);
        employee.setAddress(address);

        session.save(employee);
        session.getTransaction().commit();

    }

    @Override
    public void addCust(String name, String sal, String aName, String bank, String aName2, String bank2){

        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();


        final Account account = new Account();
        account.setName(aName);
        account.setBank(bank);

        final Account account2 = new Account();
        account2.setName(aName2);
        account2.setBank(bank2);


        final Cust cust = new Cust();
        cust.setName(name);
        cust.setSal(sal);
        cust.setAccounts(Arrays.asList(account, account2));

        session.save(cust);
        session.getTransaction().commit();

    }


}
