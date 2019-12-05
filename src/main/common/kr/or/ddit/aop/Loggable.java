package kr.or.ddit.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//class A{
//     @Loggable{value="해당 전역변수는 1과 0값만 할당 받을 수 있어요."}
//     public String Value;
// }

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Loggable {
 //  public String value();
	
}
