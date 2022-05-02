package kr.co.kmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.ProductDao;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;
}
