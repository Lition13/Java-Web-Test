package com.lition.po;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_USER", schema = "CAR")
public class TUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String pwd;
	private String realname;
	private String sex;
	private Integer depid;
	private String phone;
	
	//1个用户包含多个角色
	private Set<TRole> roleList = new HashSet<TRole>();
	
	//
	private List<TMenu> menusList = new ArrayList<TMenu>();

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TUser(Integer id, String username, String pwd, String realname,
			String sex, Integer depid, String phone) {
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.realname = realname;
		this.sex = sex;
		this.depid = depid;
		this.phone = phone;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
	@SequenceGenerator(name = "seq_user", sequenceName = "seq_t_user", initialValue = 1, allocationSize = 1, schema = "car")
	@Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "USERNAME")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PWD")
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "REALNAME")
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "SEX")
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "DEPID", precision = 5, scale = 0)
	public Integer getDepid() {
		return this.depid;
	}

	public void setDepid(Integer depid) {
		this.depid = depid;
	}

	@Column(name = "PHONE")
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "TUser [id=" + id + ", username=" + username + ", pwd=" + pwd
				+ ", realname=" + realname + ", sex=" + sex + ", depid="
				+ depid + ", phone=" + phone + "]";
	}

	//配置多对多的关系
	//级联关系 none 维护关系为自身
	@ManyToMany 
	@JoinTable(name="t_user_role", schema="car", 
	joinColumns=@JoinColumn(name="userid"),inverseJoinColumns=@JoinColumn(name="roleid"))
	public Set<TRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<TRole> roleList) {
		this.roleList = roleList;
	}

	/**
	 * 表示该字段为临时字段，不是表结构中的字段
	 * @return
	 */
	@Transient
	public List<TMenu> getMenusList() {
		return menusList;
	}

	public void setMenusList(List<TMenu> menusList) {
		this.menusList = menusList;
	}

}