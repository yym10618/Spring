/**
 * 
 */
 $(function(){
    		
    		function aggregation(){
		    	////////////////////////////
		    	// 장바구니 전체합계
				////////////////////////////   
				let total = $('.cart > form > .total');
		    	let trs = $('input[name=productChk]:checked').parent().parent();
				
				// 상품 수 합계
				let counts = trs.find('.count');
				let totCount = 0;
				
				$.each(counts, function(){
					
					let count = parseInt($(this).text());
					totCount += count;
				});
				console.log('totCount : '+totCount);
				total.find('.count').text(totCount+' 개');
		    	
				// 상품금액 합계
				let prices = trs.find('.price');
				let totPrice = 0;
				
				$.each(prices, function(){
					let count = parseInt($(this).prev().text().replace(/,/g, '')); 
					let price = parseInt($(this).text().replace(/,/g, ''));
					totPrice += (price * count);
				});
				console.log('totPrice : '+totPrice);
				total.find('.price').text(totPrice.toLocaleString()+' 원');
		    	
				// 할인금액 합계
				let discounts = trs.find('.discount');
				let totDiscount = 0;
				
				$.each(discounts, function(){
					
					let price = parseInt($(this).prev().text().replace(/,/g, ''));
					let discount = parseInt($(this).text().replace(/%/g, ''));
					totDiscount += (price * discount / 100);
				});
				console.log('totDiscount : '+totDiscount);
				total.find('.discount').text(totDiscount.toLocaleString()+' 원');
		    	
				// 배송비 합계
				let deliveries = trs.find('.delivery');
				let totDelivery = 0;
				
				$.each(deliveries, function(){
					let delivery = $(this).text().replace(/,/g, '');
					
					if(delivery != '무료배송'){
						totDelivery += parseInt(delivery);	
					}			
				});
				
				//console.log('totPrice : '+totPrice);
				total.find('.delivery').text(totDelivery.toLocaleString()+'원');
		    	
				// 포인트 합계
		    	let points = trs.find('.point');
				let totPoint = 0;
				
				$.each(points, function(){
					
					let point = parseInt($(this).text().replace(/,/g, ''));
					
					totPoint += point;
					
				});
				console.log('totPoint : '+totPoint);
				total.find('.point').text(totPoint.toLocaleString()+' 점');
				
				// 전체주문금액
				let totals = trs.find('.total');
				let totTotal = 0;
				
				$.each(totals, function(){
					
					let total = parseInt($(this).text().replace(/,/g, ''));
					
					totTotal += total;
					
				});
				console.log('totTotal : '+totTotal);
				total.find('.total').text(totTotal.toLocaleString()+' 원');
    		} // aggregation end
    		
    		// 집계실행
    		aggregation();
    		
			////////////////////////////
	    	// 장바구니 체크박스 전체선택/해제
			////////////////////////////
			let checkAll = $('input[name=all]');
			checkAll.change(function(){
				let isChecked = $(this).is(':checked');
				
				if(isChecked){
					// 체크 됨 --> 전체상품 선택실행
					$('input[name=productChk]').prop('checked', true);
				}else{
					// 체크 안됨 --> 전체상품 선택해제
					$('input[name=productChk]').prop('checked', false);
				}
				// 집계실행
				aggregation();
			});
			
			////////////////////////////
	    	// 장바구니 체크박스 개별선택/해제
			////////////////////////////
			let checkProducts = $('input[name=productChk]');
			checkProducts.change(function(){
				// 집계실행
				aggregation();
			});
			
			////////////////////////////////////
			// 장바구니 삭제
			////////////////////////////////////
			$('input[name=del]').click(function(){
				
				let productChk = $('input[name=productChk]:checked');
				let cids = [];
				
				if(productChk.length == 0){
					alert('삭제하려는 상품을 선택하세요.');
					return;
				}
				
				$.each(productChk, function(){
					cids.push($(this).val());
				});
				
				console.log(cids);
				let jsonData = {"cids": cids};
				
				$.ajax({
					url:'/product/cartDelete',
					type:'get',
					traditional: true,  /* 배열을 전송을 위한 옵션 */
					data: jsonData,
					dataType:'json',
					success: function(data){
						//alert(data.result);
						location.href='/product/cart';						
					}
				});
				
			});
			
			////////////////////////////////////
			// 주문하기 클릭
			////////////////////////////////////
			$('input[name=order]').click(function(e){ 
				e.preventDefault(); //폼 전송 차단
				
				let productChk = $('input[name=productChk]:checked');
				let cids = [];
				let pids = [];
				let counts = [];
				
				if(productChk.length == 0){
					alert('주문할려는 상품을 선택하세요.');
					return;
				}
				
				$.each(productChk, function(){
					cids.push($(this).val());
					pids.push($(this).data('pid'));
					counts.push($(this).data('count'));
				});
				
				console.log(cids);
				
				let uid      = $('.total input[name=uid]').val();
				let count    = $('.total .count').text().replace(/(,|개)/g, '');
				let price    = $('.total .price').text().replace(/(,|원)/g, '');
				let discount = $('.total .discount').text().replace(/(,|원)/g, '');
				let delivery = $('.total .delivery').text().replace(/(,|원)/g, '');
				let point    = $('.total .point').text().replace(/(,|점)/g, '');
				let total    = $('.total .total').text().replace(/(,|원)/g, '');
				
				let jsonData = {
					"uid": uid,
					"count": count,
					"price": price,
					"discount": discount,
					"delivery": delivery,
					"point": point,
					"total": total,
					"cids": cids,
					"pids": pids,
					"counts": counts
				};
					
				console.log(JSON.stringify(jsonData));
				
				$.ajax({
					url:'/product/order',
					type: 'post',
					traditional: true,
					data: jsonData,
					dataType: 'json',
					success: function(data){
						//주문페이지 이동
						location.href='/product/order';
					}
				});
			});		
    	});