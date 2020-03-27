package com.sample.springcore.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogingAspect {

/*
    @Before("execution(* EmployeeService.getEmployeeName(..))")
    public void doBeforeLogging(final JoinPoint joinPoint){
        System.out.println("Method name:::"+joinPoint.getSignature().getName() );
    }
*/

/*    @Before("execution(* EmployeeService.*(..))")
    public void doBeforeLoggingAllMethods(final JoinPoint joinPoint){
        System.out.println("Method name:::"+joinPoint.getSignature().getName() );
        System.out.println("Method name:::"+ Arrays.asList(joinPoint.getArgs()) );
    }

    @After("execution(* EmployeeService.getAfterEmployeeName(..))")
    public void doAfterLoggingAllMethods(final JoinPoint joinPoint){
        System.out.println("After Method name:::"+joinPoint.getSignature().getName() );
    }*/

    @Around("execution(* EmployeeService.getAfterEmployeeName(..))")
    public void doAroundLogging(final ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(":::::::Around::::::::");
        System.out.println("After Method name:::"+joinPoint.getSignature().getName() );
        joinPoint.proceed();
        System.out.println("::::Around After running the method:::");
    }


}
