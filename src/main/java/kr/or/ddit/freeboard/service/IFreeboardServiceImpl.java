package kr.or.ddit.freeboard.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.FileItem.dao.IFileItemDao;
import kr.or.ddit.FileItem.dao.IFileItemDaoImpl;
import kr.or.ddit.freeboard.dao.IFreeboardDao;
import kr.or.ddit.freeboard.dao.IFreeboardDaoImpl;
import kr.or.ddit.utiles.AttachFileMapper;
import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.FreeboardVO;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang.exception.NestableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;



//<bean id="iFreeboardServiceImpl"..>
@Service
public class IFreeboardServiceImpl implements IFreeboardService {
   
	
	@Autowired
	private IFreeboardDao freeboardDao;
	@Autowired
	private IFileItemDao fileitemDao;
	@Autowired
    private AttachFileMapper fileMapper;
	   
	

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	@Override
	public List<FreeboardVO> freeboardList(Map<String, String> params) {
		List<FreeboardVO> freeboardList = null;
		try {
			freeboardList = freeboardDao.freeboardList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeboardList;
	}
																//모든 exception처리
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public void insertFreeboardInfo(FreeboardVO freeboardInfo, 
									MultipartFile[] files) {
		try {
			// freeboard table 대상의 게시글 insert
			//    file_bo_no = freeboard table 대상 bo_no(시퀀스)가 할당
			// fileitem table 대상의 첨부파일 정보 insert * 2
			//    특정 게시글의 첨부파일인것을 설정 : fileitem table 내 file_bo_no
			String bo_no = this.freeboardDao.insertFreeboardInfo(freeboardInfo);
			// 첨부파일 인서트할때 bo_no => file_bo_no로 활용
			List<FileItemVO> fileItemList = this.fileMapper.mapping(files, bo_no);
			fileitemDao.insertFileItemInfo(fileItemList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public void updateFreeboardInfo(FreeboardVO freeboardInfo) {
		try {
			freeboardDao.updateFreeboardInfo(freeboardInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	@Override
	public FreeboardVO freeboardInfo(Map<String, String> params) {
		FreeboardVO freeboardInfo = null;
		try {
			freeboardInfo = freeboardDao.freeboardInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeboardInfo;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public void deleteFreeboardInfo(Map<String, String> params) {
		try {
			freeboardDao.deleteFreeboardInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	@Override
	   public String totalCount(Map<String, String> params) {
	      String totalCount = "0";
	      try{
	         totalCount = freeboardDao.totalCount(params);
	      }catch(SQLException e){
	         e.printStackTrace();
	      }
	      return totalCount;
	   }
	
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public void insertFreeboardReplyInfo(FreeboardVO freeboardInfo) {
		
		try {
			freeboardDao.insertFreeboardReplyInfo(freeboardInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}








