package kr.co.ch07.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="Student")
public class StudentVo {

	@Id
	private String sid;
	private String name;
	private int gender;
	private String hp;
	private int grade;
	
	@Column(updatable=false)
	@CreationTimestamp
	private Timestamp regdate;
}
