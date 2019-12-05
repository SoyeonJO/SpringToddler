<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="mgr.loginForm.title"/></title>
<script type="text/javascript">
if(eval('${!empty param.message}')){
      alert('${param.message}');
   }
</script>
</head>	
<body>
   <form action="${pageContext.request.contextPath}/user/join/loginCheck.do" method="POST" >
      <table>
      
         <tr>
            <td><spring:message code="mgr.id.lable"></spring:message></td>
            <td><input  name='mem_id' type="text"/></td>
         </tr>
         <tr>
            <td><spring:message code="mgr.pwd.lable"></spring:message></td>
            <td><input name='mem_pass' type="text"/></td>
         </tr>
         <tr>
            <td colspan="2">
            <input type="submit" value='<spring:message code="mgr.loginForm.title"></spring:message>'/>
            <a href='${pageContext.request.contextPath}/user/member/memberForm.do'><spring:message code="mgr.registMember.text"></spring:message></a>
            </td>
           </tr>
      </table>
   </form>
</body>
</html>