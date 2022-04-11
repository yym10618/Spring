package kr.co.ch07.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Member")
public class MemberVo {
	
	@Id
	private String uid;
	private String name;
	private String hp;
	private String pos;
	private String dep;
	
	@Column(updatable=false)
	@CreationTimestamp
	private Timestamp rdate;

}
