package com.microservice.cyz.user.aop;

import com.microservice.cyz.api.DataTransportObject;
import com.microservice.cyz.dto.DTO;
import com.microservice.cyz.user.po.WebLogPO;
import com.microservice.cyz.user.repository.WebLogMapper;
import com.microservice.cyz.util.RetCodeEnum;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.text.SimpleDateFormat;

/**
 * @author 崔耀中
 * @since 2021-01-09
 */
@Slf4j
@Aspect
@Component
public class UserLogAop {

    private ThreadLocal<Integer> serial = ThreadLocal.withInitial(() -> 0);

    @Value("${zj.log.method.ignore-get:false}")
    private boolean ignoreGetMethod;

    private final String USERNO = "userNo";
    private final String TID = "tid";
    private final String FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Resource
    private WebLogMapper webLogMapper;

    @Around("execution(public * com.microservice.cyz.user.web.*.*(..))")
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {
        serial.set(serial.get() + 1);
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        serial.set(serial.get() - 1);

        if (serial.get() == 0) {
            try {
                //获取当前请求对象
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                if (attributes == null) {
                    return result;
                }
                HttpServletRequest request = attributes.getRequest();

                String requestMethod = request.getMethod();

                //记录请求信息
                WebLogPO webLogPO = new WebLogPO();
                if (result instanceof DataTransportObject) {
                    webLogPO.setResult(((DataTransportObject) result).getRetCode());
                }

                Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
                ApiOperation apiOperation = AnnotatedElementUtils.findMergedAnnotation(method, ApiOperation.class);
                if (apiOperation != null) {
                    // serial.get().toString() + "/" + apiOperation.value()
                    webLogPO.setDescription(apiOperation.value());
                }

                webLogPO.setUrl(String.valueOf(request.getAttribute("permission_url")).split(",")[0]);
                webLogPO.setClientIp(getRealIp(request));
                webLogPO.setServerIp(InetAddress.getLocalHost().getHostAddress());
                webLogPO.setUsername(request.getHeader(USERNO));
                webLogPO.setTid(String.valueOf(request.getAttribute(TID)));
                webLogPO.setMethod(requestMethod);
                webLogPO.setCostTime((int) (endTime - startTime));
                webLogPO.setStartTime(new SimpleDateFormat(FORMAT).format(startTime));
                webLogPO.setRequest(request.getRequestURL().toString());
                log.info("{}", webLogPO);

                // 判断是否忽略Get请求
                if (ignoreGetMethod && HttpMethod.GET.toString().equalsIgnoreCase(requestMethod)) {
                    return result;
                }

                webLogMapper.insert(webLogPO);
            } catch (Exception e) {
                log.error("web log exception: ", e);
            }
        }


//        String clazzName = joinPoint.getClass().getName();
//        String functionName = joinPoint.getSignature().getName();
//        log.info("------[{}]{}执行开始------", clazzName, functionName);

//        DTO result = new DTO();
//        try {
//            result = (DTO) joinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            log.error(throwable.getMessage(), throwable);
//            throw new RuntimeException(throwable);
//        } finally {
//            if (Objects.equals(result.getRetCode(), RetCodeEnum.SUCCEED.getCode())) {
//                log.info("------[{}]{}执行结束，执行结果：{}------",clazzName,functionName,result.getRetMsg());
//            }else {
//                log.warn("------[{}]{}执行结束，执行结果：{}------",clazzName,functionName,result.getRetMsg());
//            }
//        }
        return result;
    }

    /**
     * 获取请求的真实IP
     */
    private String getRealIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

}
