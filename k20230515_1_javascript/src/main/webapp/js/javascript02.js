// 변수(variable)
// 변수가 var, let, const으로 선언되지 않으면 에러를 발생 시킨다.
'use strict'; // ECMA Script5에서 추가

// 변수의 타입
// 기본(원시, primitive) 자료형
//		=> number(숫자), string(문자열), boolean(논리값), null, undefined, symbol(ES6)
// Object(객체), box container
// function(함수) => 함수도 변수에 할당이 가능하다.
// 			  => 함수의 인수로 함수를 전달할 수 있고 함수의 실행 결과로 함수를 리턴 할 수 있다.
//			  => 1급 함수 (java는 2급 함수)

// age = 19; // 'use strict'에 의해서 에러가 발생된다.
// var age = 19; // 변수 선언시 var를 사용했으므로 'use strict'에 의해서 에러가 발생되지 않는다.

console.log('age: ' + age); // undefined 출력, 밑에서 선언해서 값이 할당되지 않았다.

// var => ES5
// variable hoisting (호이스팅) 
// var를 사용해서 선언한 변수는 프로그램 어디에서 선언하든지 변수 선언만 항상 맨 위로 끌어올려진다.
// 변수를 선언만하고 값을 할당하지 않으면 undefined가 된다.
var age = 19; // 이제 할당된다. 선언은 맨 위에서 선언
console.log('age: ' + age); // 19
var age = '열살';// var는 같은 이름의 변수를 다시 선언할 수 있다.
console.log('age: ' + age); // 열살
console.log('==================================');

// var는 block scope를 사용하지 않고 function scope를 사용한다. => 유연성
// block scope: 변수가 선언된 {} 블록 내부에서만 사용할 수 있다. =>let, const, java 방식
// function scope: 변수가 선언된 함수에서만 사용할 수 있다. => var
// block scope는 변수가 선언된 {} 블록 밖으로 나가면 변수가 소멸되고 function scope는 변수가
// 선언된 함수가 종료되면 변수가 소멸된다. (java는 block scope) (javascript는 function scope)

// let => ES6
// block scope
let globalName = '장길산';
{
	let name = "홍길동";
	console.log('name: '+ name);
	// let name = '임꺽정'; // 에러, let은 같은 이름의 변수를 다시 선언할 수 없다.
	name ='임꺽정'; // 선언된 변수에 값을 할당할 수 있다. const는 할당할 수 없다.
	console.log('name: '+ name);
	console.log('name: '+ globalName);
}
console.log('name: '+ name); // 아무런 값도 출력되지 않는다.
console.log('name: '+ globalName);
console.log('==================================');

// 상수(constant)
// 선언시 값을 할당한 다음 값을 변경할 수 없는 데이터 타입 => 보안성
// const maxNumber; // 상수는 최초 선언시 값을 할당해야 하므로 에러가 발생된다.
const maxNumber = 100;// 상수는 최초 선언시 값을 반드시 할당해야 한다.
console.log('maxNumber: ' + maxNumber);
// maxNumber = 200; // 상수로 선언한 변수에 값을 할당하려 했으므로 에러가 발생된다.
console.log('==================================');

// template: `(그레이브)를 사용하고 출력할 데이터는 ${ ~ } 사이에 적는다.
// typeof 명령으로 변수의 자료형을 확인할 수 있다.
let count = 17.5;
const size = true;
console.log('value: ' + count +', type: ' + typeof count);
console.log(`value: ${count}, type: ${typeof count}`);
console.log(`value: ${size}, type: ${typeof size}`);
console.log('==================================');

// 자바스크립트는 나눗셈을 0으로 하면 결과가 Infinity가 된다.
const infinity = 1 / 0;
console.log(`value: ${infinity}, type: ${typeof infinity}`);
const negativeInfinity = -1 / 0;
console.log(`value: ${negativeInfinity}, type: ${typeof negativeInfinity}`);

// 자바스크립트는 문자열을 나누면 결과가 NaN이 된다.
const nan = 'Not A Number' / 2;
console.log(`value: ${nan}, type: ${typeof nan}`);
console.log('================================');

// 동적 자료형(dynamic typing): 변수에 저장되는 데이터의 타입에 맞춰 변수의 타입이 결정된다.
let text = 'hello';
console.log(`value: ${text}, type: ${typeof text}`);
text = 1;
console.log(`value: ${text}, type: ${typeof text}`);
console.log('==================================');

// symbol: 고유한 식별자를 만들 때 사용한다.
const symbol = Symbol('id');
console.log(symbol);
console.log(`type: ${typeof symbol}`);

const symbol2 = Symbol('id');
console.log(symbol2);
console.log(`type: ${typeof symbol2}`);
console.log(symbol == symbol2);
console.log('==================================');

// Object(객체)
const obj = {
	name: '홍길동', 
	age: 20
}
console.log(obj);
console.log(obj.name);
console.log(obj.age);
obj.age = 21;
console.log(obj);
console.log(obj.age);
console.log(typeof obj);