// 배열에 저장된 모든 데이터의 합계
const numbers = [1,2,3,4,5];

let sum = 0;
for (let i=0; i<numbers.length;i++){
	sum += numbers[i];
}
console.log(sum);

sum = 0;
for (let number of numbers){
	sum += number;
}
console.log(sum);

sum = 0;
for (let i in numbers){
	sum += numbers[i];
}
console.log(sum);

