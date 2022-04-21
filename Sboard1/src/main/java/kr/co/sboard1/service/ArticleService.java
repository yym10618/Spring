package kr.co.sboard1.service;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sboard1.dao.ArticleDao;
import kr.co.sboard1.persistence.ArticleRepo;
import kr.co.sboard1.persistence.FileRepo;
import kr.co.sboard1.vo.ArticleVo;
import kr.co.sboard1.vo.FileVo;

@Service
public class ArticleService {

	@Autowired
	private ArticleDao dao;
	
	@Autowired
	private ArticleRepo repo;
	
	@Autowired
	private FileRepo fileRepo;
	
	// 글작성
	public int insertArticle(ArticleVo vo) {
		// JPA
		//repo.save(vo);
		
		// MyBatis
		dao.insertArticle(vo);
		return vo.getNo();
	}
	
	// 파일테이블 입력
	public void insertFile(FileVo vo) {
		// JPA
		//fileRepo.save(vo);
		
		// MyBatis
		dao.insertFile(vo);
	}
	
	// 댓글 입력
	public int insertComment(ArticleVo vo) {
		return dao.insertComment(vo);
	}
	
	public List<ArticleVo> selectComment(int no) {
		return dao.selectcomments(no);
	}
	
	// 글조회
	public ArticleVo selectArticle(int no) {
		// JPA
		
		// MyBatis
		ArticleVo article = dao.selectArticle(no);
		
		return article;
	}
	
	// 글 목록 조회
	public List<ArticleVo> selectArticles(int start){
		// JPA
		//List<ArticleVo> articles = repo.selectArticlesAddNick(start);
		
		// MyBatis
		List<ArticleVo> articles = dao.selectArticles(start);
		
		return articles;
	}
	
	// 전체 글 개수 조회
	public int selectCountTotal() {
		// JPA
		
		// MyBatis
		int total = dao.selectCountTotal();
		
		return total;
	}
	
	// 파일 테이블의 파일 조회
	public FileVo selectFile(int fid) {
		// JPA
		
		// MyBatis
		FileVo fvo = dao.selectFile(fid);
		
		return fvo;
	}
	
	public void updateArticle(ArticleVo vo) {}
	public void deleteArticle(int no) {}
	
	// 파일 업로드
	@Value("${spring.servlet.multipart.location}") // properties의 파일 업로드 설정값 대입
	private String uploadDir;
	public FileVo fileUpload(MultipartFile fname) {
		String path = new File(uploadDir).getAbsolutePath(); // 파일경로 구하기
		
		String oName = fname.getOriginalFilename(); // 첨부했을때 파일이름
		String ext = oName.substring(oName.lastIndexOf(".")); // 확장자 이름만 남기기
		String nName = UUID.randomUUID().toString()+ext; // 절대 겹치지 않는 이름생성해주는 클래스 UUID
		FileVo fvo = null;
		
		try {
			// 첨부파일 저장
			fname.transferTo(new File(path+"/"+nName));
			
			// 첨부파일 정보객체 생성
			fvo = new FileVo();
			fvo.setOName(oName);
			fvo.setNName(nName);
			
		}catch(Exception e) {
			
		}
		return fvo;
	}
	
	// 파일 다운로드
	public void fileDownload(HttpServletResponse resp, FileVo fvo) {
		try {
			// 파일 다운로드 response 헤더수정	
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fvo.getOName(), "utf-8"));
			resp.setHeader("Content-Transfer-Encoding", "binary");
			resp.setHeader("Pragma", "no-cache");
			resp.setHeader("Cache-Control", "private");
			
			// 파일 스트림 작업
			String path = new File(uploadDir).getAbsolutePath()+"/"+fvo.getNName(); // 파일경로 구하기
			byte[] fileByte = FileUtils.readFileToByteArray(new File(path));
			resp.getOutputStream().write(fileByte);
			resp.getOutputStream().flush(); // 버퍼에 남아있는 잔존데이터 제거
			resp.getOutputStream().close(); // 종료
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 페이지 작업
	public int getLastPageNum(int total){
		
		int lastPageNum = 0;
		
		if(total % 10 == 0) {
			lastPageNum = total / 10;
		}else {
			lastPageNum = total / 10 + 1;
		}
		
		return lastPageNum;
	}
	public int getCurrentPage(String pg) {
		
		int currentPage = 1;
		
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		
		return currentPage;
	}
	public int getLimitStart(int currentPage) {
		
		return (currentPage - 1) * 10;
	}
	public int getPageStartNum(int total, int start) {
		return (total - start);
	}
	public int[] getPageGroup(int currentPage, int lastPageNum) {
		int groupCurrent = (int)Math.ceil(currentPage/10.0);
		int groupStart = (groupCurrent - 1) * 10 + 1;
		int groupEnd = groupCurrent * 10;
		
		if(groupEnd > lastPageNum) {
			groupEnd = lastPageNum;
		}
		
		int[] groups = {groupStart, groupEnd};
		
		return groups;
	}
	
	
	
	
}