package com.lition.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;

import com.lition.dao.IOwnedDao;
import com.lition.po.OwnedVehicle;
import com.lition.service.IOwnedService;
import com.lition.util.PageModel;

@Service
public class OwnedServiceImpl implements IOwnedService{

	@Resource
	private IOwnedDao dao;
	
	@Override
	public void save(OwnedVehicle owend) throws RuntimeException {
		dao.save(owend);
	}

	@Override
	public void update(OwnedVehicle owend) throws RuntimeException {
		dao.update(owend);
	}

	@Override
	public void delete(OwnedVehicle owend) throws RuntimeException {
		dao.delete(owend);
	}

	@Override
	public OwnedVehicle queryById(int id) {
		return dao.queryById(id);
	}

	@Override
	public PageModel query(OwnedVehicle owend, int currentPage, int pageSize) {
		return dao.query(owend, currentPage, pageSize);
	}

	@Override
	public void importExcelData(File upload) {
		try {
			InputStream in = new FileInputStream(upload);
			HSSFWorkbook wb = new HSSFWorkbook(in);
			HSSFSheet sheet = wb.getSheetAt(0);
			
			int rows = sheet.getLastRowNum();
			List<OwnedVehicle> list = new ArrayList<OwnedVehicle>();
			// i指定为从第二行开始
			for (int i = 2; i < rows; i++) {
				HSSFRow row = sheet.getRow(i);
				
				int id = Integer.parseInt(getValue(row.getCell(0)));
				String vehicleId = getValue(row.getCell(1));
				String depid = getValue(row.getCell(2));
				String model = getValue(row.getCell(3));
				String licenseCode = getValue(row.getCell(4));
				
				OwnedVehicle ov = new OwnedVehicle();
				ov.setVehicleId(vehicleId);
				ov.setId(id);
				ov.setDepid(depid);
				ov.setModel(model);
				ov.setLicenseCode(licenseCode);
				System.out.println(ov);
				list.add(ov);
			}
			dao.saveImportData(list);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getValue(HSSFCell cell) {
		String cellValue = "";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			double d = cell.getNumericCellValue();
			int intd = (int) d;
			cellValue = String.valueOf(intd);
			break;
		case HSSFCell.CELL_TYPE_STRING:
			cellValue = cell.getStringCellValue();
		default:
			break;
		}
		return cellValue;
	}

	/**
	 * 通过POI批量导出自有车辆信息
	 */
	@Override
	public InputStream getOutExcelDate() {
		//1.第二行的表头数据
		String headTitle[] = {"id","车辆编号","使用单位","车辆类型","车牌号码"};
		
		//2.通过Dao获取所有的自有车辆信息
		List<OwnedVehicle> list = dao.queryAll();
		
		
		//3.获取HSSFWorkbook
		HSSFWorkbook wb = new HSSFWorkbook();
		
		//4.获取sheet对象
		HSSFSheet sheet = wb.createSheet("自有车辆信息");
		
		//5.创建样式
		HSSFCellStyle style = wb.createCellStyle();
		// 对齐方式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		//6.创建第一行
		HSSFRow row0 = sheet.createRow(0);
		//7.合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
		
		HSSFCell row0cell0 = row0.createCell(0);
		row0cell0.setCellValue("自由车辆信息");
		row0cell0.setCellStyle(style);
		
		HSSFRow row1 = sheet.createRow(1);
		
		for (int i = 0; i < headTitle.length; i++) {
			HSSFCell row0cell = row1.createCell(i);
			row0cell.setCellValue(headTitle[i]);
			row0cell.setCellStyle(style);
		}
		
		for (int i = 0; i < list.size(); i++) {
			HSSFRow row = sheet.createRow(i+2);
			
			//车辆ID
			HSSFCell cell0 = row.createCell(0);
			cell0.setCellValue(list.get(i).getId());
			cell0.setCellStyle(style);
			
			//车辆编号
			HSSFCell cell1 = row.createCell(1);
			cell1.setCellValue(list.get(i).getVehicleId());
			cell1.setCellStyle(style);
			
			//使用单位
			HSSFCell cell2 = row.createCell(2);
			cell2.setCellValue(list.get(i).getDepid());
			cell2.setCellStyle(style);
			
			//车辆类型
			HSSFCell cell3 = row.createCell(3);
			cell3.setCellValue(list.get(i).getModel());
			cell3.setCellStyle(style);
			
			//车牌号码
			HSSFCell cell4 = row.createCell(4);
			cell4.setCellValue(list.get(i).getVehicleUsageId());
			cell4.setCellStyle(style);
		}
		
		//返回生成的inputstream;
		try {
			OutputStream out = new FileOutputStream("abc.xls");
			wb.write(out);
			out.close();
			InputStream in = new FileInputStream("abc.xls");
			return in;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<OwnedVehicle> queryAll() {
		return dao.queryAll();
	}

}
