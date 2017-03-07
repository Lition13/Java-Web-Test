package com.lition.dao;

import com.lition.po.TDepartment;

public interface IDepartmentDao {

	void save(TDepartment department) throws RuntimeException;
	
	void update(TDepartment department) throws RuntimeException;
	
	void delete(TDepartment department) throws RuntimeException;
	
	TDepartment queryById(int id);
}
