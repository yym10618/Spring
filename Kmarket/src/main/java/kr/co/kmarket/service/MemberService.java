package kr.co.kmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.MemberDao;

@Service
public class MemberService {

	@Autowired
	private MemberDao dao;
}
