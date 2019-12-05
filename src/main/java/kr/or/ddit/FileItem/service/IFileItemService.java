package kr.or.ddit.FileItem.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FileItemVO;

public interface IFileItemService {
        
	public void insertFileItemInfo(List<FileItemVO> fileItemList);
	public FileItemVO fileItemInfo(Map<String, String> params);
	
	
}
