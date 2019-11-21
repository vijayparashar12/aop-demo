package com.vp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeCalculationAspect {
    private static Logger LOG = LoggerFactory.getLogger(Application.class);

    @Pointcut("@annotation(com.vp.LogExecutionTime)")
    private void logExecutionTime() {
    }

    @Around("logExecutionTime()")
    public Object calculateExecutionTime(final ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = pjp.proceed();

        long executionTime = System.currentTimeMillis() - start;

        LOG.info(pjp.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }
}
