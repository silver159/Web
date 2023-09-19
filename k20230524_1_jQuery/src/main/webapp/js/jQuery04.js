//	 input 태그의 type 속성별 선택 <input> 에서만 사용 가능!!!
//   :button: type 속성이 'button'인 모든 요소를 선택한다.
//   :checkbox: type 속성이 'checkbox'인 모든 요소를 선택한다.
//   :file: type 속성이 'file'인 모든 요소를 선택한다.
//   :image: type 속성이 'image'인 모든 요소를 선택한다.
//   :password: type 속성이 'password'인 모든 요소를 선택한다.
//   :radio: type 속성이 'radio'인 모든 요소를 선택한다.
//   :reset: type 속성이 'reset'인 모든 요소를 선택한다.
//   :submit: type 속성이 'submit'인 모든 요소를 선택한다.
//   :text: type 속성이 'text'인 모든 요소를 선택한다.
//   :checked: type 속성이 'checkbox' 또는 'radio'인 요소 중에서 체크된 모든 요소들을 선택한다.
//   :selected: option 요소 중에서 선택된 모든 요소들을 선택한다.
//   :focus: 현재 포커스를 가지고 있는 요소를 선택한다.
//   :disabled: 비활성화 되어있는 모든 요소를 선택한다.
//   :enabled: 활성화 되어있는 모든 요소를 선택한다.

function choice() {
	/* 
	// javascript
	
	// 전체 선택
	// let inputs = document.getElementsByTagName('input');
	// let inputs = document.querySelectorAll('input');
	// console.log(inputs.length);
	// console.log(inputs[0]);
	
	// 개별 선택
	// let input = document.getElementsByTagName('input')[0];
	let input = document.querySelectorAll('input')[0];
	console.log(input.value);
	input.value = '임꺽정'
	*/
	
	// javascript는 value 속성을 사용해서 '~~~~.value' 형태로 값을 얻어오고 '~~~~.value' = '값'
	// 형태로 넣어준다.
	
	// jQuery는 value 속성을 사용하지 않고 val() 함수를 사용해서 '~~~~.val()' 형태로 값을 
	// 얻어오고 '~~~~.val(값)' 형태로 값을 넣어준다.
	
	// jQuery
	
	// 전체 선택
	// let inputs = $('input'); // <input> 태그 전체를 배열로 얻어온다.
	// console.log(inputs.length);
	// let inputs = $('input[type=text]'); // <input> 태그 중에서 type 속성의 값이 text인 태그 
	// 전체를 얻어온다.
	let inputs = $('input:text'); // <input> 태그에서만 가능
	// console.log(inputs.length);
	
	// 아래와 같이 실행하면 input 태그의 type 속성이 text인 요소가 여러개 있더라도 첫 번째
	// 요소의 값만 얻어온다.
	// let doc = $('input:text').val();
	// console.log(doc);
	
	console.log(inputs);
	// 배열의 인덱스 지정이 안된 상태에서 value를 사용하면 undefined가 리턴된다.
	console.log(inputs.value); // undefined. inputs 인덱스를 지정해야 한다. inputs는 배열이다.
	console.log(inputs[0].value); // javascript 방식
	console.log(inputs[1].value); 
	console.log('================================'); 
	
	let text = $('input:text').eq(0); // jQuery 방식
	console.log(text.value); // undefined, jQuery 방식일 때는 value 사용 불가
	console.log(text.val()); // jQuery 방식일 때는 val() 함수 사용
	
	let text2 = $('input:text').eq(1); // jQuery 방식
	console.log(text2.value); // undefined, jQuery 방식일 때는 value 사용 불가
	console.log(text2.val()); // jQuery 방식일 때는 val() 함수 사용
	
	text.val('장길산'); // 첫 번째일 경우 인덱스를 안 지정해도 들어간다.
	$('input:text').eq(1).val('일지매')
	
}

