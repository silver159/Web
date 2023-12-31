// 클래스 - class로 선언
class Food {
// 생성자: 객체가 생성될 때 멤버 변수를 선언하고 초기화 한다.
	constructor(name){
		this.name = name; // 멤버 변수 선언 및 초기화
		this.brands = [];
	}
// 멤버 함수 선언시 앞에 function을 붙이지 않는다.
	addBrands(brand) {
		this.brands.push(brand);
	}
	print() {
		console.log(`${this.name}을(를) 파는 음식점들 ${this.brands.join(', ')}`);
	}
}

// 클래스 객체 생성
const pizza = new Food('피자');
pizza.addBrands('도미노피자');
pizza.addBrands('피자스쿨');
pizza.addBrands('오구피자');
console.log(pizza);
pizza.print();

const chicken = new Food('치킨');
chicken.addBrands('KFC');
chicken.addBrands('BBQ');
chicken.addBrands('교촌');
chicken.addBrands('굽네치킨');
console.log(chicken);
chicken.print();
console.log('=====================================================');

// 상속
class Animal { // 부모 클래스
	constructor(type, name, sound){
		this.type = type;
		this.name = name;
		this.sound = sound;
	}
// 클래스에 멤버 함수를 정의하면 자바스크립트가 자동으로 prototype에 등록시킨다.
	say() {
		console.log(`부모 클래스의 say() 함수가 실행: ${this.sound}`);
	}	
}
// console.log(Animal.prototype.say);

const dog = new Animal('개','멍멍이','멍멍');
dog.say();
const cat = new Animal('고양이','야옹이','야옹');
cat.say();
console.log('=====================================================');

// 상속은 java와 같이 extends 예약어를 사용한다.
class Dog extends Animal {
	constructor(name, sound, age){
		super('개', name, sound); // 부모 클래스의 생성자를 호출해서 상속받은 멤버를 초기화시킨다.
		this.age = age;
	}
// 함수 오버라이드
	say() {
		console.log(`${this.age} 살 짜리 ${this.type}가 ${this.sound} 합니다.`);
	}	
}

const dog2 = new Dog('멍멍이', '멍멍', 30);
dog2.say();

class Cat extends Animal {
	constructor(name, sound, age){
		super('고양이', name, sound)
		this.age = age;
	}
	say() {
		console.log(`${this.age} 살 짜리 ${this.type}가 ${this.sound} 합니다.`);
	}
}

const cat2 = new Cat('야옹이', '야옹', 10);
cat2.say();








































