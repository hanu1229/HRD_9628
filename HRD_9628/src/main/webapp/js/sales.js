

/** 매출조회 함수 */
let _findAll = () => {
	let tbody = document.querySelector("tbody");
	let html = ``;
	const option = {method : "GET"};
	
	fetch(`/HRD_9628/management/sales`, option)
	.then(response => response.json())
	.then(data => {
		console.log(data);	
		data.forEach((obj) => {
			html += `
			<tr>
				<td style = "width : 100px">${obj.custno}</td>
				<td style = "width : 100px">${obj.custname}</td>
				<td style = "width : 150px">${obj.grade}</td>
				<td style = "width : 150px">${obj.price}</td>
			</tr>
			`;
		});
		tbody.innerHTML = html;
	})
	.catch(error => { console.log(error); });
}