package com.pkg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pkg.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer>{
	
	List<Plan> findByPlanName(String planName);
	List<Plan> findByNationalRate(Integer nationalRate);
	List<Plan> findByLocalRate(Integer localRate);
	
}
