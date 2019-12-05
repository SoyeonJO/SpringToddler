package kr.or.ddit.freeboard.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.vo.FreeboardVO;

public interface IFreeboardService {
	public List<FreeboardVO> freeboardList(Map<String, String> params);
	public FreeboardVO freeboardInfo(Map<String, String> params);
	public void insertFreeboardInfo(FreeboardVO freeboardInfo, MultipartFile[] files); 
	public void updateFreeboardInfo(FreeboardVO freeboardInfo);
	public void deleteFreeboardInfo(Map<String, String> params);
	//페이징
	public String totalCount (Map<String, String> params);
	public void insertFreeboardReplyInfo(FreeboardVO freeboardInfo); 
	
}
