package kr.co.kmarket.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.admin.dao.AdminProductDao;

@Service
public class AdminProductService {

	@Autowired
	private AdminProductDao dao;
}
