// onload 이벤트에서 함수를 할당한다.
// 현재 페이지의 모든 내용이 브라우저에 로딩되고 난 후에 onload에 할당한 함수가 실행된다.
onload = () => {
	// alert('꺄~~~~~~~~~~~~');
	// button 태그를 찾아서 onclick 이벤트에 함수를 할당한다.
	// 이벤트에 함수를 할당할 때 함수 이름 위에 ()를 쓰면 자동 실행 함수로 인식되어 페이지가
	// 로딩될 때 자동으로 실행되기 때문에 자동으로 실행하면 안되는 함수에는 함수 이름 뒤에
	// ()를 쓰지 않는다.
	document.getElementsByTagName('button')[0].onclick = testDate1;
	document.querySelectorAll('button')[1].onclick = testDate2;
	document.querySelectorAll('button')[2].onclick = testDate3;
	document.querySelectorAll('button')[3].onclick = testDate4;
	document.querySelectorAll('button')[4].onclick = testDate5;
}


function testDate1() {
	let date = new Date();
	console.log(date); // Mon May 22 2023 13:39:48 GMT+0900 (한국 표준시)
	
	let today = document.getElementById('today');
	today.innerHTML = date; // Mon May 22 2023 13:39:48 GMT+0900 (한국 표준시)
	today.innerHTML = date.toDateString(); // Mon May 22 2023
	today.innerHTML = date.toLocaleString(); // 2023. 5. 22. 오후 1:42:00
	today.innerHTML = date.toLocaleDateString(); // 2023. 5. 22.
	today.innerHTML = date.toLocaleTimeString(); // 오후 1:43:00
}

function testDate2() {
	let date = new Date();
	console.log(date);
	
	// let year = date.getYear()+1900; // 년, 1900을 더해야 한다.
	let year = date.getFullYear(); // 년, 1900을 더할 필요없다.
	let month = date.getMonth() +1; // 월, 1을 더해야 한다.
	let day = date.getDate(); // 일
	let week = date.getDay(); // 요일, 일요일(0), 월요일(1), ... 토요일(6)
	let hour = date.getHours(); // 시
	let minute = date.getMinutes(); // 분
	let second = date.getSeconds(); // 초
	let milliSecond = date.getMilliseconds(); // 밀리초
	
	const weekDay = ['일','월','화','수','목','금','토'];
	let now = `${year}.${month}.${day}(${weekDay[week]}) ${hour}:${minute}:${second}.${milliSecond}`;
	console.log(now); 
	
	let today = document.getElementById('today');
	today.innerHTML = now;
}

function testDate3() {
	
}

function testDate4() {
	
}









































