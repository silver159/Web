function strTest1() {
	let str1 = 'string ';
	let str2 = 'function'
	let str3 = str1 + str2;
	console.log(str3);; 
	
	// concat(): 함수를 실행한 문자열에 인수로 지정한 문자열을 합친다.
	let newStr = str1.concat(str2);
	console.log(newStr); 
	
	// join(): 함수를 실행한 배열 요소에 인수로 지정한 문자열을 사이사이에 삽입한다.
	let joinStr = ['java', 'script', 'good'].join('\t');
	console.log(joinStr);
}

function strTest2() {
	let num = 12.34;
	let bool = true;
	let str = '문자열';
	
	// 연산자 우선순위에 의해 num + bool를 먼저 연산한다.
	// boolean 타입의 데이터는 숫자와 연산할 때 true는 1, false는 0으로 취급되어 연산된다.
	console.log(num + bool + str); // 13.34문자열
	
	// boolean 타인의 데이터는 문자열과 연산하면 true, false가 문자열로 연산된다.
	console.log(num + str + bool); // 12.34문자열true
}

function strTest3() {
	let str = prompt('니 이름이 뭐니?', '숫자는 입력하지 마세요');	
	console.log(typeof str); // string
	
	// isNaN(): 인수로 지정된 값이 숫자가 아니면 true, 숫자면 false를 리턴한다.
	// console.log(isNaN(str));
	// console.log('aaa' + isNaN(str));
	
	if (!isNaN(str)){
		alert('숫자는 입력하지 말라니까는~~~~');
	}else if (str == '홍길동'){
		alert(str+'님 어서오세요~~~~')
	}else{
		alert(str+'누구냐 넌??')
	}
	console.log('==================================');
	
	// '==', '!='는 데이터 타입은 비교하지 않고 데이터만 비교한다. '1'과 1을 같은 값으로 
	// 취급한다.
	
	// '===', '!=='는 데이터 타입과 데이터를 모두 비교한다. '1'과 1을 다른 값으로 취급한다.
	
	let num = 10;
	console.log(typeof num);
	str = '10';
	console.log(typeof str);
	
	if (num == str){
		console.log('데이터 타입은 비교하지 않고 데이터만 비교하므로 같다');
	}else{
		console.log('데이터 타입은 비교하지 않고 데이터만 비교하므로 다르다');
	}
	
	if (num === str){
		console.log('데이터 타입과 데이터를 모두 비교하므로 같다');
	}else{
		console.log('데이터 타입과 데이터를 모두 비교하므로 다르다');
	}
	console.log('==================================');
	
	let oldName = '홍길동';
	console.log(typeof oldName);
	let newName = new String('홍길동');
	console.log(typeof newName);
	
	console.log(oldName == newName ? '같다' : '다르다');
	console.log(oldName === newName ? '같다' : '다르다');
}

function strTest4() {
	// indexOf(): 문자열의 왼(앞)쪽부터 인수로 지정한 문자열을 찾아 index를 리턴한다.
	// lastIndexOf(): 문자열의 오른(뒤)쪽부터 인수로 지정한 문자열을 찾아 index를 리턴한다.
	// indexOf(), lastIndexOf() 모두 인수로 지정한 문자열이 없으면 -1을 리턴한다. 대소문자 인식
	let name = '홍길동 임꺽정 장길산 일지매 홍길동';
	let str = prompt('검색할 이름을 입력하세요')
	if (name.indexOf(str) == -1){
		console.log(str + '이라는 이름은 존재하지 않는 이름입니다.');
	}else{
		console.log('indexOf() 함수로 검색한 index: '+ name.indexOf(str));
		console.log('lastIndex() 함수로 검색한 index: '+ name.lastIndexOf(str));
	}
}

function strTest5() {
	// substring(a): 문자열에서 index가 a인 문자부터 끝까지 추출한다.
	// substring(a,b): 문자열에서 index가 a인 문자부터 b - 1번째 문자까지 추출한다 
	let today = '2023-05-22 (월) 2023-04-03';
	let sola = today.substring(0, today.indexOf('(')).trim();
	let lunar = today.substring(today.indexOf(')')+1).trim();
	console.log('양력 ' + sola + '는 음력으로 '+lunar+'입니다.');
	console.log(`양력 ${sola}는 음력으로 ${lunar}입니다.`);
}

function strTest6() {
	// split(): 인수로 지정한 구분자를 경계로 문자열을 나눠서 배열로 리턴한다.
	let today = '2023-05-22 (월) 2023-04-03';
	let array = today.split(' ');
	console.log(array);
	console.log('양력 ' + array[0] + '는 음력으로 '+array[2]+'입니다.');
	console.log(`양력 ${array[0]}는 음력으로 ${array[2]}입니다.`);
}
































