package com.lition.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lition.dao.IMenuDao;
import com.lition.po.TMenu;
import com.lition.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService{

	@Resource
	private IMenuDao dao;

	@Override
	public void save(TMenu menu) throws RuntimeException {
		dao.save(menu);
	}

	@Override
	public void update(TMenu menu) throws RuntimeException {
		dao.update(menu);
	}

	@Override
	public void delete(TMenu menu) throws RuntimeException {
		dao.delete(menu);
	}

	@Override
	public TMenu queryById(int id) {
		return dao.queryById(id);
	}

	@Override
	public List<TMenu> query(TMenu menu) {
		return dao.query(menu);
	}
	
}
