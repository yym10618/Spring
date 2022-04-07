package kr.co.ch06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch06.persistence.CustomerDao;
import kr.co.ch06.vo.CustomerVo;

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
		List<CustomerVo> customers = dao.selectCustomers();
		return customers;
	}
	public void updateCustomer(CustomerVo vo) {
		dao.updateCustomer(vo);
	}
	public void deleteCustomer(String custid) {
		dao.deleteCustomer(custid);
	}
}
