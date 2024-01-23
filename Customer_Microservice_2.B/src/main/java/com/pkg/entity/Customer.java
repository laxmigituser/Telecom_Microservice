package com.pkg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_table")
public class Customer {

	@Id
	@Column(name="phone_no",nullable = false)
	Long phoneNo;
	@Column(nullable= false,length = 50)
	String name;
	@Column(nullable = false)
	Integer age;
	@Column(length = 50,nullable = false)
	String address;
	@Column(length = 50,nullable = false)
	String password;
	@Column(length = 1,nullable = false)
	char gender;	
	@Column(nullable = false)
	Integer plan_id;
	
	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [phoneNo=" + phoneNo + ", name=" + name + ", age=" + age + ", address=" + address
				+ ", password=" + password + ", gender=" + gender + ", plan_id=" + plan_id +  "]";
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Integer getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(Integer plan_id) {
		this.plan_id = plan_id;
	}

	
	
	
}
