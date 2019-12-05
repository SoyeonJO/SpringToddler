package kr.or.ddit.user.member.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.vo.MemberVO;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/user/member/")
//public class MemberController implements ApplicationContextAware {
public class MemberController {
    @Autowired
	private IMemberService service;
	
	// http://localhost/SpringToddler/user/member/memberList.do
	//1. 회원정보 테이블에서 전체 회원정보를 취득 
	//    List<MemberVO> memberList = service....
	//2. memberList.jsp에 , memberList(컬렉션)이 전달
	//    /WEB-INF/views/user/member/memberList.jsp 포워딩
	@RequestMapping("memberList")
	//public Model memberList(Model model){
	  public ModelMap memberList(ModelMap model){
		//ModelMap model = new ModelMap(); (인스턴스화 시켜주기때문에  new할필요없음)
		
		List<MemberVO> memberList = this.service.memberList();
		model.addAttribute("memberList", memberList);
		  return model;
	}
	 //              |Controller |
	// /SpringToddler/user/member/memberView.do?mem_id=c001
	// /WEB-INF/views/user/member/memberView.jsp
	
	//@RequestMapping(value="memberView", params={"mem_id=c001"})
	//@RequestMapping(value="memberView", method=RequestMethod.POST)
	
	@RequestMapping(value="memberView")
	@ModelAttribute(value="memberInfo")
	private MemberVO memberView(String mem_id, 
								Map<String, String>params,
							    MemberVO memberInfo){
		params.put("mem_id", mem_id);
		
	   memberInfo = this.service.memberInfo(params);
	  
		
		return memberInfo;
	
	}
	
	@RequestMapping("updateMemberInfo")
	public String updateMember(MemberVO memberInfo,
							   @RequestBody String queryString){
		this.service.updateMemberInfo(memberInfo);
	
		//redirect: do확장자로 리다이렉트 처리(컨텍스트 루트 생략)
		//forward: view(jsp, tiles, do) 포워딩 처리 (컨텍스트 루트 생략)
		
		return "redirect:/user/member/memberList.do";
	}
	
	
	// /user/member/deleteMemberInfo/a001.do
	@RequestMapping("deleteMemberInfo/{user_id}")
	public ModelAndView deleteMember(@PathVariable ("user_id") String mem_id,
			 					     Map<String, String> params,
			 					     ModelAndView andView){
		
		params.put("mem_id", mem_id);
		
		this.service.deleteMemberInfo(params);
		
    //ModelAndView andView = new ModelAndView();
    //andView.addObject("키", 값);
	 // redirect: or farward: prefix  활용 가능
		andView.setViewName("redirect:/user/join/loginForm.do");
		
		return andView;
		
	}
	
	
	  @RequestMapping("memberForm")
	  public void memberForm(){ 
		  
	  }
	  
	  @RequestMapping("insertMemberInfo")
	  public String insertMember(MemberVO memberInfo,
			                     RedirectAttributes redirectAttributes) throws UnsupportedEncodingException{
		  this.service.insertMemberInfo(memberInfo);
		  
		  String message = URLEncoder.encode("회원가입이 완료되었습니다.", "UTF-8");
		  
		  
		  //RedirectAttribute 활용
		  redirectAttributes.addFlashAttribute("message","회원가입이 완료되었습니다.");
		  
		  
//		return "redirect:/user/join/loginForm.do?message="+message;
		return "redirect:/user/join/loginForm.do";
	  }
		 
	/*  // /user/idCheck.do?mem_id=입력값
	  @RequestMapping("idCheck")
	  @ResponseBody
	  public String idCheck(@RequestParam String mem_id,
			                Map<String, String> params,
			                Map<String, String> jsonMap) throws JsonGenerationException, JsonMappingException, IOException{ 
		  params.put("mem_id", mem_id);
		  
		  MemberVO memberInfo = this.service.memberInfo(params);
		     
		    
		  if(memberInfo == null){
			  jsonMap.put("flag","true");
		  }else{
			  jsonMap.put("flag","false");
		  }
			  
		  ObjectMapper mapper = new ObjectMapper();
		  
		  String jsonData = mapper.writeValueAsString(jsonMap);
		     return jsonData;
		  }
	  
	  */
	
	  
	  @RequestMapping("idCheck")
	  public ModelAndView idCheck(String mem_id,
			  					  Map<String, String> params,
			  					  ModelAndView andView){
		  
		  params.put("mem_id", mem_id);
		  
		  MemberVO memberInfo= this.service.memberInfo(params);
		  
		  andView.addObject("memberInfo", memberInfo);
		  andView.setViewName("jsonConvertView");
		  
		  return andView;
	  }
	  
	  
	  
/*	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.service = applicationContext.getBean("memberService", IMemberService.class);
	}*/

	  
	  //<bean id=memberController class = ...MemberController
	   //          autowird=byName/>
	   //<bean id=memberService class = ...IMemberServiceImpl/>
  /*    public void setMemberService(IMemberService service){
    	  this.service=service;
      }*/
      //<bean id=memberController class = ...MemberController
      //          autowird=byName/>
      //<bean id=memberService class = ...IMemberServiceImpl/>
  /*    public void setAmugerna(IMemberService service){
    	  this.service = service;
      }*/
}
