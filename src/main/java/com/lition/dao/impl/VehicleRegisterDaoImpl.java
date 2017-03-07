package com.lition.dao.impl;

import org.springframework.stereotype.Repository;

import com.lition.dao.IVehicleRegisterDao;
import com.lition.po.UseVehicleRegister;
import com.lition.util.BaseDao;
import com.lition.util.PageModel;
@Repository
public class VehicleRegisterDaoImpl extends BaseDao<UseVehicleRegister> implements IVehicleRegisterDao {

	@Override
	public void save(UseVehicleRegister uvr) throws RuntimeException {
		getSession().save(uvr);

	}

	@Override
	public void update(UseVehicleRegister uvr) throws RuntimeException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(UseVehicleRegister uvr) throws RuntimeException {
		// TODO Auto-generated method stub

	}

	@Override
	public UseVehicleRegister findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel query(UseVehicleRegister uvr, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
