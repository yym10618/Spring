package kr.co.Farmstory.vo;

import lombok.Data;

@Data
public class ArticleVo {

	private int no;
	private int parent;
	private int comment;
	private String cate;
	private String title;
	private String content;
	private int file;
	private int hit;
	private String uid;
	private String regip;
	private String rdate;
	private String type;
}
