package com.sample.springcore.injectiontypes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InjectionTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.sample.springcore.injectiontypes");
        context.refresh();

        Employee employee = context.getBean(Employee.class);
        System.out.println(employee.getStudent());
        //employee.getStudent().test();
    }

}
