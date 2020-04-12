package com.sample.hibernate.dao;

import com.sample.hibernate.entity.Customer;
import com.sample.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

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


}
