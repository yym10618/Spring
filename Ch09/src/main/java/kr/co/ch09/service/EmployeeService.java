package kr.co.ch09.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch09.dao.EmployeeDao;
import kr.co.ch09.vo.EmployeeVo;

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
		return dao.selectEmployees();
	}
	public void updateEmployee(EmployeeVo vo) {
		dao.updateEmployee(vo);
	}
	public void deleteEmployee(String uid) {
		dao.deleteEmployee(uid);
	}
}
