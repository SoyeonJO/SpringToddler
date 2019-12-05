package kr.or.ddit.utiles;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import kr.or.ddit.global.GlobalConstant;

public class FileDownloadViewClazz {
	public void fileDownload(PageContext pageContext, 
			                 String fileName) throws IOException{

		HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
		JspWriter out = pageContext.getOut();
		
		File downloadFile = new File(GlobalConstant.FILE_PATH, fileName);
		
		if(downloadFile.exists()){
			fileName = URLEncoder.encode(fileName, "UTF-8");
			
			response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
			response.setContentType("application/octet-stream");
			response.setContentLength((int)downloadFile.length());
			
			out.clear();
			out = pageContext.pushBody();
			
			// 다운로드 대상 파일의 컨텐츠를 읽고, 브라우저 대상 쓰기
			byte[] buffer = new byte[(int)downloadFile.length()];
			
			BufferedInputStream inputStream = new BufferedInputStream(
					                                 new FileInputStream(downloadFile));
			BufferedOutputStream outputStream = new BufferedOutputStream(
					                                 response.getOutputStream());
			
			int readCNT = 0;
			while((readCNT = inputStream.read(buffer)) != -1){
				outputStream.write(buffer);
			}
			
			inputStream.close();
			outputStream.close();
		}
	}
}
