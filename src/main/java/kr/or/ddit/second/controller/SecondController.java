package kr.or.ddit.second.controller;

import kr.or.ddit.vo.MemberVO;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecondController implements ApplicationContextAware{
     //http://localhost/SpringToddler/second/hello.second
	  @RequestMapping("/second/hello.second")
	  public String secondMethod(){
		  //InternalResourceViewResolver
		  //   //WEB-INF/views//second/hello.jsp.로 포워딩 처리 
		  return "second/hello";
	  }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
/*		MemberVO memberInfo1 = (MemberVO)applicationContext.getBean("memberVO");
		System.out.println("memberInfo1 : " +memberInfo1);*/
	}
}
