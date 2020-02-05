package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 *相同功能（记录日志）方法抽取出来形成一个切面
 */
@Aspect
public class LogAspect {
    /**
     * pointcut 定义拦截的方法
     * joinpoint(连接点) 被拦截的方法
     * advice 定义被拦截后要执行的方法
     */
    @Pointcut("execution(* com.aop.Calculate.*(..))")
    public void pointCut(){}

    /**
     * 定义advice
     * @param joinPoint
     * 解析为
     */
    @Before(value="pointCut()")
    public void methodBefore(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("execute before method:" + methodName);
    }

    /**
     * 容器初始化会转换成 AspectJAfterAdvice
     * @param joinPoint
     */
    @After(value="pointCut()")
    public void methodAfter(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("execute after method:" + methodName);
    }

    @AfterReturning(value="pointCut()", returning = "result")
    public void methodReturning(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("execute return method:" + methodName + " result:" + result);
    }
}
