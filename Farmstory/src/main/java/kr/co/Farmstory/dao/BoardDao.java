package kr.co.Farmstory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.Farmstory.vo.ArticleVo;


@Mapper
@Repository
public interface BoardDao {

	public void insertArticle(ArticleVo vo);
	public ArticleVo selectArticle(int no);
	public List<ArticleVo> selectArticles();
	public void updateArticle(ArticleVo vo);
	public void deleteArticle(int no);
}
