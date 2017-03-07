package com.lition.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.Region;
import org.springframework.stereotype.Controller;

import com.lition.po.OwnedVehicle;
import com.lition.service.IOwnedService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class OwnedAction extends BaseAction implements
		ModelDriven<OwnedVehicle> {

	@Resource
	private IOwnedService service;

	private File upload;

	public String query() {
		pageModel = service.query(model, currentPage, pageSize);
		System.out.println("pageModel");
		return SUCCESS;
	}

	private String fileName;

	/**
	 * 下载的路口
	 * 
	 * @return
	 */
	public InputStream getInputStream() {
		System.out.println("Enter!!!!!!!!!!!!!!!!!!!!");
		return service.getOutExcelDate();
	}

	// 下载Excel
	public String outExcel() {
		System.out.println("开始下载...");

		return "download";
	}

	// 上传Excel
	public String uploadExcel() {
		System.out.println(getUpload().getName());
		service.importExcelData(getUpload());
		return "query";
	}

	private OwnedVehicle model = new OwnedVehicle();

	@Override
	public OwnedVehicle getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
