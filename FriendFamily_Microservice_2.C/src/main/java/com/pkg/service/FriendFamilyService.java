package com.pkg.service;

import java.util.List;

import com.pkg.dto.FriendFamilyDTO;
import com.pkg.exception.CustomFriendFamilyException;

public interface FriendFamilyService {
	
	public FriendFamilyDTO addFriendFamilyDetail(FriendFamilyDTO dto);
	public FriendFamilyDTO getFriendFamilyDetailById(int id)throws CustomFriendFamilyException;
	public List<FriendFamilyDTO> getFriendFamilyDetailByCustPhone(long phoneNo)throws CustomFriendFamilyException;
}
