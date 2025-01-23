

/** 회원조회 함수 */
let _findAll = () => {
	let tbody = document.querySelector("tbody");
	let html = ``;
	let option = {method : "GET"};
	
	fetch(`/HRD_9628/management`, option)
	.then(response => response.json())
	.then(data => {
		data.forEach(obj => {			
			html += `
			<tr>
				<td>${data.custno}</td>
				<td>${data.custname}</td>
				<td>${data.phone}</td>
				<td>${data.address}</td>
				<td>${data.joindate}</td>
				<td>${data.grade}</td>
				<td>${data.city}</td>
			</tr>
			`;
		});
		tbody.innerHTML = html;
	})
	.catch(error => {console.log(error);});
}