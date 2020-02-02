package com.sample.springcore.injectiontypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    Student student;
    WorkLocation workLocation;


    Employee(final WorkLocation workLocation){
        this.workLocation = workLocation;
    }

    @Autowired(required = false)
    public void setStudent(final Student student){
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
}
