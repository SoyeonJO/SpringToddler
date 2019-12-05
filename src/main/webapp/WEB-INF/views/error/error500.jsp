<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head profile="http://a9.com/-/spec/opensearch/1.1/">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="autocomplete" content="off" />
<title>Sunmi 에러페이지 | 서버에러</title>
<style type="text/css">
body, div, p, h1, h2, h3, fieldset { padding:0; margin:0; }
body { background:#fff url(http://icon.daumcdn.net/error/error_top_bg.gif) repeat-x; text-align:center; }
ul, li, dl, dt, dd { list-style:none; margin:0; padding:0; }
h1 { display:none; }

#topArea { width:538px; background:url(http://icon.daumcdn.net/error/error_bar.gif) no-repeat bottom; margin:68px auto 45px auto; padding-bottom:6px; height:35px; }
#topArea a.daum { background:url(http://icon.daumcdn.net/2010_global/daumlogo_bg.gif) no-repeat; width:62px; height:26px; display:inline; text-indent:-10000em; float:left;margin:0 0 0 17px;}
#topArea #serviceLink { float:right; margin:17px 3px 0 0; }
#topArea #serviceLink li { float:left; }
#topArea #serviceLink li.dot { background:url(http://icon.daumcdn.net/error/error_m.gif) no-repeat; padding-left:8px; }
#topArea #serviceLink a.lnk_daum { background:url(http://icon.daumcdn.net/error/error_m1.gif) no-repeat; width:63px; height:12px; display:block; text-indent:-10000em; }
#topArea #serviceLink a.lnk_cs { background:url(http://icon.daumcdn.net/error/error_m2.gif) no-repeat; width:43px; height:12px; display:block; text-indent:-10000em; }
#content, #footTxt { width:428px; margin:0 auto; text-align:left; }
#content h3 { background:url(http://icon.daumcdn.net/error/error_ic.gif) no-repeat; padding:12px 0 0 70px; font-size:18px; font-family:dotum,돋움,sans-serif; letter-spacing:-1px; color:#333; line-height:25px; height:41px; margin-bottom:34px; }
#content h3.line2 {height:47px;padding-top:6px;}
#content p { font-size:12px; font-family:dotum,돋움,sans-serif; color:#666; line-height:18px; padding-bottom:10px; }
#content p a { font-weight:bold; color:#576FE6; text-decoration:underline; }
#footTxt { clear:both;width:360px;margin:10px auto; font-size:11px; font-family:dotum,돋움,sans-serif; color:#8C9AFF;}

#expTxt { margin:9px auto 22px auto; border:#E7E8ED solid 1px; background:#FBFBFB; font-size:12px; font-family:dotum,돋움,sans-serif; color:#666; padding:13px 44px 12px 44px; }
#expTxt li { height:16px;line-height:16px;background:url(http://icon.daumcdn.net/error/dot.gif) 0 5px no-repeat; padding:0 0 2px 10px; }
#expTxt em { color:#576FE6; font-style:normal; }

.btn_area {width:428px; height:28px;margin:16px auto 0 auto;text-align:center;}
.btn_area a {display:inline;float:left;height:28px;overflow:hidden;}
.btn_area .btn_go_home {text-indent:-3000em;width:95px;background:url(http://icon.daumcdn.net/error/bt_home.gif);}
.btn_area .btn_option {position:relative;height:20px;margin-right:5px;padding:0 10px 0 11px;padding-top:8px;background:url(http://icon.daumcdn.net/error/bt_bg.gif);font-weight:bold;color:#fff;font-size:12px;text-decoration:none;}
.btn_area .btn_option .l{position:absolute;top:0;left:0;width:11px;height:28px;background:url(http://icon.daumcdn.net/error/bt_left.gif);}
.btn_area .btn_option .r{position:absolute;top:0;right:0;width:10px;height:28px;background:url(http://icon.daumcdn.net/error/bt_right.gif) -2px 0;}

/* custom button (옵션 버튼 수정시 margin 값 조정해 주세요.) */
/*.btn_ok {margin-left:135px;}*/
.btn_area .btn_option {display:none;}
.btn_area .btn_go_home {margin-left:142px;}

#bottomArea { width:518px; margin:53px auto 50px auto; border-top:1px #E0E4F0 solid; padding-top:11px; font-size:11px; font-family:Tahoma; color:#999; }
#bottomArea a { color:#999; text-decoration:none; }
#bottomArea a:hover { text-decoration:underline; }

#tsch_area { width:345px; height:35px; margin:50px auto 0 auto; text-align:left; }
#tsch_area ul, #tsch_area li, #tsch_area fieldset, #tsch_area form { list-style:none; margin:0; padding:0; }
#tsch_area h2, #tsch_area legend { display:none; }
#tsch_area fieldset {border:0 none;}
#daumSearch {color:#000;}
#daumSearch .searchbar {background:url(http://icon.daumcdn.net/2010_global/bgSearch2.gif) no-repeat;width:265px;height:31px;float:left;display:inline; margin-right:4px}
#daumSearch input.search {width:233px;background-color:transparent;color:#000;border:none 0;margin:4px;padding:4px 4px 3px 4px;float:left;display:inline; height:18px;outline:none;font:12px/1.5 dotum,sans-serif}
#daumNoSuggest {background:url(http://icon.daumcdn.net/2010_global/icoSuggest.gif) no-repeat;width:16px;height:17px;position:relative;margin:7px -3px 0 0;border:none;float:left;display:inline;}
#daumBtnSearchAll {background:url(http://icon.daumcdn.net/2010_global/btnSearch2.gif) no-repeat 0 0;width:57px;height:31px;border:none;text-indent:-9999in;overflow:hidden; cursor:pointer;vertical-align:top;float:left;display:inline;}
#daumBtnSearchAll:hover {background-position:0 bottom}

#serviceArea { width:502px; margin:22px auto 0 auto;}
#flashMovie { margin:37px auto 0 auto; width:502px; }
</style>
<!--[if IE]>
<style type="text/css">
.btn_area .btn_option {;height:19px;padding-top:9px;}
</style>
<![endif]--></head>

<body>
<h1>Sunmi 에러페이지</h1>

<div id="topArea">
	<h2><a href="http://www.daum.net" title="Sunmi 첫화면으로 가기" target="_top" class="daum">Sunmi</a></h2>
</div>

<div id="content">
	<h3>해당 서비스 접속이  원활하지 않습니다.</h3>

	<p>
		보다 신속하게 문제를 해결하고자 노력 중이며<br/>
		원활한 서비스를 제공할 수 있도록 최선을 다하겠습니다.
	</p>
	<p>
		잠시 후에 다시 접속해 주시면 감사하겠습니다.<br/>
		이용에 불편을 드린 점, 다시 한번 머리 숙여 사과의 말씀 드립니다.
	</p>
	<p>
		아래 바로 가기 버튼을 클릭 후 이동하여 이용해 주시기 바랍니다.<br/>
		관련하여 문의가 있으시면 언제든지, <a href="http://cs.daum.net/notice/list.html" target="_top">고객센터</a>로 문의하여 주십시오.
	</p>
</div>

<div class="btn_area">
	<!-- option 버튼 수정시 btn_ok 스타일 수정해 주세요. -->
	<a href="#" class="btn_option btn_ok" style=""><span class="l"></span>확인<span class="r"></span></a>
	<a href="http://www.daum.net" class="btn_go_home">Sunmi 첫화면</a>
</div>

<div id="tsch_area">
	<h2 class="daumhide">검색</h2>
	<form id="daumSearch" name="daumSearch" action="http://search.daum.net/search">
		<div class="searchbar">
			<input type="text" class="search" id="q" name="q" />
			<span id="daumNoSuggest"></span>
		</div>
		<input type="submit" id="daumBtnSearchAll" value="통합검색" />
	</form>
</div>

<p id="footTxt">이젠, 검색도 선미입니다. 원하시는 모든 것을 선미검색에서 찾으세요.</p>


<div id="bottomArea">
	Copyright (c) <a href="http://info.daum.net/" target="_top">Sunmi Communications.</a> All rights reserved.
</div>
<script type="text/javascript">
//<![CDATA[
//2008.08.06 by boss check logs
var rand = Math.random().toString();
var dummy = rand.substring(2,rand.length);
var param = "?dummy="+dummy+"&istop=";
var isTop = "yes";
try {
	if (top.location.href != this.location.href) {
		isTop = "no";
	}
} catch(e) {
	isTop = "err";
}
param += isTop + "&referer=" + document.referrer;

document.write('<img src="http://status.daum.net/jserror/index.gif'+param+'" style="display:none;">');
//]]>
</script>
<!--[if lte IE 6]>
<script type="text/javascript">
//<![CDATA[
(function() {
	var daumBtnSearchAll = document.getElementById('daumBtnSearchAll');
	var daumSuggest = document.getElementById('daumSuggest');

	daumBtnSearchAll.onmouseover = function() {this.style.backgroundPositionY='bottom'};
	daumBtnSearchAll.onmouseout = function() {this.style.backgroundPositionY='top'};
})();
//]]>
</script>
<![endif]-->
</body>
</html>

    