package kr.co.Farmstory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.Farmstory.vo.ArticleVo;
import kr.co.Farmstory.vo.FileVo;


@Mapper
@Repository
public interface BoardDao {

	public int insertArticle(ArticleVo vo);
	public void insertFile(FileVo vo);
	public int insertComment(ArticleVo vo);
	public List<ArticleVo> selectcomments(int no);
	public int selectCountTotal(String type);
	public ArticleVo selectArticle(int no);
	public List<ArticleVo> selectArticles(String type, int start);
	public FileVo selectFile(int fid);
	public List<ArticleVo> selectLatest(String type);
	public void updateArticle(ArticleVo vo);
	public void deleteArticle(int no);
}
