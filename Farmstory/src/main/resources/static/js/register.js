/**
 * 
 */
// 데이터 형식을 검사하기 위한 정규표현식(Regular Expression)
let reUid  = /^[a-z]+[a-z0-9]{3,9}$/;
let rePass = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{5,}$/;
let reName = /^[가-힣]{2,10}$/;
let reNick = /^[a-z가-힣0-9]{2,5}$/;

// 최종 유효성 검사에 사용될 상태변수
let isUidOk   = false;
let isPassOk  = false;
let isNameOk  = false;
let isNickOk  = false;
let isEmailOk = false;
let isHpOk    = false;
 
 $(function(){
    		
	$('input[name=uid]').keyup(function(){
		
		let value = $(this).val();
		let jsonData = {"uid":value}
		
		if(value.length < 4){
			$('.resultId').css('color', 'red').text('아이디는 최소 4자 이상이어야합니다.');
			return false;
		}
		
		
		$.ajax({
			url: '/Farmstory/user/checkUid',
			type: 'GET',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				
				console.log(data);
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
	
	$('input[name=pass], input[name=pass2]').keyup(function(){

		let pw1 = $('input[name=pass]').val(); 
		let pw2 = $('input[name=pass2]').val(); 
		
		if(pw1.length < 4){
			$('.resultPass').css('color', 'red').text('영문, 숫자, 특수문자 포함 최소 4자이상이어야합니다.');
		}
		
		if(rePass.test(pw1)){
			$('.resultPass').css('color', 'green').text('사용가능한 비밀번호입니다.');
			isPassOk = true;
			if(pw1 == pw2){
				$('.resultPass2').css('color', 'green').text('비밀번호가 일치 합니다.');
				isPassOk = true;
			}else if(pw2.legnth = 0){
				$('.resultPass2').text(' ');
			}else{	
				$('.resultPass2').css('color', 'red').text('비밀번호가 일치하지 않습니다.');
			 	isPassOk = false;
			}
		}else{
			$('.resultPass').css('color', 'red').text('영문, 숫자, 특수문자 포함 최소 4자이상이어야합니다.');
			isPassOk = false;
		}
	});
	
	$('input[name=name]').keyup(function(){

		let name = $(this).val();
		
		if(reName.test(name)){
			$('.resultName').text('');
			isNameOk = true;
		}else{
			$('.resultName').css('color', 'red').text('이름은 한글로 2자 이상이어야 합니다.');
			isNameOk = false;
		}
	});
	
	$('input[name=nick]').keyup(function(){
		
		let value = $(this).val();
		let jsonData = {"nick":value}
		
		if(value.length < 2){
			$('.resultNick').css('color', 'red').text('닉네임은 최소 2자 이상이어야합니다.');
			return false;
		}
		
		$.ajax({
			url: '/Farmstory/user/checkNick',
			type: 'GET',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				
				console.log(data);
				if(data.result > 0){
					$('.resultNick').css('color', 'red').text('이미 사용중인 닉네임 입니다.');
					isNickOk  = false;
				}else{
					$('.resultNick').css('color', 'green').text('사용 가능한 닉네임 입니다.');
					isNickOk  = true;
				}
				
			}
		});
	});
	
	$('input[name=email]').keyup(function(){
		
		let value = $(this).val();
		let jsonData = {"email":value}
		
		if(value.length < 2){
			return false;
		}
		
		$.ajax({
			url: '/Farmstory/user/checkEmail',
			type: 'GET',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				
				console.log(data);
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
	
	$('input[name=hp]').keyup(function(){
		
		let value = $(this).val();
		let jsonData = {"hp":value}
		
		if(value.length < 13){
			$('.resultHp').text('');
			return false;
		}
		
		$.ajax({
			url: '/Farmstory/user/checkHp',
			type: 'GET',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				
				console.log(data);
				if(data.result > 0){
					$('.resultHp').css('color', 'red').text('이미 사용중인 전화번호 입니다.');
					isHpOk    = false;
				}else{
					$('.resultHp').css('color', 'green').text('사용 가능한 전화번호 입니다.');
					isHpOk    = true;
				}
				
			}
		});
	});
	
	
	
});
	
$(function(){
	$('.register > form').submit(function(){
		// form 전송할때 실행되는 이벤트
		
		if(!isUidOk){
			alert('아이디를 확인하세요.');
			return false;
		}
		
		if(!isPassOk){
			alert('비밀번호를 확인하세요.');
			return false;
		}
		
		if(!isNameOk){
			alert('이름은 한글 최소 2자 이어야 합니다.');
			return false;
		}
		
		if(!isNickOk){
			alert('별명을 다시 확인하시기 바랍니다.');
			return false;
		}
		
		if(!isEmailOk){
			alert('이메일을 다시 확인하시기 바랍니다.');
			return false;
		}
		
		if(!isHpOk){
			alert('휴대폰을 다시 확인하시기 바랍니다.');
			return false;
		}
		
		return true; // 최종 폼 전송
	});
	
});