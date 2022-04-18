/**
 * 
 */
// Context 경로
let ctxRoot = '/Sboard1';

// keyup 이벤트
$(function(){
	
	$('input[name=uid]').keyup(function(){
		let value = $(this).val();
		let jsonData = {"uid":value}
		
		if(value.length < 4){
			return false;
		}
		
		$.ajax({
			url: ctxRoot+'/user/checkUid',
			type: 'GET',
			data: jsonData,
			dataTyoe: 'json',
			success: function(data){
				console.log(data);
				
				// 아이디 중복체크
				if(data.result > 0){
					$('.resultId').css('color', 'red').text('이미 사용중인 아이디 입니다.');
					isUidOk = false;
				}else{
					$('.resultId').css('color', 'green').text('사용 가능한 아이디 입니다.');
					isUidOk = true;
				}
			}
		});
	});
	
	$('input[name=nick]').keyup(function(){
		let value = $(this).val();
		let jsonData = {"nick":value}
		
		if(value.length < 2){
			return false;
		}
		
		$.ajax({
			url: ctxRoot+'/user/checkNick',
			type: 'GET',
			data: jsonData,
			dataTyoe: 'json',
			success: function(data){
				console.log(data);
				
				// 닉네임 중복체크
				if(data.result > 0){
					$('.resultNick').css('color', 'red').text('이미 사용중인 닉네임 입니다.');
					isNickOk = false;
				}else{
					$('.resultNick').css('color', 'green').text('사용 가능한 닉네임 입니다.');
					isNickOk = true;
				}
			}
		});
	});
	
	$('input[name=email]').keyup(function(){
		let value = $(this).val();
		let jsonData = {"email":value}
		
		$.ajax({
			url: ctxRoot+'/user/checkEmail',
			type: 'GET',
			data: jsonData,
			dataTyoe: 'json',
			success: function(data){
				console.log(data);
				
				// 닉네임 중복체크
				if(data.result > 0){
					$('.resultEmail').css('color', 'red').text('이미 사용중인 이메일 입니다.');
					isEmailOk = false;
				}else{
					$('.resultEmail').css('color', 'green').text('사용 가능한 이메일 입니다.');
					isEmailOk = true;
				}
			}
		});
	});
});
    
 