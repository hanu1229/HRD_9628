

/** 회원번호 자동 발행 */
let autoCustno = () => {
	let custnoInput = document.querySelector("#custno_input");
	let custno = 0;
	const option = {method : "GET"}
	
	fetch(`/HRD_9628/management`, option)
	.then(response => response.json())
	.then(data => {
		data.forEach(obj => {
			custno = obj.custno;
		});
		console.log("최종 custno : " + custno);
		custnoInput.value = custno + 1;
	})
	.catch(error => { console.log(error); });
}

/** 회원등록 함수 */
let _create = () => {
	let custnoInput = document.querySelector("#custno_input");
	let custnameInput = document.querySelector("#custname_input");
	let phoneInput = document.querySelector("#phone_input");
	let addressInput = document.querySelector("#address_input");
	let joindateInput = document.querySelector("#joindate_input");
	let gradeInput = document.querySelector("#grade_input");
	let cityInput = document.querySelector("#city_input");
	
	let custno = custnoInput.value;
	let custname; let phone; let address; let joindate; let grade; let city;
	
	//console.log(`custnameInput.value :@@@@${custnameInput.value}@@@@`);
	//console.log(`custname.value.length : ${custnameInput.value.length}`);
	// 유효성 검사 : 회원성명
	if(custnameInput.value.length >= 2) {
		custname = custnameInput.value;
	} else {
		alert("회원성명이 입력되지 않았습니다.");
		return;
	}
	let phoneList = phoneInput.value.split("-");
	console.log(phoneList);
	// 유효성 검사 : 회원전화
	if(phoneInput.value.length == 13 && phoneList.length == 3) {
		phone = phoneInput.value;
	} else {
		alert("회원전화가 입력되지 않았습니다.");
		return;
	}
	// 유효성 검사 : 회원주소
	if(addressInput.value.length >= 6) {
		address = addressInput.value;
	} else {
		alert("회원주소가 입력되지 않았습니다.");
		return;
	}
	// 유효성 검사 : 가입일자
	if(joindateInput.value.length == 8) {
		joindate = joindateInput.value;
	} else {
		alert("가입일자가 입력되지 않았습니다.");
		return;
	}
	// 유효성 검사 : 고객등급
	if(gradeInput.value == "A" || gradeInput.value == "B" || gradeInput.value == "C") {
		grade = gradeInput.value;
	} else {
		alert("고객등급이 입력되지 않았습니다.");
		return;
	}
	// 유효성 검사 : 도시코드
	if(cityInput.value.length >= 2) {
		city = cityInput.value;
	} else {
		alert("도시코드가 입력되지 않았습니다.");
		return;
	}
	console.log(`
		custno : ${custno} / custname : ${custname} / phone : ${phone} / 
		address : ${address} / joindate : ${joindate} / grade : ${grade} / city : ${city}
		`);
	let object = {custno : custno, custname : custname, phone : phone, address : address, joindate : joindate, grade : grade, city : city};
	const option = {
		method : "POST",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(object)
	};
	fetch(`/HRD_9628/management`, option)
	.then(response => response.json())
	.then(data => {
		if(data == true) {
			alert("회원등록이 완료 되었습니다.");
			location.href = `/HRD_9628/inquiry.jsp`;
		} else {
			alert("회원등록이 실패 되었습니다.");
		}
	})
	.catch(error => { console.log(error); });
	
}




