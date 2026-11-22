package tn.esprit.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before("execution(* tn.esprit.autoloc.services.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();

        log.info("Before - Méthode appelée : " + methodName);
    }

    @After("execution(* tn.esprit.autoloc.services.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();

        log.info("After - Méthode appelée : " + methodName);
    }
}
