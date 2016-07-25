package com.munvegi.springmvc.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CentralMonitoringHandler {
    //private static Logger monitorLogger = LoggerFactory.getLogger("monitoring");

    @Around("execution(* com.munvegi.springmvc.service.*..*Service+.*(..)) && target(service)")
    public Object logServiceAccess(ProceedingJoinPoint jp, Object service) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = jp.proceed();
        long totalTime = System.currentTimeMillis() - startTime;
        //monitorLogger.info("{}|Invocation time {}ms ", service.getClass().getSimpleName(), totalTime);
        System.out.println("{}|Invocation time {}ms " + service.getClass().getSimpleName() + " " + totalTime);

        return result;
    }
}
