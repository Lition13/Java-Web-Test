package com.lition.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.lition.po.TUser;
import com.lition.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class LoginAction extends BaseAction implements ModelDriven<TUser>{

	@Resource
	private IUserService service;
	
	/**
	 * 登录
	 * @return
	 */
	public String login(){
		model = service.login(model.getUsername(), model.getPwd());
		
		if (model != null) {
			//登录成功
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("LOGIN_USER", model);
			return "home";
		}else{
			//登录失败
			this.addActionMessage("帐号密码错误，请重新输入");
			return "login";
		}
		
	}
	
	/**
	 * 注销
	 * @return
	 */
	public String logout(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.clear();
		return "login";
	}
	
	private TUser model = new TUser();
	
	@Override
	public TUser getModel() {
		return model;
	}
	

}
