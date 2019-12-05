package kr.or.ddit.global;

public interface GlobalConstant {
    //상수로 선언 
	
	// D:\\temp\\images폴더에 저장된 파일은 
	// http:192.168.207.144/files/a.png 접근 가능
	//서버(웹서버, 웹 어플리케이션 서버)
	//  *http 프로토콜을 활용해 클라이언트의 접근 환경 구성 
	//  *구성(이클립스 내 Server view에서 설정)
	//        Document Folder:  D:\\temp\\images
	//        Content Root|Path: /files
	public String FILE_PATH ="D:\\temp\\images";   //이미지스 파일을 만든다,.
    
}
