package com.munvegi.springmvc.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CentralMonitoringHandler {
    //private static Logger monitorLogger = LoggerFactory.getLogger("monitoring");

    //@Around("execution(* com.munvegi.springmvc.service.UserService.*(..)) && target(service)")
//    @Around("execution(* com.munvegi.springmvc.service..*(..)) && target(service)")
    @Around("execution(* com.munvegi.springmvc.service..*.*(..)) && target(service)") // -> Pointcut
    public Object logServiceAccess(ProceedingJoinPoint jp, Object service) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = jp.proceed();
        long totalTime = System.currentTimeMillis() - startTime;
        //monitorLogger.info("{}|Invocation time {}ms ", service.getClass().getSimpleName(), totalTime);
        System.out.println("************************ Service **********************");
        System.out.println("{}|Invocation time {}ms " + jp.getTarget().getClass().getSimpleName() +
                "." + ((MethodSignature) jp.getSignature()).getMethod().getName() + " " + totalTime);

        return result;
    }

    //@Around("within(@org.springframework.stereotype.Repository *) && execution(public * *(..)) && target(dao)")
    @Around("within(com.munvegi.springmvc.dao..*) && execution(public * *(..)) && target(dao)")
    public Object logDAOs(ProceedingJoinPoint jp, Object dao) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = jp.proceed();
        long totalTime = System.currentTimeMillis() - startTime;
        //monitorLogger.info("{}|Invocation time {}ms ", service.getClass().getSimpleName(), totalTime);
        System.out.println("*********************** DAO ***************************");
        System.out.println("{}|Invocation time {}ms " + dao.getClass().getSimpleName() +
                "." + ((MethodSignature) jp.getSignature()).getMethod().getName() + " " + totalTime);
        return result;
    }
}
