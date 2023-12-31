// jsonplaceholder 검색
// https://jsonplaceholder.typicode.com/ 사이트 아래쪽으로 이동해서 Resources => /posts 클릭
// https://jsonplaceholder.typicode.com/posts

// javascript fetch api 검색
// https://developer.mozilla.org/ko/docs/Web/API/Fetch_API/Using_Fetch

// fetch()의 결과(리턴)는 promise 이다.

/*
console.log(1);
// fetch(요청 url)
fetch('https://jsonplaceholder.typicode.com/posts')
	.then(function (response) { // then()을 사용한다는 것은 fetch() 실행 후 리턴이 promise라는 의미
		// console.log(response)
		// console.log(response.json()) // json 타입의 데이터를 javascript 객체로 변환한다.
		return response.json();
	})
	.then(function (data) {
		console.log(data);
	})
console.log(2);
*/
console.log(1);
// fetch(요청 url)
fetch('https://jsonplaceholder.typicode.com/posts')
	.then(response => response.json())
	.then(console.log)
console.log(2);

//==============================================================================================

// fetch(요청 url) 함수의 리턴값은 promise이며 response(응답) 객체이다.
let fetcjed = fetch('https://jsonplaceholder.typicode.com/posts');
// 리턴값이 promise면 비동기적으로 실행되는 함수이다.
console.log('2. fetcjed: ' + fetcjed); // fetcjed: [object Promise] => 전체 문자열
console.log('2. fetcjed: ', fetcjed); // fetcjed: ▶Promise {<pending>} => 문자열, 객체

// fetch() 함수가 리턴한 리턴값에는 then()과 catch() 2개의 함수를 사용할 수 있다.
// then() 함수는 fetch() 함수가 성공적으로 실행되면 호출되고 catch() 함수는 fatch() 함수가
// 정상적으로 실행되지 않으면 호출된다.
// fetch() 함수가 실행되면 promise가 리턴되고 then() 함수도 실행되면 promise를 리턴한다.

fetcjed
	.then(response => {
		console.log('2. response: ', response); // response: ▶Response { ~ }
	});
fetcjed = fetch('https://jsonplaceholder1.typicode.com/posts'); // 주소 틀림
fetcjed
	.catch(e => {
		console.log('2. error: ', e); // error:  TypeError: Failed to fetch
	});

//==============================================================================================

fetch('https://jsonplaceholder.typicode.com/posts')
	.then(function (response) { 
		// console.log('3. response: ', response.json());// response: ▶Promise {<pending>}
		
		// then() 함수 내부에 또 then() 함수가 나오는 방식을 nested promise라 한다.
		// nested promise와 promise chaining 같이 못 쓴다.
		/*
		response.json().then(function (data){
			console.log('3. data: ', data)
		})
		*/
		// response.json().then(data => console.log('3. data 1: ', data));
		return response.json() // promise를 리턴한다.
	})
	.then(function (data) {
		// then() 함수에서 promise를 리턴시키고 외부에서 then() 함수로 받아서 사용하는 방식을
		// promise chaining이라 하고 일반적으로 nested promise 방식보다 더 많이 사용한다.
		console.log('3. data 2: ', data)
	})
	.catch(e => {
		console.log('3. error: ', e); // error:  TypeError: Failed to fetch
	});
























