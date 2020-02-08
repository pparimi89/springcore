package com.sample.springcore.beanlifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanLifeCycleTest {

    public static void main(String[] args){
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.sample.springcore.beanlifecycle");
        context.refresh();
        Employee employee = context.getBean(Employee.class);
        Employee employee2 = context.getBean(Employee.class);
        employee.testTheBeanCreation();
        System.out.println(employee.getEmpid());
        System.out.println(employee2.getEmpid());
        context.close();
    }
}
