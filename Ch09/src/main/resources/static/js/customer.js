/**
 * 
 */
$(function(){
	// Customer
	$('.customer_list').click(function(){
		
		$.ajax({
			url: '/customer',
			type: 'GET',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
	});
	
	$('.customer_register').click(function(){
		let jsonData = {
			"name": "홍길동",
			"address": "부산시 사하구",
			"phone": "222-222-2222"							
		};
		$.ajax({
			url: '/customer',
			type: 'POST',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
	});
	
	$('.customer_modify').click(function(){
		let jsonData = {						
			"name": "홍길동",
			"address": "부산시 연제구",							
			"phone": "010-1234-1234"
		};
		
		$.ajax({
			url: '/customer/rest1',
			type: 'PUT',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
		
	});
	
	
	$('.customer_delete').click(function(){
		$.ajax({
			url: '/customer/rest1',
			type: 'DELETE',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
	});
});