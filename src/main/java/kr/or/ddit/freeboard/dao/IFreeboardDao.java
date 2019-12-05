package kr.or.ddit.freeboard.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FreeboardVO;

public interface IFreeboardDao {
	public List<FreeboardVO> freeboardList(Map<String, String> params) throws SQLException;
	public FreeboardVO freeboardInfo(Map<String, String> params) throws SQLException;
	public String insertFreeboardInfo(FreeboardVO freeboardInfo) throws SQLException;
	public void updateFreeboardInfo(FreeboardVO freeboardInfo) throws SQLException;
	public void deleteFreeboardInfo(Map<String, String> params) throws SQLException;
	//페이징
	public String totalCount (Map<String, String> params) throws SQLException;
	public void insertFreeboardReplyInfo(FreeboardVO freeboardInfo)throws SQLException;
}