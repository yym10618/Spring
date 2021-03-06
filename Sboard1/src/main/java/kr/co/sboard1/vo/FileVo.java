package kr.co.sboard1.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
public class FileVo {

	private int fid;
	private int parent;
	private String oName;
	private String nName;
	private int download;
	private String rdate;
}
