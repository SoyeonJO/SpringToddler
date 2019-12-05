package kr.or.ddit.utiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.FileItemVO;

@Component
public class AttachFileMapper {
   public List<FileItemVO> mapping(MultipartFile[] items, String bo_no){
      List<FileItemVO> fileItemList = new ArrayList<FileItemVO>();
      if(items != null){
         FileItemVO fileItemInfo = null;
         for(MultipartFile item : items){
            if(item.getSize() > 0){
            //size 0 짜리는 FileItemWrapper가 걸러주므로, 굳이 여기서 또 걸러줄 필요는 없다.
            fileItemInfo = new FileItemVO();
            
            fileItemInfo.setFile_bo_no(bo_no);
            
            // 브라우저 별 파일 명 전송 방식이 다를 수 있음(d:\temp\a.png or a.png)
            String fileName = FilenameUtils.getName(item.getOriginalFilename());//어떻게 줘도 a.png를 return해줌.
            fileItemInfo.setFile_name(fileName);
            fileItemInfo.setFile_content_type(item.getContentType());
            fileItemInfo.setFile_size(String.valueOf(item.getSize()));
            
            // a.png는 얻어냄.
            String baseName = FilenameUtils.getBaseName(fileName);// => a만 얻어내고 싶음.
            String extension = FilenameUtils.getExtension(fileName);// => .png만 얻어내고 싶음.
            // 파일명_랜덤값.확장자 => file_save_name으로 활용
            // 랜덤값 | UUID(Universally Unique IDentifier) : 128bit 랜덤 유일값 반환(-를 포함한다.)
            String genID = UUID.randomUUID().toString().replace("-", "");
            
            String fileSaveName = baseName + "_" + genID + "." + extension;
            
            fileItemInfo.setFile_save_name(fileSaveName);
            
            fileItemList.add(fileItemInfo);
            
            saveFile(fileSaveName, item);
            }
         }
      }
      return fileItemList;
   }

   private static void saveFile(String fileSaveName, MultipartFile item) {
      File saveFile = new File(GlobalConstant.FILE_PATH, fileSaveName);
      
      try {
         item.transferTo(saveFile);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}