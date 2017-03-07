package com.lition.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.lition.po.TMenu;
import com.lition.service.IMenuService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class MenuAction extends BaseAction implements ModelDriven<TMenu>{

	@Resource
	private IMenuService menuService;
	
	private List<TMenu> menuList;
	
	public String delete(){
		menuService.delete(model);
		return "query";
	}
	
	public String updatePage(){
		menuList = menuService.query(model);
		model = menuService.queryById(model.getId());
		System.out.println(model);
		ActionContext.getContext().getValueStack().push(model);
		
		return "add";
	}
	
	public String saveOrUpdate(){
		
		if (model.getId() != null && model.getId() > 0) {
			//更改操作
			menuService.update(model);
		}else{
			menuService.save(model);
		}
		
		return "query";
	}
	
	public String init(){
		//查询出所有的菜单
		menuList = menuService.query(model);
		return "add";
	}
	
	public String query(){
		setMenuList(menuService.query(model));
		return SUCCESS;
	}
	
	private TMenu model = new TMenu();
	
	@Override
	public TMenu getModel() {
		return model;
	}

	public List<TMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<TMenu> menuList) {
		this.menuList = menuList;
	}

}
