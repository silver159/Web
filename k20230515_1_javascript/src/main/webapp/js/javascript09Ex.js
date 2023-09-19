// splice(): 배열에서 index 번째 위치부터 지정된 개수만큼 추출(뽐아낸다)해서 배열로 리턴한다.
// 배열명.splice(index, 개수) index부터 개수만큼 추출한다.

const numbers = [10, 20, 30, 40];
const spliced = numbers.splice(1,2); // 1번 index부터 2개를 추출한다.
console.log('spliced: '+spliced); // 20, 30
// splice()를 실행하면 원본 배열에서 추출되는 데이터가 제거된다.
console.log('numbers: '+numbers); // 10, 40
console.log('================================= splice()');

// slice(): 배열에서 a 번째 index위치부터 b-1 번째 index 위치까지 복사해서 배열로 리턴한다.
// 배열명.slice(a,b) =>

const numbers2 = [10, 20, 30, 40];
const sliced = numbers2.slice(1,2); // 1번 index 부터 2-1번째 index까지 복사한다. 
console.log('sliced: '+sliced); // 20
console.log('numbers2: '+numbers2); // 10, 20, 30, 40
console.log('================================= slice()');

// 배열에 데이터 추가, 제거 함수
// push(): 배열의 맨 뒤에 인수로 지정한 데이터를 추가한다. 스택, 데크
// unshift(): 배열의 맨 앞에 인수로 지정한 데이터를 추가한다. 큐, 데크 
// pop(): 배열의 맨 뒤에 데이터를 얻어온 후 제거한다. 스택, 데크
// shift(): 배열의 맨 앞에 데이터를 얻어온 후 제거한다. 큐, 데크

const numbers3 = [10, 20, 30, 40];
console.log(numbers3);

numbers3.push(999);
console.log(numbers3);

numbers3.unshift(777);
console.log(numbers3);

let popData = numbers3.pop();
console.log('popData: '+popData);
console.log(numbers3);

let shiftData = numbers3.shift();
console.log('shiftData: '+shiftData);
console.log(numbers3);
console.log('================================= push(), unshift(), pop(), shift()');

// concat(): 인수로 지정된 배열을 연결해서 새 배열을 만들어 리턴한다.
// 배열명.concat(배열명2[, 배열명3, ...])

const array = [1, 2, 3];
const array2 = [10, 20, 30];
const array3 = [100, 200, 300];

const concated = array.concat(array2, array3);
console.log(concated);
console.log('================================= concat()');

// join(): 배열 요소들 사이에 인수로 지정된 문자열을 삽입해서 문자열로 만들어 리턴한다.
// 배열명.join(['문자열'])

const array4 = ['홍길동','임꺽정','장길산','일지매'];
console.log(typeof array4.join());
console.log(array4.join()); // 인수를 지정하지 않으면 ','가 기본값으로 사용된다.
console.log(array4.join(' '));
console.log(array4.join('/'));
console.log(array4.join('~(^^!)'));
console.log(array4.join('	')); // 탭 (\t)
console.log(array4.join('\t')); // 탭 (\t)
console.log(array4.join('\n')); // 줄 바꾸기













