package kr.co.kmarket.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderVo {

	private int oid;
	private String uid;
	private int count;
	private int price;
	private int discount;
	private int point;
	private int usePoint;
	private int delivery;
	private int total;
	private String orderer;
	private String hp;
	private String zip;
	private String addr1;
	private String addr2;
	private int payment;
	private int complete;
	private String rdate;
	private String completeDate;
	
	//추가필드
	private int[] cids;
	private int[] pids;
	private int[] counts;
}
