package kr.co.sboard1.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kr.co.sboard1.vo.ArticleVo;

@Repository
public interface ArticleRepo extends JpaRepository<ArticleVo, Integer>{
	
	@Query(nativeQuery=true, value= "SELECT a.*, b.nick FROM Board_article AS a \r\n"
									+ "JOIN Board_user AS b\r\n"
									+ "ON a.uid = b.uid\r\n"
									+ "WHERE a.parent = 0\r\n"
									+ "ORDER BY no DESC\r\n"
									+ "LIMIT :start, 10;")
	public List<ArticleVo> selectArticlesAddNick(@Param("start") int start);
}