function passwordCheck(obj) {
	
	const pw = obj.password.value.trim();
	// 정규 표현식(정규식)을 사용한 영문자, 숫자, 특수문자가 각각 1개이상 입력되었고 8자 이상
	// 12자 이하로 입력되었나 검사한다.
	
	// new RexExp('정규식 패턴') => 자바스크립트 정규식 객체를 만든다.
	// . => 모든 문자 1글자를 대신한다. => 어떤 문자라도 1글자가 나와야 한다.
	// * => 모든 문자 0글자 이상을 대신한다. => 아무 문자가 안나오도 되고 몇 개가 나와도 상관없다.
	// + => 모든 문자 1글자 이상을 대신한다. => 아무 문자나 1글자 이상 나와야 한다.
	// ^ => 시작하는
	// $ => 끝나는
	
	// 글자수 제한
	// const pattern = new RegExp('^.{8}$'); // 무조건 8자만 허용한다. {} 반복의 의미
	// const pattern = new RegExp('^.{1,8}$'); // 8자 이내만 허용한다. ',' 사이에 띄어쓰기 안된다.
	// const pattern = new RegExp('^.{8,}$'); // 8자 이상만 허용한다. ',' 사이에 띄어쓰기 안된다.
	// const pattern = new RegExp('^.{8,12}$'); // 8자 이상 12자 이하만 허용한다. ',' 사이에 띄어쓰기 안된다.
	
	// 숫자만 허용
	// [] => 허용 가능한 문자를 [] 안에 나열한다.
	// const pattern = new RegExp('^[0123456789]+$'); // '+'를 안쓰면 딱 1글자만 검사한다.
	// const pattern = new RegExp('^[0-9]+$'); // '-'를 사용하면 범위를 지정할 수 있다.
	
	// 숫자 4글자만 허용한다. => {}rk tkdydehlaus '+', '*'을 사용할 수 없다.
	// const pattern = new RegExp('^[0-9]{4}$');
	
	// 영문자만 허용
	// const pattern = new RegExp('^[A-Z]+$'); // 대문자만 허용한다. 
	// const pattern = new RegExp('^[a-z]+$'); // 소문자만 허용한다. 
	// const pattern = new RegExp('^[a-zA-Z]+$'); // 영문자만 허용한다. 
	// const pattern = new RegExp('^[A-Za-z]+$'); // 영문자만 허용한다.
	
	// 한글만 허용
	// const pattern = new RegExp('^[ㄱ-힣]+$');
	
	// 지정한 특수문자만 허용
	// const pattern = new RegExp('^[!@#$%^&]+$');
	
	// 긍정형 전방 탐색 기능으로 특정 문자가 포함되었나 검사한다. => (?=.*)
	// const pattern = new RegExp('?=.*[0-9]+'); // 숫자가 포함되어있나 검사한다.
	// const pattern = new RegExp('?=.*[A-Z]+'); // 대문자가 포함되어있나 검사한다.
	// const pattern = new RegExp('?=.*[a-z]+'); // 소문자가 포함되어있나 검사한다.
	// const pattern = new RegExp('?=.*[a-zA-Z]+'); // 영문자가 포함되어있나 검사한다.
	// const pattern = new RegExp('?=.*[ㄱ-힣]+'); // 한글이 포함되어있나 검사한다.
	// const pattern = new RegExp('?=.*[!@#$%^&]+'); // 특수문자가 포함되어있나 검사한다.
	
	
	// [0-9]는 \d]로 대체 가능
	// const pattern = new RegExp('^(?=.*[0-9]+)(?=.*[a-zA-Z]+)(?=.*[!@#$%^&]+)[A-Za-z0-9!@#$%^&]{8,12}$');
	const pattern = new RegExp('^(?=.*[0-9]+)(?=.*[a-zA-Z]+)(?=.*[!@#$%^&]+)[A-Za-z0-9!@#$%^&]{8,12}$');
	
	// test() 함수는 인수로 지정된 문자열이 정규식 패턴에 만족하나 검사해서 만족하면 true,
	// 만족하지 않으면 false를 리턴한다.
	if(!pattern.test(pw)){
		alert('비밀번호는 영문자, 숫자, 특수문자를 각각 1글자 이상 포함해야 합니다');
		obj.password.value = '';
		obj.repassword.value = '';
		obj.password.focus();
		return false;
	}
	
	// 입력한 두 개의 비밀번호가 같은지 검사한다.
	if(obj.password.value.trim() != obj.repassword.value.trim()){
		alert('비밀번호가 일치하지 않습니다');
		obj.password.value = '';
		obj.repassword.value = '';
		obj.password.focus();
		return false;
	}else{
		alert('비밀번호가 일치합니다');
	}
	return true;
}










































