package com.lition.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lition.dao.IVehicleApplicationDao;
import com.lition.po.UseVehicleApplication;
import com.lition.service.IVehicleApplicationService;
import com.lition.util.PageModel;
@Service
public class VehicleApplicationServiceImpl implements
		IVehicleApplicationService {

	@Resource
	private IVehicleApplicationDao adao;
	@Override
	public void save(UseVehicleApplication uvp) throws RuntimeException {
		// TODO Auto-generated method stub
		adao.save(uvp);
	}

	@Override
	public void update(UseVehicleApplication uvp) throws RuntimeException {
		// TODO Auto-generated method stub
		adao.update(uvp);
	}

	@Override
	public void delete(UseVehicleApplication uvp) throws RuntimeException {
		// TODO Auto-generated method stub
		adao.delete(uvp);
	}

	@Override
	public UseVehicleApplication findById(int id) {
		// TODO Auto-generated method stub
		return adao.findById(id);
	}

	@Override
	public PageModel query(UseVehicleApplication uvp, int currentPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return adao.query(uvp, currentPage, pageSize);
	}

	@Override
	public void audit(Integer id, String state) {
		adao.audit(id,state);
		
	}

}
