function creatImg() {
	// 라디오 버튼의 value 속성값을 얻어와서 브라우저에 표시할 이미지의 경로와 이름으로 사용한다.
	let radios = document.getElementsByName('radioBtn');
	let radioValue = '';
	for (let radio of radios){
		if(radio.checked){
			radioValue = radio.value;
		}
	}
	// img 태그를 만들고 src 속성값을 radioValue에 저장된 값으로 지정하면 된다.
	let img = document.createElement('img'); // <img> 생성
	img.setAttribute('src', radioValue); //  <img src="./images/img0?.jpg">
	
	// 라디오 버튼을 선택하고 이미지 생성 버튼을 클릭할 때 마다 이미지가 변경되게 하려면
	// 기존에 표시되던 img 태그를 제거하고 다시 만든 img 태그를 넣어주면 된다.
	// div 태그 내부의 마지막 태그를 선택해서 제거한다.
	
	
	// img 태그를 넣어줄 div 태그를 얻어온다.
	let div = document.getElemntById('imgWiew');
	
	// div 태그에 img 태그를 자식으로 넣어준다.
	div.appendChild(img);
}



















































