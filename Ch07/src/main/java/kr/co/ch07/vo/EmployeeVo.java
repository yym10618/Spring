package kr.co.ch07.vo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="Employee")
public class EmployeeVo {

	@Id
	private String uid;
	private String name;
	private int gender;
	private String hp;
	private String email;
	private String pos;
	private int dep;
	@Column(updatable=false)
	@CreationTimestamp
	private Timestamp rdate;
	
}
