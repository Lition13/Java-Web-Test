package com.lition.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TMenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_MENU", schema = "CAR")
public class TMenu implements java.io.Serializable {

	// Fields

	private Integer id;
	private String menuname;
	private String menulink;
	private Integer pid;
	private String securyname;
	private String memo;
	private Integer isdelete;
	// Constructors

	/** default constructor */
	public TMenu() {
	}

	/** minimal constructor */
	public TMenu(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TMenu(Integer id, String menuname, String menulink, Integer pid,
			String securyname, String memo) {
		this.id = id;
		this.menuname = menuname;
		this.menulink = menulink;
		this.pid = pid;
		this.securyname = securyname;
		this.memo = memo;
	}

	// Property accessors
	@Id
	@GeneratedValue(generator="seq_menu",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_menu",sequenceName="seq_t_menu", initialValue=1,allocationSize=1)
	@Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "MENUNAME")
	public String getMenuname() {
		return this.menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	@Column(name = "MENULINK")
	public String getMenulink() {
		return this.menulink;
	}

	public void setMenulink(String menulink) {
		this.menulink = menulink;
	}

	@Column(name = "PID", precision = 5, scale = 0)
	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "SECURYNAME")
	public String getSecuryname() {
		return this.securyname;
	}

	public void setSecuryname(String securyname) {
		this.securyname = securyname;
	}

	@Column(name = "MEMO")
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}


	@Override
	public String toString() {
		return "TMenu [id=" + id + ", menuname=" + menuname + ", menulink="
				+ menulink + ", pid=" + pid + ", securyname=" + securyname
				+ ", memo=" + memo + ", isdelete=" + isdelete + "]";
	}

	@Column(name = "ISDELETE")
	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	
}