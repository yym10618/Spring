package kr.co.staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.staff.persistence.StaffDao;
import kr.co.staff.vo.StaffVo;

@Service
public class StaffService {

	@Autowired
	private StaffDao dao;
	
	public void insertStaff(StaffVo vo) {
		dao.insertStaff(vo);
	}
	
	public StaffVo selectStaff(String stf_no) {
		return dao.selectStaff(stf_no);
	}
	
	public List<StaffVo> selectStaffs() {
		List<StaffVo> staffs = dao.selectStaffs();
		return staffs;
	}
	public void updateStaff(StaffVo vo) {
		dao.updateStaff(vo);
	}
	public void deleteStaff(String stf_no) {
		dao.deleteStaff(stf_no);
	}
}


