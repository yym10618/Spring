package kr.co.kmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.ProductDao;
import kr.co.kmarket.vo.CartVo;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.OrderVo;
import kr.co.kmarket.vo.ProductVo;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;
	
	public ProductVo selectProduct(int pid) {
		return dao.selectProduct(pid);
	}
	
	public List<ProductVo> selectProducts(ProductVo vo){
		return dao.selectProducts(vo); 
	}
	
	public int selectCountTotal() {
		return dao.selectCountTotal();
	}
	
	public CategoriesVo selectCateTitles(ProductVo vo) {
		return dao.selectCateTitles(vo);
	}
	
	public int insertCart(CartVo vo) {
		return dao.insertCart(vo);
	}
	
	public List<CartVo> selectCarts(String uid){
		return dao.selectCarts(uid);
	}
	
	public int deleteCart(int[] cids) {
		return dao.deleteCart(cids);
	}
	
	public int insertOrder(OrderVo vo) {
		dao.insertOrder(vo);
		return vo.getOid();
	}
	
	public void insertOrderDetail(int oid, int pid, int count) {
		dao.insertOrderDetail(oid, pid, count);
	}
	
	
	// 페이지 작업
	public int getLastPageNum(int total){
		
		int lastPageNum = 0;
		
		if(total % 10 == 0) {
			lastPageNum = total / 10;
		}else {
			lastPageNum = total / 10 + 1;
		}
		
		return lastPageNum;
	}
	public int getCurrentPage(String pg) {
		
		int currentPage = 1;
		
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		
		return currentPage;
	}
	public int getLimitStart(int currentPage) {
		
		return (currentPage - 1) * 10;
	}
	public int getPageStartNum(int total, int starts) {
		return (total - starts);
	}
	public int[] getPageGroup(int currentPage, int lastPageNum) {
		int groupCurrent = (int)Math.ceil(currentPage/10.0);
		int groupStart = (groupCurrent - 1) * 10 + 1;
		int groupEnd = groupCurrent * 10;
		
		if(groupEnd > lastPageNum) {
			groupEnd = lastPageNum;
		}
		
		int[] groups = {groupStart, groupEnd};
		
		return groups;
	}
}