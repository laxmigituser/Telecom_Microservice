package com.pkg.dto;

import org.springframework.beans.factory.annotation.Value;

import com.pkg.entity.Plan;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PlanDTO {
	
	@Min(value = 100,message = "MINIMUM IS 100")
	@Max(value = 199,message = "MAX IS 199")
	Integer planId;
	@NotNull(message = "PLEASE PROVIDE PLAN NAME")
	@Pattern(regexp = "(yearly|quarterly|monthly)",message = "regex not matching")
	String planName;
	//@NotBlank(message = "PLEASE PROVIDE NATIONAL RATE")
	Integer nationalRate;
	//@NotBlank(message = "PLEASE PROVIDE LOCAL RATE")
	Integer localRate;
	
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public Integer getNationalRate() {
		return nationalRate;
	}
	public void setNationalRate(Integer nationalRate) {
		this.nationalRate = nationalRate;
	}
	public Integer getLocalRate() {
		return localRate;
	}
	public void setLocalRate(Integer localRate) {
		this.localRate = localRate;
	}
	public PlanDTO() {
		super();
	}
	public PlanDTO(Integer planId, String planname, Integer nationalRate, Integer localRate) {
		super();
		this.planId = planId;
		this.planName = planname;
		this.nationalRate = nationalRate;
		this.localRate = localRate;
	}
	@Override
	public String toString() {
		return "PlanDTO [planId=" + planId + ", planName=" + planName + ", nationalRate=" + nationalRate
				+ ", localRate=" + localRate + "]";
	}
	//convert entity to DTO
	public static PlanDTO entityToDTO(Plan plan) {
		PlanDTO dto=new PlanDTO();
		dto.setLocalRate(plan.getLocalRate());
		dto.setNationalRate(plan.getNationalRate());
		dto.setPlanId(plan.getPlanId());
		dto.setPlanName(plan.getPlanName());
		return dto;
	}
	//convert DTO to entity 
	public static Plan dtoToEntity(PlanDTO dto) {
		Plan plan=new Plan();
		plan.setLocalRate(dto.getLocalRate());
		plan.setNationalRate(dto.getNationalRate());
		plan.setPlanId(dto.getPlanId());
		plan.setPlanName(dto.getPlanName());
		return plan;
	}
}
