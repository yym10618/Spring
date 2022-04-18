package kr.co.ch09.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.ch09.vo.EmployeeVo;

@Mapper
@Repository
public interface EmployeeDao {

	public void insertEmployee(EmployeeVo vo);
	public EmployeeVo selectEmployee(String uid);
	public List<EmployeeVo> selectEmployees();
	public void updateEmployee(EmployeeVo vo);
	public void deleteEmployee(String uid);
}
