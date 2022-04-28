/**
 * 
 */
$(function(){
			// 댓글 목록 불러오기
			let no = [[${article.no}]];
			$.ajax({
				url: '/Farmstory/board/comment/'+no,
				type: 'GET',
				dataType: 'json',
				success: function(data){
					console.log(data);
				}
				
			});
			
			
			// 댓글등록버튼
			// 클릭 이벤트
			$('input[type=submit]').click(function(){
				
				// json 데이터 생성
				let parent  = $('.commentForm input[name=parent]').val();
				let uid     = $('.commentForm input[name=uid]').val();
				let content = $('.commentForm textarea[name=content]').val();
				
				let jsonData = {
						"parent":parent,
						"uid":uid,
						"content":content
				};
				
				$.ajax({
					url: '/Farmstory/board/comment/',
					type: 'POST',
					data: jsonData,
					dataType: 'json',
					success:function(data){
						alert(data);
					}
					
				});
				// 폼전송 차단
				return false;
			});
			
		});