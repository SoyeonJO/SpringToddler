package kr.or.ddit.global.exception;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.aop.Loggable;

import org.slf4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class CustomExceptionResolver extends SimpleMappingExceptionResolver {

	@Loggable
	private static Logger logger;
	
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		//클라이언트 요청시 해당 요청에 따른 응답을 처리 완료까지 경량화된 쓰레드가 할당
		String currentThread = Thread.currentThread().getName();
		
		//익셉션 발생된 메서드명, 해당 메서드를 포함되는 빈 클래스명 
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		String exceptionOccureClazz= handlerMethod.getBean().getClass().getName();
		String exceptionOccureMethod= handlerMethod.getMethod().getName();
		int lineNum = ex.getStackTrace()[0].getLineNumber();
		String exceptionClazz = ex.getClass().getName();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh24:mm:ss");
		
		logger.error("에러발생: {} | 클래스-{} | 메서드-{} | 라인번호-{} | 익셉션-{} | 발생시간-{}",
				     currentThread,
				     exceptionOccureClazz,
				     exceptionOccureMethod,
				     lineNum,
				     exceptionClazz,
				     dateFormat.format(new Date()));
		
		
		
		return super.resolveException(request, response, handler, ex);
	}
	

}
