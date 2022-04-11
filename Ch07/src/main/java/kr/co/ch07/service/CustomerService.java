package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.persistence.CustomerRepo;
import kr.co.ch07.vo.CustomerVo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo repo;
	
	public void insertCustomer(CustomerVo vo) {
		repo.save(vo);
	}
	public CustomerVo selectCustomer(String custid) {
		return repo.findById(custid).get();
	}
	public List<CustomerVo> selectCustomers() {
		return repo.findAll();
	}
	public void updateCustomer(CustomerVo vo) {
		repo.save(vo);
	}
	public void deleteCustomer(String custid) {
		repo.deleteById(custid);
	}
}
