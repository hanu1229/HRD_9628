<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>회원등록</title>
	<link rel = "stylesheet" href = "style.css"/>
	</head>
	<body>
		
		<jsp:include page = "header.jsp"/>
		<jsp:include page = "nav.jsp"/>
		<section>
			<div class = "section_title">홈쇼핑 회원 등록</div>
			<div class = "section_registration_content">
				<table border = "1">
					<tbody>
						<tr>
							<td class = "first_cell">회원번호(자동발행)</td>
							<td class = "second_cell">
								<input id = "custno_input" readonly type = "search"/>
							</td>
						</tr>
						<tr>
							<td class = "first_cell">회원성명</td>
							<td class = "second_cell">
								<input id = "custname_input" type = "search"/>
							</td>
						</tr>
						<tr>
							<td class = "first_cell">회원전화</td>
							<td class = "second_cell">
								<input id = "phone_input" style = "width : 200px" type = "search"/>
							</td>
						</tr>
						<tr>
							<td class = "first_cell">회원주소</td>
							<td class = "second_cell">
								<input id = "address_input" style = "width : 400px" type = "search"/>
							</td>
						</tr>
						<tr>
							<td class = "first_cell">가입일자</td>
							<td class = "second_cell">
								<input id = "joindate_input" type = "search"/>
							</td>
						</tr>
						<tr>
							<td class = "first_cell">고객등급[A:VIP,B:일반,C:직원]</td>
							<td class = "second_cell">
								<input id = "grade_input" type = "search"/>
							</td>
						</tr>
						<tr>
							<td class = "first_cell">도시코드</td>
							<td class = "second_cell">
								<input id = "city_input" type = "search"/>
							</td>
						</tr>
						<tr>
							<td colspan = "2" style = "text-align : center">
								<button onclick = "_create()">등 록</button>
								<button>조 회</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</section>
		<jsp:include page = "footer.jsp"/>
		<script src = "./js/registration.js"></script>
		<script>autoCustno()</script>
	</body>
</html>