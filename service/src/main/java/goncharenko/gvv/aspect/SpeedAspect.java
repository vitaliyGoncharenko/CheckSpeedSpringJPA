package goncharenko.gvv.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Vitaliy on 27.11.2016.
 */
@Component
@Aspect
public class SpeedAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpeedAspect.class);

    @Around("execution(* goncharenko.gvv.service.ModelRepositoryServiceImpl.* (..))")
    public void aroundRepositoryMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long timeBefore = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long timeAfter = System.currentTimeMillis();
        int difference = (int) (timeAfter - timeBefore);
        LOGGER.info("***********************************************************************************************************");
        LOGGER.info("Process " + proceedingJoinPoint.getSignature().toShortString() + ", is executed " + difference + " millisecond");
        LOGGER.info("***********************************************************************************************************");
    }

}
