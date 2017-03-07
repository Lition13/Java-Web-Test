package com.lition.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lition.dao.IUserDao;
import com.lition.po.TMenu;
import com.lition.po.TUser;
import com.lition.service.IUserService;
import com.lition.util.PageModel;

@Service
public class UserServiceImpl implements IUserService{

	@Resource
	private IUserDao dao;
	
	@Override
	public void save(TUser user) throws RuntimeException {
		dao.save(user);
	}

	@Override
	public void update(TUser user) throws RuntimeException {
		dao.update(user);
	}

	@Override
	public void delete(TUser user) throws RuntimeException {
		dao.delete(user);
	}

	@Override
	public TUser queryById(int id) {
		return dao.queryById(id);
	}

	@Override
	public PageModel query(TUser user, int currentPage, int pageSize) {
		return dao.query(user, currentPage, pageSize);
	}

	@Override
	public void saveSyndata() throws RuntimeException {
		// TODO Auto-generated method stub
		dao.saveSyndata();
	}

	/**
	 * 首先判断使用是否正确
	 * 		如果登录成功
	 * 		那么我们需要查询出改用所有具有的所有的菜单
	 */
	@Override
	public TUser login(String userName, String password) {
		TUser user = dao.login(userName, password);
		if (user != null) {
			//表示登录成功，查询当前用户的所有的菜单
			List<TMenu> list = dao.queryUserMenuById(user.getId());
			user.setMenusList(list);
		}
		return dao.login(userName, password);
	}
}
