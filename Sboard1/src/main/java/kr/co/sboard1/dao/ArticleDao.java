package kr.co.sboard1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.sboard1.vo.ArticleVo;
import kr.co.sboard1.vo.FileVo;

@Mapper
@Repository
public interface ArticleDao {

	public int insertArticle(ArticleVo vo);
	public void insertFile(FileVo vo);
	public int insertComment(ArticleVo vo);
	public List<ArticleVo> selectcomments(int no);
	public ArticleVo selectArticle(int no);
	public List<ArticleVo> selectArticles(int start);
	public int selectCountTotal();
	public FileVo selectFile(int fid);
	public void updateArticle(ArticleVo vo);
	public void deleteArticle(int no);
	
}