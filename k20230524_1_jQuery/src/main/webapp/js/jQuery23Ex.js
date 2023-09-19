$(()=>{
	
	$('#emp_search'),click(function () {
		let empid = $('input[name=empid]').val();
		if(!isNaN(empid) && empid.lnegth == 3){
			
			$.ajax({
				url: 'emplist.xml',
				method: 'get',
				async: true,
				dataType: 'xml',
				success: data => {
					
					let empInfo = $(data).find(`EMPLOYEE_ID:contains(${empid})`).parent();
					if ($(empInfo).is('ROW')){
						
						// body 태그 내부에 테이블을 만들고 xml 파일에서 읽어온 데이터를 
						// 넣어주는 함수를 실행한다.
						$('body').append(makeTable(empInfo).append('<br/>'))
						
					}else{
						alert(empid + '번은 존재하지 않는 사원 번호입니다.');
						$('input:text[name=empid]').val('');
						$('input:text[name=empid]').focus();
					}
				},
				error: e => alert('요청 실패: ' + e.status)
			});
			
		}else{
			alert('정확한 사원 번호를 입력하세요.');
			$('input:text[name=empid]').val('');
			$('input:text[name=empid]').focus();
		}
	});
});

// 테이블을 만들고 xml 파일에서 언어온 데이터를 테이블에 넣어서 리턴하는 함수
function makeTable(empInfo) {
	
	// 테이블을 만든다.
	let $table = $('<table border="1">'); // <table border="1"> ~ </table>
	
	// 테이블에 추가할 첫 행(머리글 행)을 만들어 테이블에 추가한다.
	/*
	let $tr= $('<tr>'); // <tr> ~ </tr>
	// xml 파일에서 읽어온 사원 번호에 해당되는 데이터(자식 요소)의 개수만큼 반복하며
	// 행에 열을 추가한다.
	for(let i=0;i<empInfo.children().length;i++){
		// 행에 추가할 열을 만든다.
		// console.log(empInfo.children().eq(i).prop('tagName'))
		let $th = $('<th>').append(empInfo.children().eq(i).prop('tagName'));
		// 행에 열을 추가한다.
		$tr.append($th);
	}
	$table.append($tr);
	*/
	
	let html = `
		<tr>
			<th>사원번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>내선번호</th>
			<th>입사일</th>
		</tr>
	`;
	$table.append(html);
	
	// 테이블에 추가할 나머지 행들을 만들어 테이블에 추가한다.
	let $tr = $('<tr>')
	for (let i=0; i<empInfo.children().length;i++){
		let $td = $('<td>').append(empInfo.children().eq(i).text());
		$tr.append($td);
	}
	$table.append($tr);
	// 테이블을 리턴시킨다.
	return $table;
}


























































