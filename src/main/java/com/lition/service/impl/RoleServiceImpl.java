package com.lition.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lition.dao.IRoleDao;
import com.lition.po.TRole;
import com.lition.service.IRoleService;
import com.lition.util.PageModel;

@Service
public class RoleServiceImpl implements IRoleService{

	@Resource
	private IRoleDao dao;
	
	@Override
	public void save(TRole role) throws RuntimeException {
		// TODO Auto-generated method stub
		dao.save(role);
	}

	@Override
	public void update(TRole role) throws RuntimeException {
		// TODO Auto-generated method stub
		dao.update(role);
	}

	@Override
	public void delete(TRole role) throws RuntimeException {
		// TODO Auto-generated method stub
		dao.delete(role);
	}

	@Override
	public TRole queryById(int id) {
		return dao.queryById(id);
	}

	@Override
	public List<TRole> query(TRole role) {
		// TODO Auto-generated method stub
		return dao.query(role);
	}

	@Override
	public PageModel query(TRole role, int currentPage, int pageSize) {
		return dao.query(role, currentPage, pageSize);
	}

}
