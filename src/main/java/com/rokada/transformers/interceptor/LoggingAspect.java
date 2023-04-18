package com.rokada.transformers.interceptor;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Logger for endpoint calls.
 */
@Slf4j
@Aspect
@Component
public class LoggingAspect {

  @Pointcut("within(com.rokada.transformers.controller..*)")
  public void controller() {
  }

  @Pointcut("execution(* *.*(..))")
  protected void allMethod() {
  }

  @Before("controller()")
  public void logBefore(JoinPoint joinPoint) {
    String args = fetchArgs(joinPoint);
    log.info("Started executing controller method: {}.{}() with method arguments: {}.",
        joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), args);
  }

  @After("controller()")
  public void logAfter(JoinPoint joinPoint) {
    log.info("Successfully executed controller method: {}.{}().",
        joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName());
  }

  private String fetchArgs(JoinPoint joinPoint) {
    try {
      Object[] args = joinPoint.getArgs();
      if (args != null) {
        return Arrays.toString(args);
      }
    } catch (Exception e) {
      log.error("Error while getting call arguments: ", e);
    }
    return "No args";
  }
}
