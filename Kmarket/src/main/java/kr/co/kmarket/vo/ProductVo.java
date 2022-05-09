package kr.co.kmarket.vo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductVo {
	private int pid;
	private int cate1;
	private int cate2;
	private String name;
	private String desc;
	private String company;
	private String seller;
	private int price;
	private int discount;
	private int point;
	private int stock;
	private int sold;
	private int delivery;
	private int hit;
	private int score;
	private int review;
	private String thumb1;
	private String thumb2;
	private String thumb3;
	private String detail;
	private String status;
	private String dutyFree;
	private String receipt;
	private String bizClass;
	private String origin;
	private String ip;
	private String rdate;
	private int etc1;
	private int etc2;
	private String etc3;
	private String etc4;
	private String etc5;
	
	//추가필드
	private int salePrice;
	private int order;
	private int start;
	
	private MultipartFile img1;
	private MultipartFile img2;
	private MultipartFile img3;
	private MultipartFile imgDetail;
	
	public List<MultipartFile> getThumbnails() {
		return Arrays.asList(img1, img2, img3, imgDetail);
	}
	
	
}