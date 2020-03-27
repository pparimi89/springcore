package com.sample.springcore.aop;

import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

    public String getEmployeeName(){
        return "Rakesh";
    }

    public Integer getEmployeeNumber(){
        return 1234;
    }

    public String getPassedNameAndNumber(String name, Integer number){
        return name+number;
    }

    public String getAfterEmployeeName(){
        System.out.println("inside the method after.....");
        return "After Rakesh";
    }
}
