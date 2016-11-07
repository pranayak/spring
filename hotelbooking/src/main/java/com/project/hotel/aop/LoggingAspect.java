/**
 * 
 */
package com.project.hotel.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author prakashnayak
 * 
 */
//@Aspect
public class LoggingAspect {
	
	/*final static Logger logger = Logger.getLogger(LoggingAspect.class);

	@Around("execution(* com.mkyong.customer.bo.CustomerBo.addCustomerAround(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

	}

	@AfterThrowing(pointcut = "execution(* com.mkyong.customer.bo.CustomerBo.addCustomerThrowException(..))", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

	}*/

}
