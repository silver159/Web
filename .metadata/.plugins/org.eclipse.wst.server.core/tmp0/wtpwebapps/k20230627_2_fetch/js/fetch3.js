function fetchAjax(pageName){
	fetch(pageName)
		.then(response => {
			if (response.status == 200){
				response.text()
					.then(text => document.getElementsByTagName('div')[0].innerHTML=text);
			}else{
				document.getElementsByTagName('div')[0].innerHTML= '요청 실패!!!'
			}
		});
}


























