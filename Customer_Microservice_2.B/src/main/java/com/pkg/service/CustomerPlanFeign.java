package com.pkg.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pkg.dto.PlanDTO;

@FeignClient(name="PLAN-SERVICE",url="http://localhost:8084/")
//added url of gateway so that all requests are passed through gateway
public interface CustomerPlanFeign {
	
	@RequestMapping("planservice/plan/getplanbyid/{planId}")
	public PlanDTO getPlanInfoById(@PathVariable int planId);
	
	
}
