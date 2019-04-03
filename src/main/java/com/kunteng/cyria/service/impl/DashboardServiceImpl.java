package com.kunteng.cyria.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.kunteng.cyria.service.DashboardService;
import com.kunteng.cyria.domain.Dashboard;
import com.kunteng.cyria.repository.DashboardRepository;

import java.util.List;
@Service
public class DashboardServiceImpl implements DashboardService {
	@Autowired
	private DashboardRepository dashboardRepository;

	public List<Dashboard> getAllDashboard(){
		return dashboardRepository.findAll();	
	}	
	
	public Dashboard getDashboardById(String id){
		return dashboardRepository.findById(id).orElse(null);
	}

	public Dashboard addDashboard(Dashboard dashboard){
		Dashboard dash = dashboardRepository.findById(dashboard.getId()).orElse(null);
                if (dash != null)
                        return null;
                return dashboardRepository.insert(dashboard);
	}

	public Dashboard updateDashboard(String id, Dashboard dashboard){
		Dashboard dash = dashboardRepository.findById(id).orElse(null);
		if(dash == null){
			return null;
		}
		dashboard.setId(id);
		return dashboardRepository.save(dashboard);
	}
	public void deleteDashboard(String id){
		dashboardRepository.deleteById(id); 
	}
}
