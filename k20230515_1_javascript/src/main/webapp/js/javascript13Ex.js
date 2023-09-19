// falsy: 무조건 거짓이 되는 값 => 0, '', null, undefined, NaN
// truthy: 무조건 참이 되는 값 => falsy를 제외한 값

// 단축 평가(short-circuit evaluation) 논리 계산법
// '&&' 논리 연산에서 앞의 조건이 truthy한 값이면 '&&' 뒤의 내용이 출력된다.
console.log(true && 'hello');
// '&&' 논리 연산에서 앞의 조건이 falsy한 값이면 falsy한 값이 출력된다.
console.log(false && 'hello');
console.log(undefined && 'hello');
console.log('=============================');

const dog = {
	name: '멍멍이'
};

function getName (animal) {
	console.log(animal);
	return animal && animal.name;
};

const name = getName(dog);
console.log(name);
const name2 = getName();
console.log(name2);
console.log('=============================');

// '||' 논리 연산에서 앞으 조건이 truthy한 값이면 '||' 앞의 내용이 출력된다.
console.log(true || 'hello');
console.log('abc' || 'hello');
// '||' 논리 연산에서 앞의 조건이 falsy한 값이면 '||' 뒤의 내용이 출력된다.
console.log(false || 'hello');
console.log('=============================');

















