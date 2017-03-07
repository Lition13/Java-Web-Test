package com.lition.action;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.lition.po.UseVehicleRegister;
import com.lition.service.IVehicleApplicationService;
import com.lition.service.IVehicleRegisterService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class VehicleRegisterAction extends BaseAction implements
		ModelDriven<UseVehicleRegister> {

	UseVehicleRegister model = new UseVehicleRegister();

	@Resource
	private IVehicleRegisterService regService;
   
	@Resource
	private IVehicleApplicationService appService;
	// 修改与保存
	public String save() throws  IOException {
		
		System.out.println("Enter!!!" + model.getVehicleId());
		if("0000".equals(model.getVehicleId()))
			model.setState("021");
		else{
			model.setState("020");
			
			
		}
		
		regService.save(model);
		//修改申请表中的申请状态
		appService.audit(model.getRequisitionId(), model.getState());
		return "query";
	}
	
	// 用车申请列表
	public String query() {
	//	pageModel = appService.query(model, currentPage, pageSize);
		return "list";
	}

	
	// 到增加页面
	public String init() {
		// 找出所有的部门

		// 找出所有的角色

		return SUCCESS;
	}

	// 到修改页面
	public String updatePage() {

		return "query";
	}

	// 删除
	public String delete() {

		return "query";
	}

	@Override
	public UseVehicleRegister getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	
}
