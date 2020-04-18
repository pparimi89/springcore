package com.sample.hibernate.test;

import com.sample.hibernate.dao.CustomerDAO;
import com.sample.hibernate.dao.CustomerDAOImpl;
import com.sample.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class HibernateTest {
    public static void main(final String[] args) {
        final CustomerDAO customerDAO = new CustomerDAOImpl();
        System.out.println(customerDAO.getCustomers());
        //customerDAO.addCustomers(10, "Jacker", "Tokyo");
        //customerDAO.updateCustomer(10, "Akhil");
        //customerDAO.deleteCustomer(10);

        //-------------Mappings Test----------------
        //customerDAO.addEmployee("Rakesh", 12000, "Chennai", "Tamil Nadu");
        customerDAO.addCust("Rakesh", "12000", "savings", "Andhra", "Current", "SBI");
    }
}
