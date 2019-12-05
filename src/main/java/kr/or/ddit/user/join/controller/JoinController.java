package kr.or.ddit.user.join.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.vo.MemberVO;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import com.sun.xml.internal.ws.client.RequestContext;

// context:component-scan base-package=kr.or.ddit
//   @Controller가 선언시 자동 빈등록 
//   <bean id ="joinController" class ...JoinController/>

@Controller
@RequestMapping("/user/join/") //공통서블릿 패스
//public class JoinController implements ApplicationContextAware{
public class JoinController{
	@Autowired
	private IMemberService service;
	//<bean id =joinController class= .. JoinCotroller
	//  autowire =constructor/>
	
	
	@Autowired
	private MessageSourceAccessor accessor;
	
/*	public JoinController(IMemberService service){
		this.service = service;
	}*/
	
	    // http://localhost/SpringToddler/user/join/loginForm.do
		// void : 컨트롤러 메서드의 반환값일때 요청시의 서블릿 패스 추출
		//        추출 문자열 - user/join/loginForm
		//        InternalResourceViewResolver에 추출문자열 전달.
	  @RequestMapping("loginForm")
	   public void loginForm(HttpServletRequest request){   /*String을 void로 변경해도 실행된다.*/
		   //InternalResourceViewResolver
		   // prefix: /WEB-INF/views/
		   // suffix: .jsp
		   // |---prefix----|-------반환값-------|-suffix-|
		   // /WEB-INF/views/user/join/loginForm.jsp
		   
		 /*  return "user/join/loginForm";*/
		  
		  
		  //MemberCotnroller내 insertMember()로부터
		  // RedirectAtrribute를 통해 전송되는 message= 회원가입이 완료되었습니다. 
		  // 취득
		  Map<String, ?> paramMap = RequestContextUtils.getInputFlashMap(request);
	      if(paramMap != null){
	    	 String value = (String)paramMap.get("message"); 
	    	 System.out.println("RedirectAttribute를 활용한 message:"+value);
	    	 
	      } 
	      
	      throw new NullPointerException();
	
	  }
	
	  
	  // /user/join/loginCheck.do
	  //  method=post mem_id =값&mem_pass=값
	  // 커맨드 오브젝트: 클라이언트로부터 전송되는 대량의 쿼리스트링의 
	  //             값들을 맵핑하기 위해 파라메터로 선언된 vo.
	  @RequestMapping("loginCheck")
	  public String loginCheck(String mem_id, 
			  				   String mem_pass, 
			  				   MemberVO commandOBJ,
			                   Map<String, String> params,
			                   HttpServletRequest request,
			                   HttpSession session,
			                   HttpServletResponse response,
			                   Model medel,
			                   ModelMap modelMap,
			                   ModelAndView modelAndView,
			                   @RequestHeader("Accept-Language")String al,
			                   @RequestHeader("User-Agent")String agent,
			                   @CookieValue("JSESSIONID")String sessionID,
			                   @CookieValue(value="mem_id", required=false, defaultValue="미전송시 대체값") String id)throws UnsupportedEncodingException{
		  System.out.println("Accept-Language:"+al);
		  System.out.println("User-Agent:"+agent);
		  System.out.println("JSESSIONID:"+sessionID);
		  System.out.println("mem_id:"+id);
		  
		  /* Map<String, String params = new HashMap<String, String>();*/   //이제 new hash안해도됨
		  params.put("mem_id", mem_id);
		  params.put("mem_pass", mem_pass);
		  
		  MemberVO memberInfo = this.service.memberInfo(params);
		  // 리다이렉트:
		  //    redirect:/user/member/memberList.do
		  // 포워딩:
		  //    forward:/user/member/memberList.do
		  if(memberInfo == null){
			  String message = this.accessor.getMessage("fail.common.join", Locale.KOREA);
					  message = URLEncoder.encode(message, "UTF-8");
			  
			  return "redirect:/user/join/loginForm.do?message="+message;
			  
		  }else{
			  session.setAttribute("LOGIN_MEMBERINFO", memberInfo);
			  return "redirect:/user/member/memberList.do";
			  
		  }
	  }
	  //       method = post mem_id = 값&mem_pass=값
	  
	  @RequestMapping("logout")
	  public String logout(HttpSession session){
		  
		  session.invalidate();
		  
		  String message="";
		try {
			message = URLEncoder.encode("로그아웃 되었습니다.", "UTF-8");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		  
		  return "redirect:/user/join/loginForm.do?message=" + message;
		  
	  }

	  
	
	  
/*	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {

		this.service = applicationContext.getBean("memberService", IMemberService.class);
	}
*/
}
