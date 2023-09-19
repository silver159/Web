$(()=>{
// id 속성이 base인 div 태그를 선택해서 뒤에 새로운 요소를 추가한다.
	$('button:eq(0)').click(() => {
		// after(): 선택된 요소 외부 뒤에 인수로 지정한 새로운 요소를 추가한다.
		// $('선택자').after(추가할 요소)
		// $('#base').after('<div>after() 함수로 추가한 요소1</div>');
		// $('#base').after($('<div>').text('after() 함수로 추가한 요소2'));
		let $div = $('<div>').text('after() 함수로 추가한 요소3');
		$('#base').after($div);
	});
	
// id 속성이 base인 div 태그를 선택해서 뒤에 새로운 요소를 추가한다.
	$('button:eq(1)').click(function () {
		// insertAfter(): 새로운 요소를 인수로 지정한 요소 외부 뒤에 추가한다.
		// 잘 안쓰임 => after()만 기억하자
		// $(추가할 요소).insertAfter('선택자');
		// $('<div>insertAfter() 함수로 추가한 요소1</div>').insertAfter('#base');
		// $('<div>').text('insertAfter() 함수로 추가한 요소2').insertAfter('#base');
		let $div = $('<div>').text('insertAfter() 함수로 추가한 요소3');
		$($div).insertAfter('#base');
	});
	
// id 속성이 base인 div 태그를 선택해서 앞에 새로운 요소를 추가한다.	
	$('button:eq(2)').click(() => {
		// before(): 선택된 요소 외부 앞에 인수로 지정한 새로운 요소를 추가한다.
		// $('선택자').before(추가할 요소)
		// $('#base').before('<div>before() 함수로 추가한 요소1</div>');
		// $('#base').before($('<div>').text('before() 함수로 추가한 요소2'));
		let $div = $('<div>').text('before() 함수로 추가한 요소3');
		$('#base').before($div);
	});
	
// id 속성이 base인 div 태그를 선택해서 앞에 새로운 요소를 추가한다.	
	$('button:eq(3)').click(() => {
		// insertBefore(): 새로운 요소를 인수로 지정한 요소 외부 앞에 추가한다.
		// 잘 안쓰임 => after()만 기억하자
		// $(추가할 요소).insertBefore('선택자');
		// $('<div>insertBefore() 함수로 추가한 요소1</div>').insertBefore('#base');
		// $('<div>').text('insertBefore() 함수로 추가한 요소2').insertBefore('#base');
		let $div = $('<div>').text('insertBefore() 함수로 추가한 요소3');
		$($div).insertBefore('#base');
	});
});	




























































