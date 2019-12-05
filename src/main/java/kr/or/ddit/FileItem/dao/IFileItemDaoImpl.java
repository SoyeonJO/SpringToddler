package kr.or.ddit.FileItem.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.FileItemVO;
@Repository
public class IFileItemDaoImpl implements IFileItemDao {
    @Autowired
	private SqlMapClient client;
	

	@Override
	public void insertFileItemInfo(List<FileItemVO> fileItemList)
				throws SQLException {
		
		try{
		   client.startTransaction();
		for(FileItemVO fileItemInfo : fileItemList){
			// 첨부파일 최대 2개 : insert 최대 2번
			//    1. insert 성공, 2. insert 성공  commit
			//    1. insert 성공, 2. insert 실패  rollback
			//    1. insert 실패
			//   Commit : startTransaction() -> commitTransaction()
			//            -> endTransaction() 
			//   Rollback : startTransaction() -> 에러발생 commitTransaction() 호출 X
			//            -> endTransaction() 
			
			client.insert("fileitem.insertFileItem", fileItemInfo);
		}
			client.commitTransaction();
		}finally{
			client.endTransaction();
		}
	}

	@Override
	public FileItemVO fileItemInfo(Map<String, String> params) throws SQLException {
		
		return (FileItemVO) client.queryForObject("fileitem.fileitemInfo", params);
	}

}







