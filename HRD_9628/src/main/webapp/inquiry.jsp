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
						<td>회원번호</td>
						<td>회원성명</td>
						<td>전화번호</td>
						<td>주소</td>
						<td>가입일자</td>
						<td>고객등급</td>
						<td>거주지역</td>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
		</div>
	</section>
	<jsp:include page = "footer.jsp"/>
	
	</body>
</html>