package kr.or.ddit.aop;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

//PostProcessor: 스프링 프레임 웍 내 설정파일 또는 자동 빈등록을 위해 
//  				선언된 어노테이션 (@Controller, @Service, @Repository,
//  						     @Component)으로 빈등록시 DefaultBeanPostProcessor를 활용
//    class DefaultBeanPostProcessor implements BeanPostProcessor
//    LoggerInjector == DefaultBeanPostProcessor와 동일한 역할수행 

@Component
public class LoggerInjector implements BeanPostProcessor{

	
	@Override
	public Object postProcessBeforeInitialization(final Object currentRegistBean, String beanName)
			throws BeansException {
		// 등록되는 빈의 전역변수 중 @Loggable이 선언된 전역변수 존재 여부 체크 
		// 특정 전역변수 상단에 @Loggable이 존재하면 Logger자원을 해당 전역변수에 주입.

		//ReflectionUtils 빈으로 등록되는 해당 클래스 내 존재하는
		// 전체 전역변수에 순차적으로 접근시 FieldCallback.doWith() 반복 콜백
		ReflectionUtils.doWithFields(currentRegistBean.getClass(), new FieldCallback(){

			@Override
			public void doWith(Field field) throws IllegalArgumentException,
					IllegalAccessException {
				
				ReflectionUtils.makeAccessible(field);
				
				if(field.getAnnotation(Loggable.class) != null){
					//logback log 출력
					//class A{
					//  private final Logger logger = LoggerFactory.getLogger(A.class)
					//}
					// 
					// @Component
					//class B{
					//  @Loggable
					//  private Logger logger;
					//}
					
					Logger logger = LoggerFactory.getLogger(currentRegistBean.getClass());
					field.set(currentRegistBean, logger);
				}
			}
			
		});
		
		//bean 등록 수행시 마다 콜백(반복적으로 콜백)
		// return null; <= 빈 등록 제외.
		return currentRegistBean;
	}
	@Override
	public Object postProcessAfterInitialization(Object currentRegistedBean, String bean)
			throws BeansException {
		//beam 등록 완료시마다 콜백(반복적으로 콜백)
		// return null; <= 빈 등록 취소
		return currentRegistedBean;
	}

}
