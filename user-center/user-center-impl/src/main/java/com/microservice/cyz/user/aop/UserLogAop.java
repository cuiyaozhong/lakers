package com.microservice.cyz.user.aop;

import com.microservice.cyz.dto.DTO;
import com.microservice.cyz.util.RetCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author 崔耀中
 * @since 2021-01-09
 */
@Slf4j
@Aspect
@Component
public class UserLogAop {

    @Around("execution(public * com.microservice.cyz.user.service.impl.*.*(..))")
    public DTO printLog(ProceedingJoinPoint joinPoint) {
        String clazzName = joinPoint.getClass().getName();
        String functionName = joinPoint.getSignature().getName();
        log.info("------[{}]{}执行开始------", clazzName, functionName);

        DTO result = new DTO();
        try {
            result = (DTO) joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.error(throwable.getMessage(), throwable);
            throw new RuntimeException(throwable);
        } finally {
            if (Objects.equals(result.getRetCode(), RetCodeEnum.SUCCEED.getCode())) {
                log.info("------[{}]{}执行结束，执行结果：{}------",clazzName,functionName,result.getRetMsg());
            }else {
                log.warn("------[{}]{}执行结束，执行结果：{}------",clazzName,functionName,result.getRetMsg());
            }
        }
        return result;
    }

}
