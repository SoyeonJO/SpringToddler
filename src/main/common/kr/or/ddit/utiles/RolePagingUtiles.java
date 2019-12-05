package kr.or.ddit.utiles;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

// 리스트를 출력하는 UI에 문자열 베이스의 페이지네이션 컨텐츠를 제공
public class RolePagingUtiles {
	private int currentPage;		// 현재 페이지 번호
	private int totalCount;			// 전체 게시글 수
	private int totalPage;			// 전체 페이지 수
	private int blockCount = 10;	// 페이지별 출력될 게시글 수
	private int blockPage = 5;		// 페이지별 출력될 페이지 넘버 수
	private int startPage;			// 페이지별 출력될 페이지 넘버의 시작 번호
	private int endPage;			// 페이지별 출력될 페이지 넘버의 종료 번호
	private int startCount;			// 해당 페이지의 게시글 시작번호
	private int endCount;			// 해당 페이지의 게시글 종료번호
	private StringBuffer pagingHTMLS; // 페이지네이션 컨텐츠(문자열)
	private HttpServletRequest request;
	
	public RolePagingUtiles(int currentPage,
			                int totalCount,
			                HttpServletRequest request){
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.request = request;
		
		this.pagingHTMLS = new StringBuffer();
		
		makePagination();
	}

	private void makePagination() {
		// 전체 페이지 수
		this.totalPage = (int) Math.ceil(this.totalCount / (double)this.blockCount);
		if(this.totalPage == 0){
			this.totalPage = 1;
		}
		
		// 페이지별(10개 게시글, rownum 번호 desc)
		this.startCount = this.totalCount - (this.currentPage - 1) * this.blockCount;
		this.endCount = this.startCount - this.blockCount + 1;
		if(this.endCount < 0){
			this.endCount = 1;
		}
		
		// 이전|1|2|3|4|5|다음
		// 페이지네이션 메뉴의 시작, 종료 페이지번호
		this.startPage = ((this.currentPage - 1) / this.blockPage * this.blockPage) + 1;
		this.endPage = this.startPage + this.blockPage - 1;
		if(this.endPage > this.totalPage){
			this.endPage = this.totalPage;
		}
		
//	   <ul class="pagination mtm mbm">
//         <li class="disabled"><a href="#">&laquo;</a></li>
//         <li class="active"><a href="#">1</a></li>
//         <li><a href="#">2</a></li>
//         <li><a href="#">3</a></li>
//         <li><a href="#">4</a></li>
//         <li><a href="#">5</a></li>
//         <li><a href="#">&raquo;</a></li>
//     </ul>
		this.pagingHTMLS.append("<div class='text-center'>");
		this.pagingHTMLS.append("<ul class='pagination mtm mbm'>");
		
		String requestURI = this.request.getRequestURI();
		
		// /ddit13/main.jsp?search_keycode=헼&search_keyword=붹&currentPage=1
		String otherParams = "";
		Enumeration<String> queryStringKeys = request.getParameterNames();
		while(queryStringKeys.hasMoreElements()){
			String queryStringKey = queryStringKeys.nextElement();
			
			if("currentPage".intern() != queryStringKey.intern()){
				String queryStringValue = 
						request.getParameter(queryStringKey);
				otherParams += queryStringKey + "=" + 
						       queryStringValue + "&";
			}
		}
		
		// 이전
		if((this.currentPage - 1) == 0){
			this.pagingHTMLS.append("<li class='disabled'><a href='#'>&laquo;</a></li>");
		}else{
			this.pagingHTMLS.append("<li><a href='" + requestURI + "?currentPage=" + (this.currentPage - 1) + "'>&laquo;</a></li>");
		}
		
		// |1|2|3|4|5|
		for(int i=this.startPage; i<=this.endPage; i++){
			if(this.currentPage == i){
				this.pagingHTMLS.append("<li class='active'><a href='#'>" + i + "</a></li>");
			}else{
				this.pagingHTMLS.append("<li><a href='" + requestURI + "?currentPage=" + i + "'>" + i + "</a></li>");
			}
		}
		
		// 다음
		if(this.currentPage < this.totalPage){
			this.pagingHTMLS.append("<li><a href='" + requestURI + "?currentPage=" + (this.currentPage + 1) + "'>&raquo;</a></li>");
		}else{
			this.pagingHTMLS.append("<li class='disabled'><a href='#'>&raquo;</a></li>");
		}
		
		this.pagingHTMLS.append("</ul>");
		this.pagingHTMLS.append("</div>");
	}
	
	public String getPagingHTMLS(){
		return this.pagingHTMLS.toString();
	}

	public int getStartCount() {
		return startCount;
	}

	public int getEndCount() {
		return endCount;
	}
}








