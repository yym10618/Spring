package kr.co.Farmstory.service;

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

import kr.co.Farmstory.dao.BoardDao;
import kr.co.Farmstory.vo.ArticleVo;
import kr.co.Farmstory.vo.FileVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao dao;
	
	public int insertArticle(ArticleVo vo) {
		dao.insertArticle(vo);
		return vo.getNo();
	}
	public void insertFile(FileVo vo) {
		dao.insertFile(vo);
	}
	public ArticleVo selectArticle(int no) {
		return dao.selectArticle(no);
	}
	public List<ArticleVo> selectArticles(String type, int start) {
		return dao.selectArticles(type, start);
	}
	public int selectCountTotal(String type) {
		return dao.selectCountTotal(type);
	}
	// 파일 테이블의 파일 조회
	public FileVo selectFile(int fid) {
		return dao.selectFile(fid);
	}
	public void updateArticle(ArticleVo vo) {
		dao.updateArticle(vo);
	}
	public void deleteArticle(int no) {
		dao.deleteArticle(no);
	}
	
	// 파일 업로드
	@Value("${spring.servlet.multipart.location}")
	private String uploadDir;
	
	public FileVo fileUpload(MultipartFile fname) {
		
		String path = new File(uploadDir).getAbsolutePath();
		
		String oName = fname.getOriginalFilename();
		String ext = oName.substring(oName.lastIndexOf("."));
		
		String nName = UUID.randomUUID().toString()+ext;
		
		FileVo fvo = null;
		
		try {
			// 첨부파일 저장
			fname.transferTo(new File(path+"/"+nName));
			
			// 첨부파일 정보객체 생성
			fvo = new FileVo();
			fvo.setOName(oName);
			fvo.setNName(nName);
			
		}catch (Exception e) {
			e.printStackTrace();
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
			String path = new File(uploadDir).getAbsolutePath()+"/"+fvo.getNName();
			byte[] fileByte = FileUtils.readFileToByteArray(new File(path));		
			
			resp.getOutputStream().write(fileByte);
			resp.getOutputStream().flush(); // 버퍼에 남아있는 잔존데이터 제거
			resp.getOutputStream().close(); // 종료
			
		}catch (Exception e) {
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