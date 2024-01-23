package com.pkg.dto;



import jakarta.validation.constraints.NotBlank;

public class FriendFamilyDTO {
	@NotBlank
	int f_id;
	@NotBlank
	long phoneNo;
	@NotBlank
	String name;
	@NotBlank
	long custPhoneNo;

	
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
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
	public FriendFamilyDTO() {
		super();
	}
	
	public FriendFamilyDTO(int f_id, long phoneNo, String name, long custPhoneNo) {
		super();
		this.f_id = f_id;
		this.phoneNo = phoneNo;
		this.name = name;
		this.custPhoneNo = custPhoneNo;
	}
	
	@Override
	public String toString() {
		return "FriendFamilyDTO [f_id=" + f_id + ", phoneNo=" + phoneNo + ", name=" + name + ", custPhoneNo="
				+ custPhoneNo + "]";
	}
//	//convert DTO to Entity
//	public static FriendFamily dtoToEntity(FriendFamilyDTO dto) {
//		FriendFamily friendFamily=new FriendFamily();
//		friendFamily.setPhoneNo(dto.getPhoneNo());
//		friendFamily.setName(dto.getName());
//		friendFamily.setId(dto.getF_id());
//		friendFamily.setCustPhoneNo(dto.getCustPhoneNo());
//		return friendFamily;
//	}
//	public static FriendFamilyDTO entityToDTO(FriendFamily entity) {
//		FriendFamilyDTO dto=new FriendFamilyDTO();
//		dto.setName(entity.getName());
//		dto.setPhoneNo(entity.getPhoneNo());
//		dto.setF_id(entity.getId());
//		dto.setCustPhoneNo(entity.getCustPhoneNo());
//		return dto;
//	}
	
}
