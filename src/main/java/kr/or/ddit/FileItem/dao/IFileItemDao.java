package kr.or.ddit.FileItem.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FileItemVO;

public interface IFileItemDao {
	public void insertFileItemInfo(List<FileItemVO> fileItemList) throws SQLException;
	
	public FileItemVO fileItemInfo(Map<String, String> params) throws SQLException;
	
}
