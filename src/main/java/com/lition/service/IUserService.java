package com.lition.service;

import com.lition.po.TUser;
import com.lition.util.PageModel;

public interface IUserService {

	void save(TUser user) throws RuntimeException;

	void update(TUser user) throws RuntimeException;

	void delete(TUser user) throws RuntimeException;

	TUser queryById(int id);

	PageModel query(TUser user, int currentPage, int pageSize);
	
	void saveSyndata() throws RuntimeException;
	
	TUser login(String userName, String password);
}
