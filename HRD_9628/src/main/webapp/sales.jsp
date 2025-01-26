<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel = "stylesheet" href = "style.css"/>
	</head>
	<body>
		<jsp:include page = "header.jsp"/>
		<jsp:include page = "nav.jsp"/>
		<section>
			<div class = "section_title">회원매출조회</div>
			<div class = "section_sales_content">
				<table border = "1">
					<thead>
						<tr>
							<th>회원번호</th>
							<th>회원성명</th>
							<th>고객등급</th>
							<th>매출</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
		</section>
		<jsp:include page = "footer.jsp"/>
		<script src = "./js/sales.js"></script>
		<script>_findAll()</script>
	</body>
</html>