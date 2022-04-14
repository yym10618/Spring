package kr.co.ch09.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.ch09.vo.CustomerVo;

@Mapper
@Repository
public interface CustomerDao {

	public void insertCustomer(CustomerVo vo);
	public CustomerVo selectCustomer(String custid);
	public List<CustomerVo> selectCustomers();
	public void updateCustomer(CustomerVo vo);
	public void deleteCustomer(String custid);
}
