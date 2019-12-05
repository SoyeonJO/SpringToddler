<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src ="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<div class="panel panel-green">
		<div class="panel-heading">자유 게시판</div>
		<div class="panel-body pan">

			<form action="${pageContext.request.contextPath}/user/freeboard/updatefreeboard.do" id="freeboardView" role="form" method="post">

				<div class="form-body pal">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">

								<input id="bo_no" type="hidden" name="bo_no" class="form-control" /> <input type="hidden" id="bo_group" name="bo_group" /> 
								<label for="inputName" class="control-label" for="bo_mem_id"> Name</label>
								<div class="input-icon right">
									<i class="fa fa-user"></i> <input id="bo_mem_id"
										name="bo_mem_id" type="text" class="form-control" />
								</div>

								<label for="inputName" class="control-label" for="bo_nickname">
									NickName</label>
								<div class="input-icon right">
									<i class="fa fa-user"></i> <input id="bo_nickname"
										name="bo_nickname" type="text" class="form-control" />
								</div>

								<label for="inputPassword" class="control-label" for="bo_pwd">
									Password</label>
								<div class="input-icon right">
									<i class="fa fa-lock"></i><input id="bo_pwd" type="password"
										name="bo_pwd" class="form-control" disabled />
								</div>
								<label for="inputEmail" class="control-label" for="bo_mail">
									E-mail</label>
								<div class="input-icon right">
									<i class="fa fa-envelope"></i> <input id="bo_mail"
										name="bo_mail" type="text" class="form-control" />
								</div>
							</div>
						</div>


						<div class="form-group">
							<label class="control-label " for="file01"></label>
							<div id="myCarousel" class="carousel slide" data-ride="carousel">

								<div class="col-sm-3">
									<!-- Indicators -->
									<ol class="carousel-indicators">
										<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
										<li data-target="#myCarousel" data-slide-to="1"></li>
									</ol>

									<!-- Wrapper for slides -->
									<div class="carousel-inner" role="listbox"
										style="width: 380px; height: 250px;">
										<c:forEach items="${freeboardInfo.items}" var="fileitem"
											varStatus="stat">
											<c:if test="${stat.first }">
												<div class="item active">
											</c:if>
											<c:if test="${stat.last}">
												<div class="item">
											</c:if>
											<img src="/files/${fileitem.file_save_name}" alt="pic1"
												style="width: 390px; height: 250px;"
												onclick="javascript:location.href='${pageContext.request.contextPath}/user/freeboard/fileDownload.do?fileSEQ=${fileitem.file_seq }';">
											<!-- FreeboardFileAction에 bo_no와 file_bo_no를 보낸다. -->
									</div>
									</c:forEach>
								</div>
							</div>
							<!-- Left and right controls -->
							<a class="carousel-control left" href="#myCarousel"
								data-slide="prev">&lsaquo;</a> <a class="carousel-control right"
								href="#myCarousel" data-slide="next">&rsaquo;</a>
						</div>


					</div>
				</div>
		</div>
					
					
					
					
					<div class="form-group">
						<label for="inputSubject" class="control-label col-sm-2"
							for="bo_title"> Title</label>
						<div class="input-icon right">
							<i class="fa fa-tag"></i> <input id="bo_title" type="text"
								name="bo_title" placeholder="" class="form-control" />
						</div>
			
						<label for="inputMessage" class="control-label col-sm-2"
							for="bo_content"> Content</label>
						<textarea rows="10" id="bo_content" class="form-control"
							name="bo_content"></textarea>
			
					</div>
				</div>
				</div>
			
				<div>
				<div>
		             <div>
						<div class="form-group"> 
							<div class="col-sm-offset-10 col-sm-10">
								<button type="submit" class="btn btn-success" >수정</button>
								<button type="button" class="btn btn-danger" id="deletebtn">삭제</button>
								<button type="button" class="btn btn-primary" id="replybtn">답글</button>
								<button type="button" class="btn btn-info" id="listbtn">목록</button>
					        
							</div>
						</div>
					</div>
				</div>
				</div>
			</form>
</body>

<script type = "text/javascript">
$(function(){
	
  $('#bo_no').val('${freeboardInfo.bo_no}')
  $('#bo_title').val('${freeboardInfo.bo_title}');
  $('#bo_nickname').val('${freeboardInfo.bo_nickname}');	
  $('#bo_pwd').val('${freeboardInfo.bo_pwd}');
  $('#bo_mail').val('${freeboardInfo.bo_mail}');
  $('#bo_content').val('${freeboardInfo.bo_content}');	
  $('#bo_group').val('${freeboardInfo.bo_group}');	
	
	//목록

	$('#listbtn').click(function(){
		$(location).attr('href', '${pageContext.request.contextPath}/user/freeboard/freeboardList.do');
	});

	
	//수정
/* 	$('#freeboardView').submit(function(){	 
		var flag = redirectFlag();
		 if(flag){
			$(location).attr('href', '${pageContext.request.contextPath}/user/freeboard/updatefreeboard.do');
		 }else{
				alertPRT('해당 게시글은 작성자만 수정할 수 있습니다.');
	    		
	    	}
	}); */
	

	//삭제
	$('#deletebtn').click(function(){
		var flag = redirectFlag();
		
		 var bo_no= $('#bo_no').val();
		 var bo_group= $('#bo_group').val();
    	 if(flag){
    			$(location).attr('href', '${pageContext.request.contextPath}/user/freeboard/deletefreeboard.do?bo_no='+bo_no+'&bo_group='+bo_group);
    	 }else{
	    		alertPRT('해당 게시글은 작성자만 삭제할 수 있습니다.');
	    		
	    	}
    });
	

	
	//댓글
	$('#replybtn').click(function(){
		 var bo_title =$('#bo_title').val();
	     var url = '${pageContext.request.contextPath}/user/freeboard/replyInfo.do';
	    $(location).attr('href', url + '?rnum=${freeboardInfo.rnum}&bo_title=' + bo_title + '&bo_group=${freeboardInfo.bo_group}&bo_seq=${freeboardInfo.bo_seq}&bo_depth=${freeboardInfo.bo_depth}');
	   });
});



function alertPRT(msg){
	BootstrapDialog.show({
	    title: '경고',
	    message: msg
	});
}

function redirectFlag(){
	if('${freeboardInfo.bo_writer}' == '${LOGIN_MEMBERINFO.mem_id}'){
		if('${freeboardInfo.bo_pwd}' == $('#bo_pwd').val()){
			return true;
		}
	}
	return false;
}	

</script>

</html>