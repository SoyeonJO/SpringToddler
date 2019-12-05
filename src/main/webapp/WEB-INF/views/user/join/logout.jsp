<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
if(eval('${!empty param.message}')){
      alert('${param.message}');
   }
$('input[value=회원가입을 해주세여]').click(function(){
	$(location).attr('href','${pageContext.request.contextPath}/member/memberForm.do');
});
   
   
</script>
</head>
<body>
   <form action="${pageContext.request.contextPath}/join/loginCheck.do" >
      <table>
      
         <tr>
            <td>아이디</td>
            <td><input  name='mem_id' type="text" /></td>
         </tr>
         <tr>
            <td>비밀번호</td>
            <td><input name='mem_pass' type="text" /></td>
         </tr>
         <tr>
            <td colspan="2"><input type="submit" value='로그인'/>
            <input type="button" value='회원가입을 해주세여'/></td>
         </tr>
      </table>
   </form>
</body>
</html>