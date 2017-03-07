package com.lition.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TDepartment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_DEPARTMENT", schema = "CAR")
public class TDepartment implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String memo;

	// Constructors

	/** default constructor */
	public TDepartment() {
	}

	/** minimal constructor */
	public TDepartment(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TDepartment(Integer id, String name, String memo) {
		this.id = id;
		this.name = name;
		this.memo = memo;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "MEMO")
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}