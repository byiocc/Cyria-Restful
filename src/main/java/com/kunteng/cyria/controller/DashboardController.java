package com.kunteng.cyria.controller;


import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kunteng.cyria.domain.Dashboard;

@RestController
@RequestMapping("/api/v1")
public class DashboardController {

	@GetMapping("/dashboard")
	public Object getAllDashboard() {
		return null;
	}
	
	@GetMapping("/dashboard/{id}")
	public Object getDashboardById(@PathVariable(value = "id") Long dashboardId) {
		return null;
	}
	
	@PostMapping("/dashboard")
	public Object createDashboard(@Valid @RequestBody Dashboard dashboard) {
		return null;
	}
	
	@PutMapping("/dashboard/{id}")
	public Object modifyDashboard(@PathVariable(value = "id") Long dashboardId, 
			@Valid @RequestBody Dashboard dashboard) {
		return null;
	}
	
	@DeleteMapping("/dashboard/{id}")
	public Object deleteDashboard(@PathVariable(value = "id") Long dashboardId) {
		return null;
	}
}
