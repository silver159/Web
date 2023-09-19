$(() => {
	
	// $('div > p > b').css({'fontSize':'30px','color':'purple'});
	$('div').find('p').find('b').css({'fontSize':'30px','color':'purple'});
	
	// $('#chd').text('야무치');
	// children() 함수의 인수를 생략하면 모든 자식 요소가 선택된다.
	// $('div').children().html('<i>베지터</i>');
	$('div').children('#chd').html('<i>베지터</i>');
	
	$('span').css('fontSize', '20px').css('backgroundColor', 'tomato');
	$('span').parent().css('backgroundColor', 'skyblue');
	
	// parent() 함수의 인수를 생략하면 모든 조상 요소가 선택된다. body까지 다 포함
	// $('span').parents().css('backgroundColor', 'dodgerblue');
	$('span').parents('div').css('backgroundColor', 'dodgerblue');
	
	$('p:eq(2)').next().css('backgroundColor', 'lime');
	$('p:eq(2)').prev().css('backgroundColor', 'yellow');
});



























































