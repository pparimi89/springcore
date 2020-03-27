package com.sample.springcore.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.ref.PhantomReference;
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

    @Pointcut("execution(* EmployeeService.getPassedNameAndNumber(..))")
    public void employeeNamePointCut(){
    }

    @Around("execution(* EmployeeService.getAfterEmployeeName(..))")
    public void doAroundLogging(final ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(":::::::Around::::::::");
        System.out.println("After Method name:::"+joinPoint.getSignature().getName() );
        joinPoint.proceed();
        System.out.println("::::Around After running the method:::");
    }

    //The string that was present in the returning argument should match with method variable
    @AfterReturning(pointcut = "employeeNamePointCut()", returning = "result")
    public void doLogAfterReturning(final JoinPoint joinPoint, final Object result){
        System.out.println("doLogAfterReturning:::::"+result);
    }

    @AfterThrowing(pointcut = "employeeNamePointCut()", throwing = "error")
    public void doLogAfterThrowing(final JoinPoint joinPoint, final Exception error){
        System.out.println("doLogAfterThrowing:::::"+error.getMessage());
    }

    @Around("@annotation(LogExecutionTime)")
    public void logExecutionTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final long start = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        final long end = System.currentTimeMillis();
        System.out.println("Time of execction is :::::"+(end-start));
    }


}
