package com.pkg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkg.dto.PlanDTO;
import com.pkg.exception.CustomPlanException;
import com.pkg.service.PlanService;

import jakarta.validation.Valid;
//import com.pkg.service.PlanService;

@RestController
@RequestMapping("/plan")
public class PlanController {
	
	Logger logger=LoggerFactory.getLogger(PlanController.class);
	
	@Autowired
	private PlanService planService;
	
	@GetMapping(value = "/getplans")
	public List<PlanDTO> getAllPlans(){
		return planService.getAllPlans();
	}
	@PostMapping(value = "/addplan")
	public ResponseEntity<PlanDTO> addPlan(@Valid @RequestBody PlanDTO dto) {
		PlanDTO addPlan = planService.addPlan(dto);
		return new ResponseEntity<>(addPlan,HttpStatus.CREATED);
	}
	@GetMapping(value = "/getplanbyid/{planId}")
	public PlanDTO getPlanById(@PathVariable Integer planId) throws CustomPlanException{
		return planService.getPlanById(planId);
	}
	@GetMapping(value = "/getplanbyname/{planName}")
	public ResponseEntity<List<PlanDTO>> getPlanByName(@PathVariable String planName) throws CustomPlanException{
		List<PlanDTO> planList = planService.getPlanByName(planName);
		return new ResponseEntity<List<PlanDTO>>(planList,HttpStatus.OK);
	}

}
