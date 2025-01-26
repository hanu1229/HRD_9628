

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
				<td style = "width : 100px"><a>${obj.custno}</a></td>
				<td style = "width : 100px">${obj.custname}</td>
				<td style = "width : 150px">${obj.phone}</td>
				<td style = "width : 300px">${obj.address}</td>
				<td style = "width : 150px">${obj.joindate}</td>
				<td style = "width : 150px">${obj.grade}</td>
				<td style = "width : 150px">${obj.city}</td>
			</tr>
			`;
		});
		tbody.innerHTML = html;
	})
	.catch(error => {console.log(error);});
}