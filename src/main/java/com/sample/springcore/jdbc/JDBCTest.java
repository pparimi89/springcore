package com.sample.springcore.jdbc;

import com.sample.springcore.aop.AspectConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JDBCTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(JDBCConfiguration.class);
        context.refresh();
        CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
        customerDAO.addCustomer(1, "Akhil", "Chennai");
        customerDAO.getCustomers();
        context.close();
    }
}
