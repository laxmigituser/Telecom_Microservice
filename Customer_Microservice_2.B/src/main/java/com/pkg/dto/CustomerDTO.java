package com.pkg.dto;

import java.util.ArrayList;
import java.util.List;
import com.pkg.entity.Customer;
import jakarta.validation.constraints.NotBlank;

public class CustomerDTO {
	
	@NotBlank
	long phoneNo;
	@NotBlank
	String name;
	@NotBlank
	int age;
	@NotBlank
	char gender;
	@NotBlank
	String password;
	@NotBlank
	String address;
	@NotBlank
	Integer plan_id;
	
	PlanDTO planDTO;
	
	List<FriendFamilyDTO> friendAndFamily;

	
	public long getPhoneNo() {
		return phoneNo;
	}
	public Integer getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(Integer plan_id) {
		this.plan_id = plan_id;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public List<FriendFamilyDTO> getFriendAndFamily() {
		return friendAndFamily;
	}
	public void setFriendAndFamily(List<FriendFamilyDTO> friendAndFamily) {
		this.friendAndFamily = friendAndFamily;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public PlanDTO getPlanDTO() {
		return planDTO;
	}
	public void setPlanDTO(PlanDTO plan) {
		this.planDTO = plan;
	}
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerDTO(long phoneNo, String name, int age, char gender, List<FriendFamilyDTO> friendAndFamily, String password,
			String address,PlanDTO plan,Integer plan_id ) {
		super();
		this.phoneNo = phoneNo;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.friendAndFamily = friendAndFamily;
		this.password = password;
		this.address = address;
		this.planDTO = plan;
		this.plan_id=plan_id;
	}
	@Override
	public String toString() {
		return "CustomerDTO [phoneNo=" + phoneNo + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", friendAndFamily=" + friendAndFamily + ", password=" + password + ", address=" + address
				+ ", plan=" + planDTO + "]";
	}
	//convert entity to DTO
	public static CustomerDTO entityToDTO(Customer cust) {
		CustomerDTO dto=new CustomerDTO();
		dto.setAge(cust.getAge());
		dto.setGender(cust.getGender());
		dto.setName(cust.getName());
		dto.setPhoneNo(cust.getPhoneNo());
		dto.setAddress(cust.getAddress());
		dto.setPassword(cust.getPassword());
		dto.setPlan_id(cust.getPlan_id());
//		PlanDTO planDTO=PlanDTO.entityToDTO(cust.getPlan());
//		dto.setPlanDTO(planDTO);
		
//		List<FriendFamily> friendlist = cust.getList();
//		List<FriendFamilyDTO> friendsdtolist=new ArrayList<>();
//		for(FriendFamily f:friendlist) {
//			friendsdtolist.add(FriendFamilyDTO.entityToDTO(f));
//		}
//		dto.setFriendAndFamily(friendsdtolist);
		
		return dto;
	}
	
	//convert dto to entity
	public static Customer dtotoentity(CustomerDTO dto) {
		Customer customer=new Customer();
		customer.setAddress(dto.getAddress());
		customer.setAge(dto.getAge());
		customer.setGender(dto.getGender());
		customer.setName(dto.getName());
		customer.setPassword(dto.getPassword());
		customer.setPhoneNo(dto.getPhoneNo());
		customer.setPlan_id(dto.getPlan_id());
		//customer.setPlan(PlanDTO.dtoToEntity(dto.getPlanDTO()));
		return customer;
	}
	
	
	
}
