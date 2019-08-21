package com.annotation.example.demo.annotate;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @version V1.0
 * @author: 杨玉冰
 * @Description:
 * @date:2019/8/21
 */
@Aspect
@Component
public class TestAspect {

    @Pointcut("@annotation(com.annotation.example.demo.annotate.TestAnnotation)")
    public void testPointCut() {
    }

    @Around("testPointCut()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        //方式1.通过MethodSignature获取注解类
        testMethodSignature(point);
        // 方式2.遍历类方法获取注解类
        test(point);
    }

    private void test(ProceedingJoinPoint point) {
        Method[] methods = point.getTarget().getClass().getMethods();
        for (Method method : methods) {
            TestAnnotation annotation = method.getAnnotation(TestAnnotation.class);
            if (annotation instanceof TestAnnotation) {
                System.out.println(annotation.value());
                break;
            }
        }
    }

    private void testMethodSignature(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        TestAnnotation testAnnotation = method.getAnnotation(TestAnnotation.class);
        System.err.println(testAnnotation.value());
    }
}
