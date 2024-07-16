package com.demo.capmgnmt.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LogsAspect {
    @Before("execution(* com.demo.*.controller..*(..))")
    public void logRequest(JoinPoint joinPoint) {
        log.info("start -> {} -> {}()",
                joinPoint.getSignature().getDeclaringType().getSimpleName(),
                joinPoint.getSignature().getName());
        log.debug("request -> {} with value::{}",
                Arrays.stream(((CodeSignature) joinPoint.getSignature()).getParameterNames()).toArray(),
                joinPoint.getArgs());
    }

    @After("execution(* com.demo.*.controller..*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("end -> {} -> {}()",
                joinPoint.getSignature().getDeclaringType().getSimpleName(),
                joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* com.demo.*.controller..*(..))", returning = "result")
    public void logResponse(Object result) {
        log.debug("response -> {}", result);
    }

    @AfterThrowing(value = "execution(* com.demo.*.controller..*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, Throwable exception) {
        log.error("error -> {} -> {}() threw exception::[{}] with message::[{}]",
                joinPoint.getSignature().getDeclaringType().getSimpleName(),
                joinPoint.getSignature().getName(),
                exception.getClass().getSimpleName(),
                exception.getMessage());
    }
}
