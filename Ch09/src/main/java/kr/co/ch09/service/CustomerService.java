package kr.co.ch09.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch09.dao.CustomerDao;
import kr.co.ch09.vo.CustomerVo;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;
	
	public void insertCustomer(CustomerVo vo) {
		dao.insertCustomer(vo);
	}
	public CustomerVo selectCustomer(String custid) {
		return dao.selectCustomer(custid);
	}
	public List<CustomerVo> selectCustomers() {
		return dao.selectCustomers();
	}
	public void updateCustomer(CustomerVo vo) {
		dao.updateCustomer(vo);
	}
	public void deleteCustomer(String custid) {
		dao.deleteCustomer(custid);
	}
}
