package kr.or.ddit.freeboard.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import kr.or.ddit.FileItem.service.IFileItemService;
import kr.or.ddit.aop.Loggable;
import kr.or.ddit.freeboard.service.IFreeboardService;
import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.FreeboardVO;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user/freeboard/")
public class FreeboardController {
	 
	
	  @Autowired
	  private IFreeboardService freeboardService;
	  @Autowired
	  private IFileItemService fileItemService;
	  
      @Loggable
	  private Logger logger;
	   
	  
	  @Value("#{connectionInfo['driver']}")
	  private String driver;
	  @Value("#{connectionInfo['url']}")
	  private String url;
	  @Value("#{connectionInfo['username']}")
	  private String username;
	  @Value("#{connectionInfo['password']}")
	  private String password;

	  // /user/freeboard/freeboardList.do
	  // void, Model, ModelMap: user/freeboard/freeboardList 추출
	  // order=1: tilesViewResolver 전달 
	  // tilesViewResolver: definition name과 맵핑  user/*/*
	  @RequestMapping("freeboardList")
	  public ModelAndView freeboardList(Map<String, String> params,
			  							ModelAndView andView){
		  
		  params.put("startCount", "10");
		  params.put("endCount", "1");
		  
		  List<FreeboardVO> freeboardList = this.freeboardService.freeboardList(params);
		  
		  andView.addObject("freeboardList", freeboardList);
		  //tiles 설정파일 내 definition의 name속성값 맵핑
		  andView.setViewName("user/freeboard/freeboardList");
		  
		  return andView;
		  
	  }
	  
	  
	  @RequestMapping(value="freeboardView")
	  @ModelAttribute(value="freeboardInfo")
	  private FreeboardVO freeboardView(String bo_no,
			                            Map<String, String> params,
			                            FreeboardVO freeboardInfo){
		  params.put("bo_no", bo_no);
		  
		  freeboardInfo = this.freeboardService.freeboardInfo(params);
		  
		  return freeboardInfo;
	  }
	  
	  
	  
	  // /user/freeboard/freeboardForm.do
	  @RequestMapping("freeboardForm")
	  public void freeboardForm(){
		  
	  }
	  
	  
	  
	  @RequestMapping("fileDownload")
	  public ModelAndView fileDownload(@RequestParam String fileSEQ,
			  								  Map<String, String> params,
			  								  ModelAndView andView){
		  params.put("file_seq", fileSEQ);
		  
		 FileItemVO fileItemInfo = this.fileItemService.fileItemInfo(params);
		 
		 //빈등록
		 //@Component("fileDownloadView")
		 //class파일 다운로드 전용 뷰클래스 extends Abstractive
		 andView.addObject("fileItemInfo", fileItemInfo);
		 andView.setViewName("fileDownloadView");
		 
		 return andView;
		  
	  }
	  
	  
	  //멀티파트 요청
	  //폼필드: bo_title, bo_nickname, bo_pwd, bo_content, bo_mail
	  //파일: files*2
	  //     1. MVCPatternModel2 업로드 파일 FileItem 타입
	  //     2. Struts2 업로드 파일 File타입
	  //     3. Spring Framework 업로드 파일 MultipartFile 타입
	  
	  // 클라이언트로부터 전송된 쿼리 스트링을 커맨드 오브젝트(VO)와 맵핑처리 
	  @RequestMapping("insertFreeboard")
	  public String insertFreeboard(FreeboardVO freeboardInfo,
			                        @RequestParam("files") MultipartFile[] files){
		  this.freeboardService.insertFreeboardInfo(freeboardInfo, files);
		  
		  return "forward:/user/freeboard/freeboardList.do";
		  
		  
	  }
	  
	  @RequestMapping("updatefreeboard")
	  public String updateFreeboard(FreeboardVO freeboardInfo,
			  						@RequestBody String queryString){
	  
	   this.freeboardService.updateFreeboardInfo(freeboardInfo);
	   
	   return "redirect:/user/freeboard/freeboardList.do";
	  }
	 
	  
	  @RequestMapping("deletefreeboard")
	  public ModelAndView deleteFreeboard(String bo_no,
			      						  Map<String, String> params,
			      						  ModelAndView andView){
		  
		  params.put("bo_no", bo_no);
		  this.freeboardService.deleteFreeboardInfo(params);
		  
		  andView.setViewName("redirect:/user/freeboard/freeboardList.do");
		  
		  return andView;
	  }
	  
	  
	 @PostConstruct
	 public void init(){
		 this.logger.debug("빈클래스 최초 인스턴스화 직후 콜백 메서드");
	 }
	 
	 @PreDestroy
	 public void destroy(){
		 this.logger.debug("빈클래스가 GC직전에 콜백되는 메서드");
	 }
	 
	  
	  
}
