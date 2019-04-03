package com.kunteng.cyria.controller;


import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kunteng.cyria.domain.Dashboard;
import com.kunteng.cyria.service.DashboardService;
import com.kunteng.cyria.dto.CommonResult;

@RestController
@RequestMapping("/api/v1")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	@GetMapping("/dashboards")
	public Object getAllDashboard() {
		List<Dashboard> dashes = dashboardService.getAllDashboard();
		return new CommonResult().success(dashes);
	}
	
	@GetMapping("/dashboard/{id}")
	public Object getDashboardById(@PathVariable(value = "id") /*Long*/ String dashboardId) {
		Dashboard dash = dashboardService.getDashboardById(dashboardId);
		return new CommonResult().success(dash);
	}
	
	@PostMapping("/dashboard")
	public Object createDashboard(@Valid @RequestBody Dashboard dashboard) {
		Dashboard dash = dashboardService.addDashboard(dashboard);
		return new CommonResult().success(dash);
	}
	
	@PutMapping("/dashboard/{id}")
	public Object modifyDashboard(@PathVariable(value = "id") String dashboardId, 
			@Valid @RequestBody Dashboard dashboard) {
		Dashboard dash = dashboardService.updateDashboard(dashboardId,dashboard);
		if(dash != null)
			return new CommonResult().success(dash);
		else
			return new CommonResult().failed();
	}
	
	@DeleteMapping("/dashboard/{id}")
	public Object deleteDashboard(@PathVariable(value = "id") String dashboardId) {
		dashboardService.deleteDashboard(dashboardId);
		return new CommonResult().success(null);
	}
}
