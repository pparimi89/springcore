package com.sample.springcore.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AspectConfiguration.class);
        context.refresh();
        EmployeeService employeeService = context.getBean(EmployeeService.class);
/*
        employeeService.getEmployeeName();
        employeeService.getEmployeeNumber();
*/
/*        employeeService.getAfterEmployeeName();*/
        employeeService.getPassedNameAndNumber("test", 1235);
        //System.out.println(":::::::::Seperator:::::::::");
        //employeeService.getPassedNameAndNumber("test", 123);
        context.close();
    }

}
