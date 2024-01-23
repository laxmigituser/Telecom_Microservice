package com.pkg.service;

import java.util.List;

import com.pkg.dto.CustomerDTO;
import com.pkg.dto.FriendFamilyDTO;
import com.pkg.exception.CustomCustomerException;

public interface CustomerService {

	public CustomerDTO createCustomer(CustomerDTO customerDTO)throws CustomCustomerException;
	public CustomerDTO addFriend(Long phoneNo,FriendFamilyDTO dto)throws CustomCustomerException;
	public CustomerDTO getCustomerprofile(Long phoneNo) throws CustomCustomerException;

	
	//public boolean login(LoginDTO loginDTO);



}
