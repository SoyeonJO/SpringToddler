package kr.or.ddit.utiles;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.FileItemVO;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;


//<bean id ="FileDownLoadClazz"...
@Component("fileDownloadView")
public class FileDownlaodClazz extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
										    HttpServletRequest request, 
										   HttpServletResponse response)throws Exception {
      
		
		FileItemVO fileItemInfo = (FileItemVO) model.get("fileItemInfo");
		
		
		File downloadFile = new File(GlobalConstant.FILE_PATH, fileItemInfo.getFile_save_name());
		
		String fileName="";
		if(downloadFile.exists()){
			fileName = URLEncoder.encode(fileItemInfo.getFile_name(), "UTF-8");
			
			response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
			response.setContentType("application/octet-stream");
			response.setContentLength(Integer.parseInt(fileItemInfo.getFile_size()));
			
			
			// 다운로드 대상 파일의 컨텐츠를 읽고, 브라우저 대상 쓰기
			byte[] buffer = new byte[Integer.parseInt(fileItemInfo.getFile_size())];
			
			BufferedInputStream inputStream = new BufferedInputStream(
					                                 new FileInputStream(downloadFile));
			BufferedOutputStream outputStream = new BufferedOutputStream(
					                                 response.getOutputStream());
			
			int readCNT = 0;
			while((readCNT = inputStream.read(buffer)) != -1){
				outputStream.write(buffer, 0, readCNT);
			}
			
			inputStream.close();
			outputStream.close();
		}
	
	}

}
