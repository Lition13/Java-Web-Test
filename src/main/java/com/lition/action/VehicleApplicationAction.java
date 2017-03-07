package com.lition.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.lition.po.OwnedVehicle;
import com.lition.po.UseVehicleApplication;
import com.lition.service.IOwnedService;
import com.lition.service.IVehicleApplicationService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class VehicleApplicationAction extends BaseAction implements
		ModelDriven<UseVehicleApplication> {

	UseVehicleApplication model = new UseVehicleApplication();

	@Resource
	private IVehicleApplicationService appService;
	@Resource
	private IOwnedService ownedService;
	private List<OwnedVehicle> ownedlist;

	// 修改与保存
	public String save() {
		if (model.getId() != null && model.getId() > 0) {
			appService.update(model);
		} else {
			// 把状态改成审批中000
			model.setState("000");
			appService.save(model);
		}
		return "query";
	}

	// 修改与保存
	public String saveChoice() {

		appService.save(model);

		return "query";
	}

	// 用车申请列表
	public String query() {
		pageModel = appService.query(model, currentPage, pageSize);
		return "list";
	}

	// 审核
	public String audit() {
		appService.audit(model.getId(), model.getState());
		model.setState("000");
		return "query";
	}

	// 用车调度列表
	public String dispatch() {
		model.setState("010");
		pageModel = appService.query(model, currentPage, pageSize);
		return "dispatchlist";
	}

	// 到调度车辆
	public String choiceCar() {
		model = appService.findById(model.getId());
		ActionContext.getContext().getValueStack().push(model);
		// 取出所有的车辆
		ownedlist = ownedService.queryAll();
		
		System.out.println(ownedlist.size());
		return "choiceCar";
	}

	// 到增加页面
	public String init() {

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
	public UseVehicleApplication getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	public List<OwnedVehicle> getOwnedlist() {
		return ownedlist;
	}

	public void setOwnedlist(List<OwnedVehicle> ownedlist) {
		this.ownedlist = ownedlist;
	}

}
