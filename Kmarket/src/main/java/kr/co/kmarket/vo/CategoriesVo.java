package kr.co.kmarket.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriesVo {

	private int cate1;
	private int cate2;
	private String tit1;
	private String tit2;
	
	private List<Cate2Vo> cate2List;
}
