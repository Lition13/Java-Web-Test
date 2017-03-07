package com.lition.dao;

import java.util.List;

import com.lition.po.OwnedVehicle;
import com.lition.util.PageModel;

public interface IOwnedDao {

	void save(OwnedVehicle owend) throws RuntimeException;
	
	void update(OwnedVehicle owend) throws RuntimeException;
	
	void delete(OwnedVehicle owend) throws RuntimeException;
	
	OwnedVehicle queryById(int id);
	
	PageModel query(OwnedVehicle owend, int currentPage, int pageSize);
	
	void saveImportData(List<OwnedVehicle> list);

	List<OwnedVehicle> queryAll();
}
