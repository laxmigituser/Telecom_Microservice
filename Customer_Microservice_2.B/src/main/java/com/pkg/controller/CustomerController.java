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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkg.dto.CustomerDTO;
import com.pkg.dto.FriendFamilyDTO;
import com.pkg.exception.CustomCustomerException;
import com.pkg.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	Logger logger=LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	@PostMapping("/createcustomer")
	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) throws CustomCustomerException {
		CustomerDTO createdCustomer = customerService.createCustomer(customerDTO);
		return new ResponseEntity<CustomerDTO>(createdCustomer,HttpStatus.CREATED);
	}
	@PostMapping("/addfriendfamily/{phoneNo}")
	public ResponseEntity<CustomerDTO> addFriendFamily(@PathVariable long phoneNo, @RequestBody FriendFamilyDTO friendFamilyDTO) throws CustomCustomerException {
		CustomerDTO createdCustomer = customerService.addFriend(phoneNo,friendFamilyDTO);
		return new ResponseEntity<CustomerDTO>(createdCustomer,HttpStatus.CREATED);
	}
	@GetMapping("/getcustomer/{phoneNo}")
	public ResponseEntity<CustomerDTO> getCustomerDetail(@PathVariable long phoneNo) throws CustomCustomerException {
		CustomerDTO custDetail = customerService.getCustomerprofile(phoneNo);
		return new ResponseEntity<CustomerDTO>(custDetail,HttpStatus.ACCEPTED);
	}
//	@PutMapping("/addfriends/{phoneNo}")
//	public ResponseEntity<CustomerDTO> addfriends(@PathVariable Long phoneNo, @RequestBody FriendFamilyDTO friendFamilyDTO) throws CustomTelecomException {
//		CustomerDTO savefriend = customerService.savefriend(phoneNo, friendFamilyDTO);
//		System.out.println("printing :"+friendFamilyDTO);
//		return new ResponseEntity<CustomerDTO>(savefriend,HttpStatus.ACCEPTED);
//	}


}
