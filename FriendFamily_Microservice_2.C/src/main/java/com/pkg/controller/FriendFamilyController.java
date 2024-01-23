package com.pkg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkg.dto.FriendFamilyDTO;
import com.pkg.exception.CustomFriendFamilyException;
import com.pkg.service.FriendFamilyService;

@RestController
@RequestMapping("/friendfamily")
public class FriendFamilyController {
	
	Logger logger=LoggerFactory.getLogger(FriendFamilyController.class);
	
	@Autowired
	private FriendFamilyService friendFamilyService;
	
	@PostMapping("/addfriendfamily")
	public ResponseEntity<FriendFamilyDTO> addFriendFamilyDetail(@RequestBody FriendFamilyDTO dto){
		FriendFamilyDTO detailDTO = this.friendFamilyService.addFriendFamilyDetail(dto);
		return new ResponseEntity<FriendFamilyDTO>(detailDTO,HttpStatus.CREATED);
	}
	@GetMapping("/getfriendfamilybyid/{id}")
	public ResponseEntity<FriendFamilyDTO> getFriendFamilyDetail(@PathVariable int id) throws CustomFriendFamilyException{
		FriendFamilyDTO detailDTO = this.friendFamilyService.getFriendFamilyDetailById(id);
		return new ResponseEntity<FriendFamilyDTO>(detailDTO,HttpStatus.OK);
	}
	@GetMapping("/getfriendfamilybycustphone/{custPhone}")
	public ResponseEntity<List<FriendFamilyDTO>> getFriendFamilyDetail(@PathVariable long custPhone) throws CustomFriendFamilyException{
		logger.info("*****FRIEND FAMILY API*****");
		
		List<FriendFamilyDTO> detailDTO = this.friendFamilyService.getFriendFamilyDetailByCustPhone(custPhone);
		return new ResponseEntity<List<FriendFamilyDTO>>(detailDTO,HttpStatus.OK);
	}
}
