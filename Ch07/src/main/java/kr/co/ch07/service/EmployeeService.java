package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.persistence.EmployeeRepo;
import kr.co.ch07.vo.EmployeeVo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;
	
	public void insertEmployee(EmployeeVo vo) {
		repo.save(vo);
	}
	public EmployeeVo selectEmployee(String uid) {
		return repo.findById(uid).get();
	}
	public List<EmployeeVo> selectEmployees() {
		return repo.findAll();
	}
	public void updateEmployee(EmployeeVo vo) {
		repo.save(vo);
	}
	public void deleteEmployee(String uid) {
		repo.deleteById(uid);
	}
}
