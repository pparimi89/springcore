package com.sample.springcore.jdbc;

import com.sample.springcore.aop.AspectConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JDBCTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(JDBCConfiguration.class);
        context.refresh();
        CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
        //customerDAO.addCustomer(1, "Akhil", "Chennai");//Create
        //System.out.println(customerDAO.getCustomers());// Read
        //customerDAO.deleteCustomers(1);
        //customerDAO.updateCustomers("Akhil", 2);

        //customerDAO.addCustomerNPJT(1, "Akhil", "Chennai");//Create
        //System.out.println(customerDAO.getCustomersNPJT());// Read
        customerDAO.deleteCustomersNPJT(1);
        customerDAO.updateCustomersNPJT("Akhil NamedParamter", 2);

        context.close();
    }
}
