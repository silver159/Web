// syntantic suger: 기존에 존재하는 것(promise) 위에 기존에 존재하는 것으로 감싸서 좀 더 편하게
// 사용할 수 있게 해주는 것을 말한다.

// "Syntactic sugar"는 프로그래밍 언어의 구문을 더 간결하고 읽기 쉽도록 만들어주는 구문적인 특징 또는 표기법을 의미합니다. 이는 실제로 언어의 기능을 변경하지 않고 단지 코드 작성을 더 편리하게 만들어줍니다.

// async와 await를 사용하면 promise를 보다 깔끔하게 사용할 수 있다.

// promise
function fetchUser() {
	// 작업 시간이 오래 걸리는 작업이 있다면 비동기적으로 처리를 할 수 있게 해야한다.
	// promise를 리턴하면 pending 상태로 리턴된다.
	return new Promise(function (resolve,reject){
		// return '홍길동'; // pending 상태로 리턴한다. promise 결과가 없는 것이다.
		// pending은 promise가 실행 안된 상태
		// promise 내부에서는 resolve() 또는 reject()를 실행해서 리턴시켜야 한다.
		// resolve('홍길동'); // fulfilled 상태로 리턴한다.
		reject('홍길동') // rejected 상태로 리턴한다.
	});
}

const user = fetchUser();
console.log('1. user: ', user); // 1. user:  Promise {<fulfilled>: '홍길동'}

user
	.then(function (response) {
		console.log('1. response: ', response);
	})
	.catch(function (e) {
		console.log('1. error: ', e);
	})

//=============================================================================================

// async
// 함수 앞에 async를 붙이면 함수 내부의 코드가 자동으로 promise로 변경된다.
// return을 사용한다. then()으로 받는다.

// eclipse 오류 async  이해 못한다.
async function fetchUser2() {
	return '홍길동';
	// resolve('홍길동'); // resolve, reject 사용 못한다. 따라서 catch() 못쓴다.
};

const user2 = fetchUser2();
console.log('2. user2: ', user2);

user2
	.then(function (response) {
		console.log('2. response: ', response);
	})
//=============================================================================================


// await
/*
function delay(ms){
	return new Promise(function (resolve,reject){
		setTimeout(function () {
			resolve();
		}, ms);
	});
}
*/
function delay(ms){
	return new Promise((resolve,reject) => setTimeout(()=>resolve(), ms));
}

// async를 붙여서 promise를 리턴하도록 설정한 getApple() 함수는 await에 의해서 delay() 함수가
// 끝나기를 기다렸다가 delay()가 종료되면 promise를 리턴한다.
async function getApple() {
	
	// await는 async가 붙은 함수에서만 사용할 수 있고 await를 붙여준 함수가 완전히 끝나기를
	// 기다렸다가 다음 작업을 실행한다.
	await delay(2000);
	return '사과'; // 비동기 방식이라 delay를 기다리지 않고 바로 출력된다.
}

const apple = getApple();
console.log('3. apple: ', apple); 
apple
	.then(response =>console.log('3. response: ', response))

async function getBanana() {
	await delay(1000);
	return '바나나'; 
}

const banana = getBanana();
console.log('3. banana: ', banana); 
banana
	.then(response =>console.log('3. response: ', response))

// promise도 지나치게 chaining을 하면 callback 지옥 현상이 나타난다.
/*
function pickFruits() {
	return getApple()
		.then(apple =>{
			console.log('3. pickFruits: ', apple)
			return getBanana()
				.then(banana =>{
					console.log('3. pickFruits: ', banana)
					return `${apple} + ${banana}`;
				})
		})
}
*/

// async와 await를 사용하면 동기적 프로그램을 작성하는 것처럼 비동기 프로그램을 작성할 수 있다.
// 순차적 처리
/*
async function pickFruits() {
	const apple = await getApple(); // 2초 대기
	const banana = await getBanana(); // 1초 대기
	return `${apple} + ${banana}`;
}
*/

// 병렬(동시) 처리 => 실행하는 promise가 서로 연관이 있을 때 
async function pickFruits() {
	
	// promise가 만들어지는 순간 executor 함수가 실행된다.
	// 병렬 처리할 함수가 동시에 실행된다.
	const applePromises = getApple();
	const bananaPromises = getBanana();
	// await를 이용해서 동시에 실행한 함수가 종료될 때까지 대기한다.
	const apple = await applePromises; // 2초 대기
	// getBanana()는 getApple()와 동시에 실행했기 때문에 getApple() 함수가 2초간 실행되는 
	// 도중에 종료된다.
	const banana = await bananaPromises; // 1초 대기
	return `${apple} + ${banana}`;
}

pickFruits().then(result => console.log('3. result: ', result))

// 병렬(동시) 처리 => 실행하는 promise가 서로 연관이 없을 때 
// promise가 서로 연관이 없을 경우 병렬 처리할 때 위와 같이 작성하지 않고 promise 객체의
// all() 함수 또는 race() 함수를 사용해서 작성할 수 있다. 

// all() => 전체 => 모든 promise 실행
function pickAllFruits() {
	// all() 함수의 인수로 병렬 처리 할 promise가 저장된 배열을 전달하면 배열로 전달한 모든
	// promise가 종료된 후 리턴 값(배열)이 then()으로 전달된다.
	return Promise.all([getApple(), getBanana()]) // 여기서 리턴하면 결과가 저장된 배열이 리턴된다.
		// 배열에 저장된 데이터를 가공한 후 리턴하려면 then() 함수에서 가공한 후 리턴한다.
		.then(fruits => fruits.join(' + '))
}
pickAllFruits().then(result =>console.log('4. result: ', result));

// race() => 경쟁 => 가장 먼저 종료되는 promise만 실행
function pickRaceFruits(){
	// race() 함수의 인수로 병렬 처리 할 promise가 저장된 배열을 전달하면 배열로 전달한 모든
	// promise 중에서 가장 먼저 종료된 promise의 리턴 값이 then()으로 전달된다.
	// => 나머지 promise는 무시된다.
	return Promise.race([getApple(), getBanana()])
}

pickRaceFruits().then(result =>console.log('5. result: ', result));













