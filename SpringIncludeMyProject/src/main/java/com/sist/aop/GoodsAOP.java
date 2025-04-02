package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class GoodsAOP {
	@Around("execution(* com.sist.web.*Controller.*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
		Object obj=null;
		System.out.println("사용자 요청:"+jp.getSignature().getName());
		obj=jp.proceed();
		System.out.println("요청 처리 완료:"+jp.getSignature().getName());
		return obj;
	}
}
