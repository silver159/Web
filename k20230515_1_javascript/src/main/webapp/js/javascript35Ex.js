function elementCreate() {
	// element(요소)를 만들어 html 문서에 추가한다.
	// createElement('태그이름'): 인수로 지정한 태그를 만든다.
	let div = document.createElement('div'); // <div></div> 생성
	
	// setAttribute('속성이름','속성값'): 태그에 속성을 추가한다. 한번에
	div.setAttribute('style', 'border: 2px solid red;')
	
	div.innerHTML = '<marquee>div 태그 추가</marquee>';
	// appendChild('태그 또는 문자열'): 태그의 맨 뒤에 태그 또는 문자열을 추가한다.
	doument.body.appendchild(div);
}



















































