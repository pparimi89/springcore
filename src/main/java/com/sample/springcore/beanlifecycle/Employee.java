package com.sample.springcore.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Employee implements BeanPostProcessor, InitializingBean, DisposableBean {

    private int empid;
    private String empname;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("inside postProcessBeforeInitialization.....");
        System.out.println(beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization.....");
        return bean;
    }

    @PostConstruct
    public void init(){
        System.out.println("inside post construct annotation");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Inside annotation destroy method");
    }

    @Override
    public void destroy(){
        System.out.println("Inside disposable bean destroy method");
    }

    @Override
    public void afterPropertiesSet(){
        System.out.println(" After properties set......");
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public void testTheBeanCreation(){
        System.out.println("Testing");
    }

}
