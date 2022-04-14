/**
 * 
 */
$(function(){
	// Member
	$('.member_list').click(function(){
		
		$.ajax({
			url: '/member',
			type: 'GET',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
	});
	
	$('.member_register').click(function(){
		let jsonData = {
			"uid": "rest1",
			"name": "홍길동",
			"hp": "010-1234-1110",
			"pos": "사원",
			"dep": 103							
		};
		$.ajax({
			url: '/member',
			type: 'POST',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
	});
	
	$('.member_modify').click(function(){
		let jsonData = {						
			"name": "홍길동",
			"hp": "010-1234-1234",
			"pos": "대리",
			"dep": 101							
		};
		
		$.ajax({
			url: '/member/rest1',
			type: 'PUT',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
		
	});
	
	
	$('.member_delete').click(function(){
		$.ajax({
			url: '/member/rest1',
			type: 'DELETE',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
	});
});