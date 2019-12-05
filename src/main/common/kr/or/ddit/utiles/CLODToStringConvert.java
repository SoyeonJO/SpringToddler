package kr.or.ddit.utiles;

import java.io.BufferedReader;
import java.sql.Clob;

public class CLODToStringConvert {
    //CLOB타입의 객체를 convert 메서드의 아귀먼트로 전달
	//반환값: 문자열
	
	public static String convert(Object targetData) throws Exception{
		StringBuffer buffer = new StringBuffer();
		
		BufferedReader reader = 
				 new BufferedReader(((Clob)targetData).getCharacterStream());
		
		String dummy ="";
		while((dummy = reader.readLine()) != null){
			//CLOB타입 객체로부터 문자열 취득 후 저장 
			buffer.append(dummy);
			
		}
		reader.close();
		
		
		return buffer.toString();
		
	}
}
