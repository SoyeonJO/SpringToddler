package kr.or.ddit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component("logPrintAspect")
public class LogPrintAspectClazz {
	@Loggable
	private static Logger logger;
	
    public void joinpointCallBefore(JoinPoint joinpoint){
    	this.logger.debug("특정 joinpoint가 기타 코드로부터 호출 전 aop에 의해 출력되는 로그");
    	
    	//joinpoint(메서드)를 포함하는 빈 클래스 정보
    	String className = joinpoint.getTarget().getClass().getName();
    	String methodName = joinpoint.getSignature().getName();
    	
    	this.logger.debug("특정 joinpoint가 기타 코드로부터 호출 전 aop에 의해 출력되는 로그 {} - {}", className, methodName);
    }
    
    public void joinpointCallAfter(JoinPoint joinpoint){
    	this.logger.debug("특정 joinpoint가 기타 코드로부터 호출 전 aop에 의해 출력되는 로그");
    	
    	//joinpoint(메서드)를 포함하는 빈 클래스 정보
    	String className = joinpoint.getTarget().getClass().getName();
    	String methodName = joinpoint.getSignature().getName();
    	
    	this.logger.debug("특정 joinpoint가 기타 코드로부터 호출 및 종료 후 aop에의해 출력되는  {} - {}", className, methodName);
    }
    
    public void joinpointCallAfterThrowing(JoinPoint joinpoint, Exception ex){
    	this.logger.debug("특정 joinpoint가 기타 코드로부터 호출 전 aop에 의해 출력되는 로그");
    	
    	//joinpoint(메서드)를 포함하는 빈 클래스 정보
    	String className = joinpoint.getTarget().getClass().getName();
    	String methodName = joinpoint.getSignature().getName();
    	
    	this.logger.debug("특정 joinpoint가 기타 코드로부터 호출 및 종료 직후 aop에의해 출력되는  {} - {}", className, methodName, ex.getMessage());
    }
    
    
    public Object joinpointCallAround(ProceedingJoinPoint joinpoint) throws Throwable{

    	//joinpoint(메서드)를 포함하는 빈 클래스 정보
    	String className = joinpoint.getTarget().getClass().getName();
    	String methodName = joinpoint.getSignature().getName();
    	
    	this.logger.debug("메서드 호출 전에 실행되는 전처리 코드");
    	
    	Object rtnValue =joinpoint.proceed(); //해당 메서드 호출 및 반환값 취득 
    	
    	this.logger.debug("그리고, 메서드 종료후 실행 후처리 코드");
    	
    	return rtnValue;
    }
}
