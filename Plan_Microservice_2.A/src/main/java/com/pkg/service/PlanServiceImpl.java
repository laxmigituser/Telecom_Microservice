package com.pkg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkg.dto.PlanDTO;
import com.pkg.entity.Plan;
import com.pkg.exception.CustomPlanException;
import com.pkg.repo.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService{
	
	@Autowired
	private PlanRepository planRepository;
	
	Logger logger=LoggerFactory.getLogger(PlanService.class);
	
	@Override
	public List<PlanDTO> getAllPlans(){
		List<Plan> allPlans = planRepository.findAll();
		List<PlanDTO> dtoList=new ArrayList<>();
		for(Plan p:allPlans) {
			PlanDTO planDTO=PlanDTO.entityToDTO(p);
			dtoList.add(planDTO);
		}
		return dtoList;
	}

	@Override
	public PlanDTO addPlan(PlanDTO dto) {
		Plan plan = PlanDTO.dtoToEntity(dto);
		System.out.println("printing dto :"+dto);
		Plan savedPlan = planRepository.save(plan);
		return PlanDTO.entityToDTO(savedPlan);
	}

	@Override
	public PlanDTO getPlanById(Integer planId) throws CustomPlanException {
	 Plan plan = planRepository.findById(planId).orElseThrow(() -> new CustomPlanException("PLAN NOT FOUND!!!"));
		return PlanDTO.entityToDTO(plan);
	}

	@Override
	public List<PlanDTO> getPlanByName(String planName) throws CustomPlanException {
		List<Plan> planList = planRepository.findByPlanName(planName);
		if(planList.isEmpty()) {
			throw new CustomPlanException("NO PLANS FOUND!!!");
		}
		List<PlanDTO> dtoList=new ArrayList<>();
		 planList.forEach(s->{
			PlanDTO dto=PlanDTO.entityToDTO(s);
			dtoList.add(dto);
		});
		return dtoList;
	}
	
}
