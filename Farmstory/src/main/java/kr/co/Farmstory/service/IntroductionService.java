package kr.co.Farmstory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.Farmstory.dao.IntroductionDao;

@Service
public class IntroductionService {

	@Autowired
	private IntroductionDao dao;
}
