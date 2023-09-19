$(()=>{
	/*easeInOutBack*/
	$('.delete').click(function () {
		// $(this).parent().slideUp('slow');
		$(this).parent().slideUp(1000, 'easeInOutBack');
	})
	
	$('#view').click(function () {
		$('.pane').slideDown(1000, 'easeInOutBack')
	})
});


























































