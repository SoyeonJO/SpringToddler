package kr.or.ddit.utiles;

import java.text.SimpleDateFormat;
import java.util.Date;


// 함수태그 
// ex) ${fn:함수이름()}
// 사용자 정의한 함수 태그를 작성
//  1. 함수 태그화를 진행할 대상 메서드를 포함하는 클래스 요구됨
//  2. 메서드 작성규칙 준수
//     2.1 반드시 Static접근외 지정자 선언
//     2.2 반환타입과 파라메터 선언시 타입이 랩퍼클래스로 선언
//
public class CustomTagClazz {
	
	//${prefix 이름:plus(10,20)}
	public static Integer plus(Integer i , Integer j){
		return i + j;
		
	}
	//${prefix: 이름 : multiple("10",20)}
	public static Integer multiple(String value, Integer i){
		return Integer.parseInt(value) *i;
	}
	
    //${prefix이름 today()} => YYYY.MM.DD
	
	public static String today(){
		SimpleDateFormat dataFormat=  new SimpleDateFormat("yyyy/mm/dd");
		return dataFormat.format(new Date());
	}
	
	
	//${prefix 이름: charCount("12345678", "5")} => 2번 반복
    public static Integer charCount(String targetValue, String delim){
    	int idx = 0;
    	int cnt = 0;
    	
    	idx =  targetValue.indexOf(delim);
    	
    	for(; idx != -1; cnt++){
    		
    		targetValue = targetValue.substring(targetValue.indexOf(delim)+1, targetValue.length()  );
    		idx = targetValue.indexOf(delim);
    	}
    	return cnt;
    }
}
