package com.pkg.service;

import java.util.List;

import com.pkg.dto.PlanDTO;
import com.pkg.exception.CustomPlanException;

public interface PlanService {
	
	public PlanDTO addPlan(PlanDTO dto);
	public PlanDTO getPlanById(Integer planId)throws CustomPlanException;
	public List<PlanDTO> getPlanByName(String planName)throws CustomPlanException;
	public List<PlanDTO> getAllPlans();
}
