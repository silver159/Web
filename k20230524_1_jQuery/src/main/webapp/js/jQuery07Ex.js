$(() => {
	// class 속성이 menu인 모든 div 태그의 자식인 div 태그를 숨긴다.
	$('.menu > div').hide();
	
	// hover(): 자바스크립트의 mouseenter, mouseleave 이벤트를 하나의 이벤트로 연결하고 선택된
	// 요소에서 mouseenter, mouseleave 이벤트가 발생되었을 때 설정한 함수를 실행한다.
	// mouseenter: 마우스가 요소 위로 올라올 때 발생되는 이벤트
	// mouseleave: 마우스가 요소에서 빠져나갈 때 발생되는 이벤트
	// hover(mouseenter 이벤트가 발생되면 실행할 함수, mouseleave 이벤트가 발생되면 실행할 함수)
	
	$('.menu').hover(
		// mouseenter 이벤트가 발생되면 실행할 함수
		function () {
			// 한번에 1개만 선택 가능 => this 사용, 화살표 안됨
			// stop(): 선택된 요소에서 실행중인 모든 이펙트를 즉시 중지시킨다.
			$(this).children('div').stop().slideDown();
		}, // ',' 잊지 말자
		// mouseleave 이벤트가 발생되면 실행할 함수
		function () {
			// 한번에 1개만 선택 가능 => this 사용, 화살표 안됨
			// stop(): 선택된 요소에서 실행중인 모든 이펙트를 즉시 중지시킨다.
			$(this).children('div').stop().slideUp();
		}
	);
});