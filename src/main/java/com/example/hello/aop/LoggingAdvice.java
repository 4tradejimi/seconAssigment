//package com.example.hello.aop;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class LoggingAdvice {
//
//    Logger log = LoggerFactory.getLogger(LoggingAdvice.class);
//
//    @Pointcut("within(com.example.hello.controllers..*)")
//    public void myPointcut(){
//    }
//
//    @Around("myPointcut()")
//    public void appLogger(JoinPoint joinPoint) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        String functionName =joinPoint.getSignature().getName();
//        String className=joinPoint.getTarget().getClass().toString();
//        Object[] array = joinPoint.getArgs();
//        log.info("funciton name: " + className+" : " + functionName + " arguments : " +  mapper.writeValueAsString(array));
//    }
//}
