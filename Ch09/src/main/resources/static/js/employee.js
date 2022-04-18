/**
 * 
 */
$(function(){
	// Employee
	$('.employee_list').click(function(){
		
		$.ajax({
			url: '/employee',
			type: 'GET',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
	});
	
	$('.employee_register').click(function(){
		
		let jsonData = {
			"uid": "rest1",
			"name": "신사임당",
			"gender": 2,
			"hp": "010-4545-8787",
			"email": "ssid@naver.com",
			"pos": "차장",
			"dep": 102
		};
		
		$.ajax({
			url: '/employee',
			type: 'POST',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
	})
	
	$('.employee_modify').click(function(){
		
		let jsonData = {
			"name": "황진이",
			"hp": "010-4545-7878",
			"pos": "부장",
			"dpe": 103
		};
		
		$.ajax({
			url: '/employee/rest1',
			type: 'PUT',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
	});
	
	$('.employee_delete').click(function(){
		
		$.ajax({
			url:'/employee/rest1',
			type: 'DELETE',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
	});
	
});