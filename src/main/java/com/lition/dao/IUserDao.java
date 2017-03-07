package com.lition.dao;

import java.util.List;

import com.lition.po.TMenu;
import com.lition.po.TUser;
import com.lition.util.PageModel;

public interface IUserDao {

	void save(TUser user) throws RuntimeException;
	
	void update(TUser user) throws RuntimeException;
	
	void delete(TUser user) throws RuntimeException;
	
	TUser queryById(int id);
	
	PageModel query(TUser user, int currentPage, int pageSize);
	
	void saveSyndata() throws RuntimeException;
	
	TUser login(String userName, String password);

	/**
	 * 根据用户编号查询对应的菜单
	 * @param i
	 * @return
	 */
	List<TMenu> queryUserMenuById(int i);
}
