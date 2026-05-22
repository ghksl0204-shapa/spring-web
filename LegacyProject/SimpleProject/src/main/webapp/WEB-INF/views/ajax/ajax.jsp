<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에이젝스</title>
</head>
<body>
	<h1>AJAX</h1>
	
	<jsp:include page="../include/header.jsp"/>
	
	<div class="innerOuter">
		댓글 작성, 댓글 조회, API호출해서 앱 만들때
		-----------------------------
		
		AJAX란?
		<pre>
			궵페이지 전체를 새로고침하지 않고 화면을 갱신할 수 있는 기술
				
			핵심 : 비동기통신 => 부분갱신 => 사용자 경험 형상 
								=> 트래픽 줄어듬
			 -------------------------------------
			 전체 적인 흐름
			 
			 1. 클라이언트가 요청을 보냄(JS를 이용해서)
			 전송데이터 형식 => 과거에는 XML사용 => 현재 JSON
			 AJAX API => 과거에는 XMLHttpRequest => jQuery(ajax()) => modern Fetch API => axios() 
			 ----------------------------------------------------------------------------------
			 2.서버는 요청 처리 후 데이터 응답(JSON형태로)
			 ----------------------------------------------------------------------------------
			 3. 클라이언트는 응답받은 데이터를 활용해서 자바스크립트를 이용해서 DOM요소객체를 갱신
		</pre>
		
		<hr>
		
		<h3>버튼을 클릭해서 GET방식으로 요청을 보낸 뒤 데이터를 응답받아서 화면에 출력</h3>
		<div class="form-group">
			<div class="form-control">
				<button class="btn btn-sm btn-success" onclick="test1();">요청보내기</button>		
			</div>
			<div class="form-control">
				<button class="btn btn-sm btn-danger" onclick="test2();">요청보내기</button>		
			</div>
		</div>
		
		<hr>
		동기 방식 요청 : <label id="result1"></label>
			<c:choose>
				<c:when test="${ empty count }">
					게시글 총 개수
				</c:when>
				<c:otherwise>
					${ count }
				</c:otherwise>
			</c:choose>
		<hr>
		비동기 방식 요청 : <label id="result2">게시글 총 개수</label>
		
		<script>
			function test1(){
				location.href = "/spring/sync";	
			}
			function test2(){
				fetch('/spring/async')
					.then(response => response.json())
					.then(data => {
						console.log(data);
						document.querySelector('#result2').innerHTML = data.result;
					});
			}
		</script>
		
		
	</div>
	<jsp:include page="../include/footer.jsp"/>
</body>
</html>