package com.lition.service;

import com.lition.po.TDepartment;
import com.lition.po.TUser;
import com.lition.util.PageModel;

public interface IDepartmentService {

	void save(TDepartment department) throws RuntimeException;

	void update(TDepartment department) throws RuntimeException;

	void delete(TDepartment department) throws RuntimeException;

	TDepartment queryById(int id);
}
