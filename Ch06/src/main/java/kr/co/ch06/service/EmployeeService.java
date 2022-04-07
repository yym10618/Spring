package kr.co.ch06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch06.persistence.EmployeeDao;
import kr.co.ch06.vo.EmployeeVo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	public void insertEmployee(EmployeeVo vo) {
		dao.insertEmployee(vo);
	}
	public EmployeeVo selectEmployee(String uid) {
		return dao.selectEmployee(uid);
	}
	public List<EmployeeVo> selectEmployees() {
		List<EmployeeVo> employee = dao.selectEmployees();
		return employee;
	}
	public void updateEmployee(EmployeeVo vo) {
		dao.updateEmployee(vo);
	}
	public void deleteEmployee(String uid) {
		dao.deleteEmployee(uid);
	}
}
