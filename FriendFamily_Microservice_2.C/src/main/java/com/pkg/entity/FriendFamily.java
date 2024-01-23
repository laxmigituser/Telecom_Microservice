package com.pkg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="friendfamily_table")
public class FriendFamily {
	 
	@Id
	int f_id; 
	@Column(name = "phone_no")
	long phoneNo;
	@Column(name = "friend_and_family")
	String name;
	@Column(name = "cust_phone_no")
	long custPhoneNo;
	
	public int getId() {
		return f_id;
	}
	public void setId(int id) {
		this.f_id = id;
	}
	public long getPhoneNo() {
		return phoneNo;
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
	
	public long getCustPhoneNo() {
		return custPhoneNo;
	}
	public void setCustPhoneNo(long custPhoneNo) {
		this.custPhoneNo = custPhoneNo;
	}
	public FriendFamily() {
		super();
	}
	@Override
	public String toString() {
		return "FriendFamily [f_id=" + f_id + ", phoneNo=" + phoneNo + ", name=" + name + ", customer=" 
				+ custPhoneNo + "]";
	}
	
	

}
