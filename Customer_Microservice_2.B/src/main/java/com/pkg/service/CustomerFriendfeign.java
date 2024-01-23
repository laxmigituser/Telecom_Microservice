package com.pkg.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pkg.dto.FriendFamilyDTO;
import com.pkg.dto.PlanDTO;

@FeignClient(name="FRIENDFAMILY-SERVICE",url="http://localhost:8084/")
public interface CustomerFriendfeign {
	
	@RequestMapping("friendfamilyservice/friendfamily/getfriendfamilybycustphone/{phoneNo}")
	public List<FriendFamilyDTO> getFriendInfoByPhoneNo(@PathVariable long phoneNo);

}
