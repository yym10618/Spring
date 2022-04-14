/**
 * 
 */
$(function(){
	// Student
	$('.student_list').click(function(){
		
		$.ajax({
			url: '/student',
			type: 'GET',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
	});
	
	$('.student_register').click(function(){
		let jsonData = {
			"sid": "rest1",
			"name": "홍길동",
			"gender": 1,
			"hp": "010-3390-3680"	,						
			"grade": 2							
		};
		$.ajax({
			url: '/student',
			type: 'POST',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
	});
	
	$('.student_modify').click(function(){
		let jsonData = {						
			"name": "홍길동",
			"hp": "010-1234-1234",
			"age": 38							
		};
		
		$.ajax({
			url: '/student/rest1',
			type: 'PUT',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
		
	});
	
	
	$('.student_delete').click(function(){
		$.ajax({
			url: '/student/rest1',
			type: 'DELETE',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
	});
});