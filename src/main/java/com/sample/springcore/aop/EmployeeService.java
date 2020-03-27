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


    @LogExecutionTime
    public String getPassedNameAndNumber(String name, Integer number){
        if(number == 123){
            throw new IllegalArgumentException("number cannot be"+number);
        }
        return name+number;
    }

    @LogExecutionTime
    public String getAfterEmployeeName(){
        System.out.println("inside the method after.....");
        return "After Rakesh";
    }
}
