package com.kunteng.cyria.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kunteng.cyria.domain.Dashboard;

public interface DashboardRepository extends MongoRepository<Dashboard, String> {

}
