package com.libraryaop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.libraryaop.service.BookService.*(..))")
    public void beforeAdvice() {
        System.out.println("LoggingAspect: Method execution is about to start...");
    }

    @After("execution(* com.libraryaop.service.BookService.*(..))")
    public void afterAdvice() {
        System.out.println("LoggingAspect: Method execution has completed.");
    }
}
