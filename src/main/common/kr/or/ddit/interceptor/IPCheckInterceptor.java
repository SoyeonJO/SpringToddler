package kr.or.ddit.interceptor;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class IPCheckInterceptor extends HandlerInterceptorAdapter {

	//클라이언트의 요청
	// 동기식: 1. IPCheckInterceptor.preHandle(){return true;} 콜백
	//       2. 컨트롤러 메서드 콜백
	//       3. IPCheckInterceptor.postHandle() 콜백
	//       4. IPCheckInterceptor.afterCompletion() 콜백
	// 비동기식:1. IPCheckInterceptor.preHandle() 콜백
	//       2. IPCheckInterceptor.afterConcurrentHandlingStarted() 콜백
	
	private static Map<String, String> ipMap;
	
	static{
		ipMap = new HashMap<String, String>();
		ipMap.put("127.0.0.1", "A");
		ipMap.put("0:0:0:0:0:0", "A");
		ipMap.put("192.168.207.145", "A");
		ipMap.put("192.168.207.146", "F");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		

	  //true: preHandle() 종료 후 컨트롤러 메서드 콜백 
	  //false: preHandle() 종료 후 컨트롤러 메서드 콜백하지 않음. 
	  
	  
	  String clientIP=  request.getRemoteAddr();
		
      boolean flag = true;
      //clientIP != null || clientIP != ""
	    if(!StringUtils.isNotEmpty(clientIP)&&
	    		   !ipMap.containsKey(clientIP)){
	        flag = false;
	    }
	    
	     if(flag){
	    	 return true;
	     }else{
	    		
	    		response.setCharacterEncoding("UTF-8");
	    		response.setContentType("text/html; charset=UTF-8");
	    		
	    		PrintWriter out = response.getWriter();
	    		out.println("<html>");
	    		out.println("<body>");
	    		out.println("<font color= 'red'> 접근이 금지된 아이피입니다. 관리자 문의!</font>");
	    		out.println("</body>");
	    		out.println("</html>");
	    		
	    		return false;
	     }
	}


	@Override 
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
	 
	}
	
	

}
