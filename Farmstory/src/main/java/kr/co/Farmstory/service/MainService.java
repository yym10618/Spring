package kr.co.Farmstory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.Farmstory.dao.MainDao;

@Service
public class MainService {

	@Autowired
	private MainDao dao;
}
