package com.lition.po;

import java.util.HashSet;
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

import org.springframework.jmx.export.annotation.ManagedAttribute;

/**
 * TRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ROLE", schema = "CAR")
public class TRole implements java.io.Serializable {

	// Fields

	private Integer id;
	private String rolename;
	private String demo;

	// 一个角色对应对个菜单
	private Set<TMenu> menus = new HashSet<TMenu>();
	
	// Constructors

	/** default constructor */
	public TRole() {
	}

	/** minimal constructor */
	public TRole(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TRole(Integer id, String rolename, String demo) {
		this.id = id;
		this.rolename = rolename;
		this.demo = demo;
	}

	// Property accessors
	@Id
	@GeneratedValue(generator="seq_role", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_role", sequenceName="seq_t_role",initialValue=1,allocationSize=1)
	@Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "ROLENAME")
	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Column(name = "DEMO")
	public String getDemo() {
		return this.demo;
	}

	public void setDemo(String demo) {
		this.demo = demo;
	}

	@ManyToMany
	@JoinTable(name="t_role_menu",joinColumns=@JoinColumn(name="roleid"),inverseJoinColumns=@JoinColumn(name="menuid"),schema="car")
	public Set<TMenu> getMenus() {
		return menus;
	}

	public void setMenus(Set<TMenu> menus) {
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "TRole [id=" + id + ", rolename=" + rolename + ", demo=" + demo
				+ ", menus=" + menus + "]";
	}

	
}