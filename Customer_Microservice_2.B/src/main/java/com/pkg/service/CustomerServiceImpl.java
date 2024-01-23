package com.pkg.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pkg.dto.CustomerDTO;
import com.pkg.dto.FriendFamilyDTO;
import com.pkg.dto.PlanDTO;
import com.pkg.entity.Customer;
import com.pkg.exception.CustomCustomerException;
import com.pkg.repo.CustomerRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.vavr.concurrent.Future;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@Service
public class CustomerServiceImpl implements CustomerService{

	Logger logger=LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CustomerFriendfeign customerFriendfeign;
	
	@Autowired
	private CustomerPlanFeign customerPlanFeign;
	
	@Override
	public CustomerDTO createCustomer(CustomerDTO customerDTO) throws CustomCustomerException {
		Customer customer=CustomerDTO.dtotoentity(customerDTO);
		PlanDTO plandto=new RestTemplate().getForObject("http://localhost:8081/planservice/plan/getplanbyid/"+customerDTO.getPlan_id(), PlanDTO.class);
		Customer savedCustomer = customerRepository.save(customer);
		System.out.println("printing customer :"+savedCustomer);
		CustomerDTO savedCustomerDTO = CustomerDTO.entityToDTO(savedCustomer);
		savedCustomerDTO.setPlanDTO(plandto);
		return savedCustomerDTO;
	}

	@Override
	public CustomerDTO addFriend(Long phoneNo, FriendFamilyDTO dto) throws CustomCustomerException {
		Customer cust = this.customerRepository.findById(phoneNo).orElseThrow(()-> new CustomCustomerException("CUSTOMER NOT FOUND!!!"));
		if(!phoneNo.equals(dto.getPhoneNo())) {
			throw new CustomCustomerException("INCORRECT PHONE NUMBER!!!");
		}
		//add friend API
		ResponseEntity<FriendFamilyDTO> createdFriend = new RestTemplate().postForEntity("http://localhost:8083/friendfamilyservice/friendfamily/addfriendfamily", dto, FriendFamilyDTO.class);
		CustomerDTO custDTO=CustomerDTO.entityToDTO(cust);
		//get friend API
		List<FriendFamilyDTO> custDTOList = new RestTemplate().getForObject("http://localhost:8083/friendfamilyservice/friendfamily/getfriendfamilybycustphone/"+phoneNo, List.class);
		//custDTOList.add(createdFriend.getBody()); Cz latest one already added 
		//get plan API
		PlanDTO plandto=new RestTemplate().getForObject("http://localhost:8081/planservice/plan/getplanbyid/"+custDTO.getPlan_id(), PlanDTO.class);
		custDTO.setPlanDTO(plandto);
		custDTO.setFriendAndFamily(custDTOList);
		return custDTO;
	}
	
	@Override
	@CircuitBreaker(name="customerservice",fallbackMethod = "getCustomerprofileFallback")
	public CustomerDTO getCustomerprofile(Long phoneNo) throws CustomCustomerException {
		logger.info("*****PROFILE REQUEST METHOD*****");
		//get customer
		Customer customer = customerRepository.findById(phoneNo).orElseThrow(()->new CustomCustomerException("CUSTOMER NOT FOUND !!!"));
		CustomerDTO dto=CustomerDTO.entityToDTO(customer);	
		
		//get plan details using RestTemplate 
		//PlanDTO planDTO = new RestTemplate().getForObject("http://localhost:8081/planservice/plan/getplanbyid/"+dto.getPlan_id(), PlanDTO.class);
		//dto.setPlanDTO(planDTO);
		
		//using discovery client
		/*List<ServiceInstance> planInstances = discoveryClient.getInstances("PLAN-SERVICE");
		if(planInstances!=null && !planInstances.isEmpty()) {
			String planServiceURL = planInstances.get(0).getUri().toString();
			PlanDTO planDTO =  new RestTemplate().getForObject(planServiceURL +"/planservice/plan/getplanbyid/"+dto.getPlan_id(), PlanDTO.class);
			dto.setPlanDTO(planDTO);
		}*/
		
		//get plan detail using feign client
		PlanDTO planDTO = this.customerPlanFeign.getPlanInfoById(dto.getPlan_id());
		dto.setPlanDTO(planDTO);
		try {
		//get friend API
//		List<FriendFamilyDTO> dtoList = new RestTemplate().getForObject("http://localhost:8083/friendfamilyservice/friendfamily/getfriendfamilybycustphone/"+dto.getPhoneNo(), List.class);
//		dto.setFriendAndFamily(dtoList);
		
		//using discovery client
//		List<ServiceInstance> friendInstances = discoveryClient.getInstances("FRIENDFAMILY-SERVICE");
//		if(friendInstances!=null && !friendInstances.isEmpty()) {
//			String friendServiceURL = friendInstances.get(0).getUri().toString();
//			List<FriendFamilyDTO> dtoList = new RestTemplate().getForObject(friendServiceURL +"/friendfamilyservice/friendfamily/getfriendfamilybycustphone/"+dto.getPhoneNo(), List.class);
//			dto.setFriendAndFamily(dtoList);
//		}
			
		//Load balancer
			//List<FriendFamilyDTO> dtoList =  restTemplate.getForObject("http://FRIENDFAMILY-SERVICE/friendfamilyservice/friendfamily/getfriendfamilybycustphone/"+dto.getPhoneNo(), List.class);
			//dto.setFriendAndFamily(dtoList);	
		
			//using feign client
			List<FriendFamilyDTO> dtoList = this.customerFriendfeign.getFriendInfoByPhoneNo(dto.getPhoneNo());
			dto.setFriendAndFamily(dtoList);
		}catch (Exception e) {
			//if no friend detail found for given customer, exception will be thrown 
			//to handle that we are adding null so that exception is handled
			dto.setFriendAndFamily(null);
		}
		
		return dto;
	}
	
	public CustomerDTO getCustomerprofileFallback(Long phoneNo,Throwable throwable) {
		logger.info("*****FALL BACK METHOD*****");
		return new CustomerDTO();
	}


	
	
	
//	@Override
//	public boolean login(LoginDTO loginDTO) {
//		Boolean flag=false;
//		Optional<Customer> customer = customerRepository.findById(loginDTO.getPhoneNo());
//		if(customer.isPresent() && customer.get()!=null && customer.get().getPassword().equals(loginDTO.getPassword())) {
//			flag=true;
//		}
//		return flag;
//	}




	
	
	
		
}
