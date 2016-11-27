package goncharenko.gvv.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by Vitaliy on 27.11.2016.
 */
@Component
@Aspect
public class SpeedAspect {


    @Around("execution(* goncharenko.gvv.service.ModelRepositoryServiceImpl.* (..))")
    public void aroundRepositoryMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long timeBefore = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long timeAfter = System.currentTimeMillis();
        int difference = (int) (timeAfter - timeBefore);
        System.out.println("Process " + proceedingJoinPoint.getSignature().toShortString() + ", is execute " + difference + " millisecond");
//        LOGGER.info("***********************************************************************************************************");
//        LOGGER.info("Process " + proceedingJoinPoint.getSignature().toShortString() + ", is execute " + difference + " millisecond");
//        LOGGER.info("***********************************************************************************************************");
    }

}
