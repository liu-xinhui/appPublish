package com.step.ap.config;

import com.step.ap.exception.UnauthorizedException;
import com.step.ap.util.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;

import static com.step.ap.util.Constant.AUTHORIZATION;

@Slf4j
@Aspect
@AllArgsConstructor
@Component
public class AuthAspect {

    @Before("execution(* com.step.ap.controller..*.*(..))")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            String content = "收到请求 | URL:" + request.getRequestURL() +
                    " | HTTP_METHOD:" + request.getMethod() +
                    " | IP:" + request.getRemoteAddr() +
                    " | CLASS_METHOD:" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() +
                    " | ARGS:" + Arrays.toString(joinPoint.getArgs());
            log.info(content);
        }
    }

    @Around("execution(* com.step.ap.controller..*.*(..)) && !@annotation(com.step.ap.config.annotation.NoAuth)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        String token = request.getHeader(AUTHORIZATION);
        if (StringUtils.isEmpty(token)) {
            throw new UnauthorizedException();
        }
        try {
            JwtUtil.checkToken(token);
        } catch (Exception e) {
            throw new UnauthorizedException();
        }
        return joinPoint.proceed();
    }
}
