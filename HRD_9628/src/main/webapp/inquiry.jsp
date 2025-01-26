<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>회원목록조회/수정</title>
	</head>
	<body>
	
	<jsp:include page = "header.jsp"/>
	<jsp:include page = "nav.jsp"/>
	<section>
		<div class = "section_title">회원목록조회/수정</div>
		<div class = "section_inquiry_content">
			<table border = "1">
				<thead>
					<tr>
						<th>회원번호</th>
						<th>회원성명</th>
						<th>전화번호</th>
						<th>주소</th>						<th>가입일자</th>
						<th>고객등급</th>
						<th>거주지역</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
		</div>
	</section>
	<jsp:include page = "footer.jsp"/>
	<script src = "./js/inquiry.js"></script>
	<script>_findAll()</script>
	</body>
</html>