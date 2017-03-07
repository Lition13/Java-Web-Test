package com.lition.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.lition.po.OwnedVehicle;
import com.lition.util.PageModel;

public interface IOwnedService {

	void save(OwnedVehicle owend) throws RuntimeException;

	void update(OwnedVehicle owend) throws RuntimeException;

	void delete(OwnedVehicle owend) throws RuntimeException;

	OwnedVehicle queryById(int id);

	PageModel query(OwnedVehicle owend, int currentPage, int pageSize);

	/**
	 * 批量导入Excel文件
	 * @param upload
	 */
	void importExcelData(File upload);

	/**
	 * 到处Excel文件
	 * @return
	 */
	InputStream getOutExcelDate();
	
	List<OwnedVehicle> queryAll();
}
