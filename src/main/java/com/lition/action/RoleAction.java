package com.lition.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.lition.po.TMenu;
import com.lition.po.TRole;
import com.lition.service.IMenuService;
import com.lition.service.IRoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
@Controller
public class RoleAction extends BaseAction implements ModelDriven<TRole> {

	private TRole model = new TRole();
	@Resource
	private IRoleService roleService;
	@Resource
	private IMenuService menuService;
	
	private List<TMenu> menuList;
	
	public String delete(){
		System.out.println(model.getId());
		roleService.delete(model);
		return "query";
	}
	
	public String query(){
		pageModel = roleService.query(model, currentPage, pageSize);
		return "success";
	}
	
	public String saveOrUpdate(){
		if(model.getId() != null && model.getId() > 0 ){
			// 表示更新数据
			roleService.update(model);
		}else{
			roleService.save(model);
		}
		
		return "query";
	}
	/**
	 * 修改 根据id查询出修改相关的信息
	 * @return
	 */
	public String updatePage(){
		model = roleService.queryById(model.getId());
		// 我们没有使用中间表的数据，那么中间表的数据就不会加载---》延迟加载
		
		// 显示的将数据添加到值栈中
		ActionContext.getContext().getValueStack().push(model);
		// 查询出所有的菜单信息
		setMenuList(menuService.query(null));
		return "add";
	}
	
	public String init(){
		setMenuList(menuService.query(null));
		return "add";
	}

	@Override
	public TRole getModel() {
		// TODO Auto-generated method stub
		return model ;
	}

	public List<TMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<TMenu> menuList) {
		this.menuList = menuList;
	}

}
