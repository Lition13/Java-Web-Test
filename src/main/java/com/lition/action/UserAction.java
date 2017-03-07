package com.lition.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.lition.po.TRole;
import com.lition.po.TUser;
import com.lition.service.IRoleService;
import com.lition.service.IUserService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class UserAction extends BaseAction implements ModelDriven<TUser>{

	@Resource
	private IUserService userService;
	
	@Resource
	private IRoleService roleService;
	
	private List<TRole> roles;
	
	public String saveOrUpdate(){
		System.out.println("Enter" + user);
		userService.save(user);
		return "query";
	}
	
	public String query(){
		pageModel = userService.query(user, currentPage, pageSize);
		System.out.println(pageModel.getResult());
		return SUCCESS;
	}
	
	public String init(){
		roles = roleService.query(null);
		System.out.println("init");
		return "add";
	}
	
	public String syndata(){
		System.out.println("syndata!!!");
		userService.saveSyndata();
		return "query";
	}
	
	private TUser user = new TUser();
	
	@Override
	public TUser getModel() {
		return user;
	}


	public List<TRole> getRoles() {
		return roles;
	}

	public void setRoles(List<TRole> roles) {
		this.roles = roles;
	}

}