function choice2() {
	
	/*
	// javascript 방식
	let input = document.getElementsByTagName('input')[3];
	console.log(input);
	console.log(input.value);
	// document.getElementsByTagName('div')[0].innerHTML = '<h1>' + input.value + '</h1>';
	// document.querySelectorAll('div')[0].innerHTML = '<h1>' + input.value + '</h1>';
	// document.getElementById('a').innerHTML = '<h1>' + input.value + '</h1>';
	document.querySelector('#a').innerHTML = '<h1>' + input.value + '</h1>';
	// document.querySelector('#a').innerText = '<h1>' + input.value + '</h1>';
	// document.querySelector('#a').textContent = '<h1>' + input.value + '</h1>'; // 태그 무시
	*/
	
	// jQuery
	// let text = $('input:radio').val(); // 첫번째 radio 나온다.
	// let text = $('input:radio').eq(0).val();
	let text = $('input:radio:eq(0)').val();
	console.log(text);
	
	// javascript는 innerHTML, innerText, textContent()를 사용해서 태그 내부에 텍스트를 넣는다.
	// jQuery는 innerHTML 역활을 하는 html() 함수나 innerText, textContent() 역활을 하는
	// text() 함수로 태그 내부에 텍스트를 넣어준다.
	// html() 함수는 태그를 지원하고 text() 함수는 태그를 지원하지 않는다.
	
	// $('div').eq(0).html('<h1>' + text + '</h1>');
	// $('div:eq(0)').text('<h1>' + text + '</h1>');
	$('#a').html('<h1>' + text + '</h1>');
	
}

function choice3() {
	let text = $('input:checkbox:eq(0)').val();
	$('#a').html('<h1>' + text + '</h1>');
}


// onload
// $(document).ready(function () {
// $().ready(function () {
// $().ready(() => {
// $(function () {
$(() => {
	/* javascript => 이벤트 이름에 on이 붙는다.
	// let select = document.getElementsByTagName('select')[0];
	let select = document.querySelectorAll('select')[0];
	// console.log(select);
	
	// 이벤트를 연결할 객체.이벤트 = function () {}
	// 이벤트를 연결할 객체.이벤트 =  () => {}
	// js 33번 파일 참고
	select.onchange = () => {
		console.log(select.selectedIndex); // 몇 번째 option이 선택되었나 얻어온다.
		console.log(select.options); // option 목록을 배열 형태로 얻어온다.
		console.log(select.options[select.selectedIndex]); // 선택된 option을 얻어온다.
		console.log(select.options[select.selectedIndex].value); // 선택된 option의 값을 얻어온다.
		// document.getElementsByTagName('input')[0].value = select.options[select.selectedIndex].value;
		document.querySelectorAll('input')[0].value = select.options[select.selectedIndex].value;
	}
	*/	
		
	// jQuery	
	// javascript는 onclick, onchange, onload와 같이 이벤트 이름이 'on'으로 시작하지만
	// jQuery는 이벤트 이름이 'on'으로 시작하지 않는다. => click(), change()
	// 이벤트를 연결할 객체.이벤트함수(function () {})
	// 이벤트를 연결할 객체.이벤트함수(() => {})  
	// $('select').eq(0)   .change();
	
	// $('select').eq(0).change(function () {
	$('select').eq(0).change(() => {
		// console.log('select 태그에서 change() 이벤트가 실행됨');
		// :selected: option 요소 중에서 선택된 모든 요소들을 선택한다.
		// option:selected는 option 태그 중에서 선택된(selected) option 태그를 얻어온다.
		let select = $('select:eq(0) > option:selected').eq(0).val(); // .eq(0) 없어도 가능
		console.log(select);
		// $('input:text').eq(0).val(select);
		// $('input:text:eq(0)').val(select);
		$('input:text:eq(0)').val($('select:eq(0) > option:selected').eq(0).val());
	}); 
	
	// let radios = $('input[name=gender]');
	// console.log(radios.length);
	
	$('input[name=gender]').click(() => {
		$('input:text:eq(1)').val($('input[name=gender]:checked').val());
	});
});
















































