package kr.co.ch06.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ch06.vo.EmployeeVo;

@Repository
public interface EmployeeDao {
	
	public void insertEmployee(EmployeeVo vo);
	public EmployeeVo selectEmployee(String uid);
	public List<EmployeeVo> selectEmployees();
	public void updateEmployee(EmployeeVo vo);
	public void deleteEmployee(String uid);

}
