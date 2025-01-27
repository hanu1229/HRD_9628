

/** 회원정보 불러오기 */
let readCust = () => {
	let custnoInput = document.querySelector("#custno_input");
	let custnameInput = document.querySelector("#custname_input");
	let phoneInput = document.querySelector("#phone_input");
	let addressInput = document.querySelector("#address_input");
	let joindateInput = document.querySelector("#joindate_input");
	let gradeInput = document.querySelector("#grade_input");
	let cityInput = document.querySelector("#city_input");
	
	let custno = new URL(location.href).searchParams.get(`custno`);
	const option = {method : "GET"}
	fetch(`/HRD_9628/management/update?custno=${custno}`, option)
	.then(response => response.json())
	.then(data => {
		custnoInput.value = data.custno;
		custnameInput.value = data.custname;
		phoneInput.value = data.phone;
		addressInput.value = data.address;
		joindateInput.value = data.joindate;
		gradeInput.value = data.grade;
		cityInput.value = data.city;
		console.log(data);
	})
	.catch(error => { console.log(error); });
}

/** 회원정보 수정 */
let _update = () => {
	let custnoInput = document.querySelector("#custno_input");
	let custnameInput = document.querySelector("#custname_input");
	let phoneInput = document.querySelector("#phone_input");
	let addressInput = document.querySelector("#address_input");
	let joindateInput = document.querySelector("#joindate_input");
	let gradeInput = document.querySelector("#grade_input");
	let cityInput = document.querySelector("#city_input");
	let object = {
		custno : custnoInput.value,
		custname : custnameInput.value,
		phone : phoneInput.value,
		address : addressInput.value,
		joindate : joindateInput.value,
		grade : gradeInput.value,
		city : cityInput.value
	}
	
	const option = {
		method : "PUT",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(object)
	};
	
	fetch(`/HRD_9628/management/update`, option)
	.then(response => response.json())
	.then(data => {
		if(data == true) {
			alert("회원정보수정이 완료 되었습니다.");
			location.href = `/HRD_9628/inquiry.jsp`;
		} else {
			alert("회원정보수정을 실패 했습니다.");
		}
	})
	.catch(error => { console.log(error); });
	
}