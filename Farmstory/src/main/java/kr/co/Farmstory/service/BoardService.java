package kr.co.Farmstory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.Farmstory.dao.BoardDao;
import kr.co.Farmstory.vo.ArticleVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao dao;
	
	public void insertArticle(ArticleVo vo) {
		
	}
	public ArticleVo selectArticle(int no) {
		return null;
	}
	public List<ArticleVo> selectArticles(){
		return null;
	}
	public void updateArticle(ArticleVo vo) {
		
	}
	public void deleteArticle(int no) {
		
	}
}
