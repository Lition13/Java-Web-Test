package com.lition.dao;

import java.util.List;

import com.lition.po.TRole;
import com.lition.po.TUser;
import com.lition.util.PageModel;

public interface IRoleDao {

	void save(TRole role) throws RuntimeException;
	
	void update(TRole role) throws RuntimeException;
	
	void delete(TRole role) throws RuntimeException;
	
	TRole queryById(int id);
	
	List<TRole> query(TRole role);
	
	PageModel query(TRole role, int currentPage, int pageSize);
}
