package kr.co.ch07.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Customer")
public class CustomerVo {

	@Id
	private String custid;
	private String name;
	private String address;
	private String phone;
}
