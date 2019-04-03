package com.kunteng.cyria.service;

import java.util.List;
import com.kunteng.cyria.domain.Dashboard;

public interface DashboardService {
	List<Dashboard> getAllDashboard();
	Dashboard getDashboardById(String id);
	Dashboard addDashboard(Dashboard dashboard);
	Dashboard updateDashboard(String id, Dashboard dashboard);
	void deleteDashboard(String id);
}
