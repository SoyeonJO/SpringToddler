package kr.or.ddit.FileItem.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.FileItem.dao.IFileItemDao;
import kr.or.ddit.FileItem.dao.IFileItemDaoImpl;
import kr.or.ddit.vo.FileItemVO;

@Service
public class IFileItemServiceImpl implements IFileItemService {
      @Autowired
	  private IFileItemDao dao;

	  
	@Override
	public void insertFileItemInfo(List<FileItemVO> fileItemList) {
          //TODO  IFileItemServiceImpl에서  IFileItemDaoImpl의 해당 메서드 호출시 작성예약 	      

	}

	@Override
	public FileItemVO fileItemInfo(Map<String, String> params) {
         FileItemVO fileItemInfo = null;
         try {
			fileItemInfo = dao.fileItemInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fileItemInfo;
	}

}
