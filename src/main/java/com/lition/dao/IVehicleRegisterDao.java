package com.lition.dao;

import com.lition.po.UseVehicleRegister;
import com.lition.util.PageModel;

public interface IVehicleRegisterDao {
	void save(UseVehicleRegister uvr) throws RuntimeException;

	void update(UseVehicleRegister uvr) throws RuntimeException;

	void delete(UseVehicleRegister uvr) throws RuntimeException;

	UseVehicleRegister findById(int id);

	PageModel query(UseVehicleRegister uvr, int currentPage, int pageSize);
}
