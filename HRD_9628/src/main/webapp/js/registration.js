

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
	
	let custname; let phone; let address; let joindate; let grade; let city;
	
	console.log(`custnameInput.value :@@@@${custnameInput.value}@@@@`);
	console.log(`custname.value.length : ${custnameInput.value.length}`);
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
	if(phoneInput.value.length == 13 && phoneList.length()+1 == 3) {
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
	
	
}




