package kr.co.ch06.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ch06.vo.CustomerVo;


@Repository
public interface CustomerDao {

	public void insertCustomer(CustomerVo vo);
	public CustomerVo selectCustomer(String custid);
	public List<CustomerVo> selectCustomers();
	public void updateCustomer(CustomerVo vo);
	public void deleteCustomer(String custid);
}
