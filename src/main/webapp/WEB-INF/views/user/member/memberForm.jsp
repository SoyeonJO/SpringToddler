<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
	$(function(){
		$('#form').submit(function(){//submit누른 시점에 검증을 하기 위한 식. submit은 form의 자식이다.
						//String.prototype.validationID↓
		if(!$('#targetID').val().validationID()){
			alert('아이디를 바르게 입력해주세요.');
			return false;};//아이디가 바르게 입력되지않아도 alert만 띄우고 submit은 진행될 수 있다. return false로 submit을 통한 서버로의 요청을 막는다

		if(!$('input[name=mem_pass]').val().validationPWD()){
			alert('비밀번호를 바르게 입력해주세요.');
			return false;};//아이디가 바르게 입력되지않아도 alert만 띄우고 submit은 진행될 수 있다. return false로 submit을 통한 서버로의 요청을 막는다

		if(!$('input[name=mem_name]').val().validationNM()){
			alert('성명을 바르게 입력해주세요.');
			return false;};//아이디가 바르게 입력되지않아도 alert만 띄우고 submit은 진행될 수 있다. return false로 submit을 통한 서버로의 요청을 막는다

		var regno = $('input[name=mem_regno1]').val() + '-' + $('input[name=mem_regno2]').val();//주민번호가 올바른지(주민번호가 맞는지)부터 확인하는 문장
		if(!regno.validationREGNO()){
			alert('주민번호를 바르게 입력해주세요.');
			return false;}//아이디가 바르게 입력되지않아도 alert만 띄우고 submit은 진행될 수 있다. return false로 submit을 통한 서버로의 요청을 막는다

		if(!$('input[name=mem_bir]').val().validationBIR()){
			alert('생년월일을 바르게 입력해주세요.');
			return false;}//아이디가 바르게 입력되지않아도 alert만 띄우고 submit은 진행될 수 있다. return false로 submit을 통한 서버로의 요청을 막는다

		if(!$('input[name=mem_hometel]').val().validationHOMETEL()){
			alert('집 전화번호를 바르게 입력해주세요.');
			return false;};//아이디가 바르게 입력되지않아도 alert만 띄우고 submit은 진행될 수 있다. return false로 submit을 통한 서버로의 요청을 막는다

		if(!$('input[name=mem_comtel]').val().validationCOMTEL()){
			alert('회사 전화번호를 바르게 입력해주세요.');
			return false;};//아이디가 바르게 입력되지않아도 alert만 띄우고 submit은 진행될 수 있다. return false로 submit을 통한 서버로의 요청을 막는다

		if(!$('input[name=mem_hp]').val().validationHP()){
			alert('휴대폰 번호를 바르게 입력해주세요.');
			return false;};//아이디가 바르게 입력되지않아도 alert만 띄우고 submit은 진행될 수 있다. return false로 submit을 통한 서버로의 요청을 막는다

		if(!$('input[name=mem_mail]').val().validationMAIL()){
			alert('메일을 바르게 입력해주세요.');
			return false;};//아이디가 바르게 입력되지않아도 alert만 띄우고 submit은 진행될 수 있다. return false로 submit을 통한 서버로의 요청을 막는다

		
	});
	
	
	
	$('input[value=아이디중복검사]').click(function(){
	 		if(!$('#targetID').val().validationID()){
			alert('아이디를 바르게 입력해주세요.');
			return false;
		} 
		
		$.ajax({
			
			  type: 'post'
			  ,url: '${pageContext.request.contextPath}/user/member/idCheck.do'
			  ,dataType :'json'
			  ,data: { mem_id: $('#targetID').val()}
			  ,error: function(result){
				      alert(result.status);
			  }
			  ,success:function(result){
				  	alert(result);
				     alert(result.memberInfo.mem_id);
			  }
			  
		});
		
	})
	
	
})

</script>
</head>
<body>
	<form id ="form" action="${pageContext.request.contextPath}/user/member/insertMemberInfo.do" method='POST'>
		<table>
			<tr>
				<td>아이디</td>
				<td><input name='mem_id' type="text" id="targetID"/>
					<input type ="button" value ="아이디중복검사" />
				</td>
				
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input name='mem_pass' type="text" /></td>
			</tr>
			<tr>
				<td>성명</td>
				<td><input name='mem_name' type="text" /></td>
			</tr>
			<tr>
				<td>주민등록번호</td>
				<td><input name='mem_regno1' type="text" /> -
				<input name='mem_regno2' type="text" /></td>
			</tr>
			<tr>
				<td>생일</td>
				<td><input name='mem_bir' type="text" /></td>
			</tr>
			<tr>
				<td>집전화번호</td>
				<td><input name='mem_hometel' type="text" /></td>
			</tr>
			<tr>
				<td>회사전화번호</td>
				<td><input name='mem_comtel' type="text" /></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input name='mem_hp' type="text" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input name='mem_mail' type="text" /></td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td><input name='mem_zip' type="text" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input name='mem_add1' type="text" />&nbsp;&nbsp;
				<input name='mem_add2' type="text" /></td>
			</tr>
			<tr>
				<td>직업</td>
				<td><input name='mem_job' type="text" /></td>
			</tr>
			<tr>
				<td>취미</td>
				<td><input name='mem_like' type="text" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value='회원가입'/></td>
			</tr>
		</table>
	</form>
</body>
</html>