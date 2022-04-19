package kr.co.sboard1.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

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
	
	public int insertArticle(ArticleVo vo) {
		// JPA
		repo.save(vo);
		
		// MyBatis
		//dao.insertArticle(vo);
		return vo.getNo();
	}
	
	public void insertFile(FileVo vo) {
		// JPA
		//fileRepo.save(vo);
		
		// MyBatis
		dao.insertFile(vo);
	}
	
	public ArticleVo selectArticle(int no) {
		return null;
	}
	public List<ArticleVo> selectArticles(){
		
		return dao.selectArticles();
	}
	public void updateArticle(ArticleVo vo) {}
	public void deleteArticle(int no) {}
	
	@Value("${file.upload-dir}") // properties의 파일 업로드 설정값 대입
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
	
	public void fileDownload() {
		
	}
	
	
	
	
	
}