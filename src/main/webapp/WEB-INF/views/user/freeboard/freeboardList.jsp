ll

<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 목록</title>
</head>
<script type="text/javascript">

$(function(){
	
$('#boardSelect tr').click(function(){ 
	 var bo_no = $(this).find('td:eq(0) input').val();
		var url = '${pageContext.request.contextPath}/user/freeboard/freeboardView.do';
		 $(location).attr('href', url + '?bo_no=' + bo_no ); 
	
})


$('#registBTN').click(function(){

		$(location).attr('href', '${pageContext.request.contextPath}/user/freeboard/freeboardForm.do');
	
});

		 
});

</script>
<body>
<div id="freeboardList_content">
	<div class="panel panel-blue">
    	<div class="panel-heading">게시판 목록</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
				     
					<th scope="col" width="5%">No</th>
					<th scope="col" width="65%">제목</th>
					<th scope="col" width="10%">작성자</th>
					<th scope="col" width="10%">작성일</th>
					<th scope="col" width="10%">조회수</th>
				</tr>
			</thead>
			<tbody id="boardSelect">
				<c:forEach items="${freeboardList}" var="freeboardInfo">
				<tr>
				   <td><input type="hidden" id="bo_no" value="${freeboardInfo.bo_no}"/>${freeboardInfo.rnum}</td>
					<td>${freeboardInfo.bo_title}</td>
					<td>${freeboardInfo.bo_nickname}</td>
					<td>${freeboardInfo.bo_reg_date}</td>
					<td>${freeboardInfo.bo_hit}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<div >
<form action="#" method="post" class="form-inline pull-right">
		<input id="search_keyword" type="text" placeholder="검색어 입력..." class="form-control" />
		<select class="form-control" name="search_keycode" >
			<option>검색조건</option>
			<option value="TOTAL">전체</option>
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
			<option value="WRITER">작성자</option>
		</select>
	    <button type="submit" class="btn btn-primary form-control">검색</button>
	    <button type="button" class="btn btn-info form-control" id="registBTN">게시글 등록</button>
</form>
</div>	
</body>
</html>