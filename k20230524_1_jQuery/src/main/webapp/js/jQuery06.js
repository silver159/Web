$(() => {
	// 클래스 속성값이 error로 지정된 에러 메시지를 숨긴다.
	$('.error').hide();
	
	// id 속성값이 single로 지정된 form에서 submit 클릭되면 실행할 이벤트를 설정한다.
	// submit 이벤트는 input 태그나 button 태그의 type 속성값이 submit인 버튼이 클릭 되면
	// 발생되는 이벤트이다.
	// jQuery는 submit이고 html 이나 javascript에서는 onsubmit 이다.
	// submit 이벤트에서는 서버로 전송하기 전에 폼의 유효성을 검사하고 입력된 데이터가 이상이
	// 없으면 true를 리턴시키고 이상이 있으면 에러 메시지를 출력한 후 false를 리턴시킨다.
	// submit 이벤트의 실행 결과가 true(기본값)면 action 속성에 지정된 페이지로 이동하고 실행
	// 결과가 false면 현재 페이지를 표시한다.
	
	$('#single').submit(function () {
		// console.log('submit 이벤트 실행됨');
		// let userID = $('input:text[name=userID]').val();
		let userID = $('#infoBox').val();
		// console.log(userID);
		if(userID == null || userID == undefined || userID.trim() == ''){ // 유효성 검사
			$('#infoBox').val('');
			$('#infoBox').focus();
			$('.error').show(); // 감춰둔 에러 메시지를 표시한다.
			return false; // false를 리턴시키면 현재 페이지에 그대로 머물러있는다.
		}
		// return true; // true를 리턴시키면 action 속성에 지정된 페이지로 이동한다. (기본값)
	});
	
	// 전체 선택 체크 박스가 클릭되면 모든 체크 박스를 선택 또는 해체한다.
	$('input:checkbox[name=all]').click(function () {
		// console.log('전체 선택 체크 박스 출력');
		// prop('속성이름'): 인수로 지정된 속성의 프로퍼티를 얻어온다.
		let checked = $('input:checkbox[name=all]').prop('checked')
		// console.log(checked); // checked의 속성의 프로퍼티: true/false
		
		// name 속성이 chk인 체크 박스의 프로퍼티를 name 속성이 all인 체크 박스의 프로퍼티로
		// 변경한다.
		// prop('속성이름','프로퍼티'): 인수로 지정된 속성의 프로퍼티를 변경한다.
		
		/* index 사용. 일반 익명 함수
		$('input:checkbox[name=chk]').each(function (index, obj) { // obj 사용 안할 시 생략가능
			// console.log(index, obj)
			$('input:checkbox[name=chk]').eq(index).prop('checked', checked);
		});
		*/
		/* index 사용. 화살표 함수로
		$('input:checkbox[name=chk]').each( index => {
			$('input:checkbox[name=chk]').eq(index).prop('checked', checked);
		});
		*/
		/*
		$('input:checkbox[name=chk]').each(function () {
			// console.log($(this)) // 한개씩 넘어올 때는 this를 사용한다.
			// js 36 파일 참고!!!
			$(this).prop('checked', checked);
			// obj.setAttribute('checked', checked);
		});
		*/
		$('input:checkbox[name=chk]').prop('checked', checked); //jQuery는 자동으로 반복해준다.
	})
	// name 속성이 chk인 체크 박스가 클릭되면 name 속성이 chk인 모든 체크 박스가 체크되었나 
	// 검사해서 모두 체크되었으면 전체 선택 체크박스를 체크하고 그렇지 않으면 체크를 해제한다.
	$('input:checkbox[name=chk]').click(function () {
		// console.log('name 속성 값이 chk인 체크 박스 출력');
		// name 속성이 chk인 요소의 전체 개수와 name이 chk인 요소 중에서 체크된 요소의 개수를
		// 비교한다.
		// console.log('name 속성 값이 chk인 요소의 전체 개수: ' + $('input:checkbox[name=chk]').length);
		// console.log('name 속성 값이 chk인 요소 중에서 체크된 요소의 개수: ' + 
		//		$('input:checkbox[name=chk]:checked').length);
		if ( $('input:checkbox[name=chk]').length == $('input:checkbox[name=chk]:checked').length){
			// console.log('모두 체크됨');
			$('input:checkbox[name=all]').prop('checked', true);
		}else{
			// console.log('모두 체크되지 않음');
			$('input:checkbox[name=all]').prop('checked', false);
		}
	});
	
	// 체크 박스를 선택하고 확인 버튼을 클릭하면 체크 여부를 확인해서 그 결과를 id 속성이 
	// result로 지정된 div태그 내부에 출력한다.
	
	$('#confirm').click(function () {
		// console.log('확인 버튼 click 이벤트 실행')
		// 선택한 과일 가격이 표시될 div 태그 내부의 내용을 지운다.
		// $('#result').html('');
		// $('#result').text('');
		// empty(): 선택된 요소의 내부 내용을 지운다.
		$('#result').empty(); // append() 함수 사용시 필수적!!!
		
		// name 속성에 chk가 지정된 체크 박스의 체크된 항목의 개수를 얻어온다.
		let chks = $('input:checkbox[name=chk]:checked')
		let count = chks.length;
		// console.log(count);
		if(count == 0){
			$('#result').html('<b style="color: red;">과일을 1개 이상 선택하세요</b>')
		}else{
			chks.each(function (index) {
				let chk = chks.eq(index);
				// console.log(chk); // <input type="checkbox" name="chk" value="1000"/>사과<br/>
				console.log(chk.val());  // 과일 가격
				// console.log(chk.next()); // <input> 태그의 형제인 <span> 태그를 선택한다.
				console.log(chk.next().html());  // 과일 이름
				// $('#result').html(`과일 이름: ${chk.next().html()}, 과일 가격: ${chk.val()}<br/>`)
				// append(): html() 함수나 text() 함수는 기존 내용을 지우고 인수로 지정한 
				// 내용을 넣어주지만 append() 함수는 기존의 내용에 인수로 지정한 내용을 추가한다.
				$('#result').append(`과일 이름: ${chk.next().html()}, 과일 가격: ${chk.val()}<br/>`)
			})
		}
	});
	
// 형제(sibling) 요소 탐색
// .siblings() : 선택된 요소의 형제 요소 중에서 지정한 선택자에 해당되는 모든 형제 요소를 선택한다.
// .next() : 선택된 요소 바로 다음에 위치한 형제 요소 1개를 선택한다. 제일 많이 쓰인다.
// .nextAll() : 선택된 요소 바로 다음에 위치한 형제 요소를 모두 선택한다.
// .nextUntil() : 선택된 요소 바로 다음에 위치한 형제 요소 중에서 지정한 선택자에 해당되는 요소 
//                바로 이전까지의 요소를 모두 선택한다.

// .prev() : 선택된 요소 바로 이전에 위치한 형제 요소 1개를 선택한다.
// .prevAll() : 선택된 요소 바로 이전에 위치한 형제 요소를 모두 선택한다.
// .prevUntil() : 선택된 요소 바로 이전에 위치한 형제 요소 중에서 지정한 선택자에 해당되는 요소 
//                바로 다음까지의 요소를 모두 선택한다.
});























































