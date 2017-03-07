package com.lition.dao;

import java.util.List;

import com.lition.po.TMenu;

public interface IMenuDao {

	void save(TMenu menu) throws RuntimeException;
	
	void update(TMenu menu) throws RuntimeException;
	
	void delete(TMenu menu) throws RuntimeException;
	
	TMenu queryById(int id);
	
	List<TMenu> query(TMenu menu);
}
