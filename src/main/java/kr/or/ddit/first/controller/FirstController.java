package kr.or.ddit.first.controller;


import kr.or.ddit.vo.MemberVO;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


// 커맨드 컨트롤러:클라잉너트의 요청 처리클래스
//	          1. 빈등록 
//	          2. @Controller선언
//          

	@Controller
	public class FirstController implements ApplicationContextAware{
	  //http://localhost/SpringToddler/first/hello.first
	
		
		   @RequestMapping("/first/hello.first")
		   public String firstMethod(){
			   //class MemberVO{
			   //  private String mem_id;
			   //  private String mem_pass;
			   //  ..
			   //  공통 setter/getter
		       //  }
			   //  property: 선언된 전역번수 의 setter를 활용해서 value속성값을 주 
		      /*<bean name ="jspViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			  		<property name="prefix" value="/WEB-INF/views/"></property>
			  		<property name="suffix" value=".jsp"></property>
		     </bean>
		     //반환값: ViewResolver빈에 전달
		      *      맵핑처리 - prefix + first/hello + suffix
		      *      ex)/WEB-INF/views/first/hello.jsp(포워딩처리)
		      * 
		     */
			   
			   return "first/hello";   
		   }

	@Override     //이 클래스에서는 setApplicationContext 메서드가 가장먼저 호출된다.
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
			//implement applicationContextAware: 빈클래스에서 설정파일 내 선언된 빈의 인스턴스를 취득
			//getBean("빈등록시의 id또는 name속성값")
		
		  /*MemberVO memberInfo1 = (MemberVO)applicationContext.getBean("memberVO");
			MemberVO memberInfo2 = (MemberVO)applicationContext.getBean("m1");
			MemberVO memberInfo3 = (MemberVO)applicationContext.getBean("m2");
			MemberVO memberInfo4 = (MemberVO)applicationContext.getBean("m3", MemberVO.class);
			
			System.out.println("memberInfo1 : " +memberInfo1);
			System.out.println("memberInfo2 : " +memberInfo2);
			System.out.println("memberInfo3 : " +memberInfo3);
			System.out.println("memberInfo4 : " +memberInfo4);*/
	}
	

	
}
