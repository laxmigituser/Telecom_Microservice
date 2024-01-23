package com.pkg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.pkg.dto.FriendFamilyDTO;
import com.pkg.entity.FriendFamily;
import com.pkg.exception.CustomFriendFamilyException;
import com.pkg.repo.FriendFamilyRepository;
@Service
public class FriendFamilyServiceImpl implements FriendFamilyService{

	@Autowired
	private FriendFamilyRepository friendFamilyRepository;
	
	@Override
	public FriendFamilyDTO addFriendFamilyDetail(FriendFamilyDTO dto) {
		FriendFamily savedEntity = this.friendFamilyRepository.save(FriendFamilyDTO.dtoToEntity(dto));
		return FriendFamilyDTO.entityToDTO(savedEntity);
	}

	@Override
	public FriendFamilyDTO getFriendFamilyDetailById(int id) throws CustomFriendFamilyException {
		FriendFamily findById = this.friendFamilyRepository.findById(id).orElseThrow(() -> new CustomFriendFamilyException("NO CUSTOMER FOUND!!!"));
		return FriendFamilyDTO.entityToDTO(findById);
	}

	@Override
	public List<FriendFamilyDTO> getFriendFamilyDetailByCustPhone(long phoneNo) throws CustomFriendFamilyException {
		List<FriendFamily> list = this.friendFamilyRepository.findByCustPhoneNo(phoneNo);
		if(list.isEmpty()) {
			throw new CustomFriendFamilyException("NO FRIENDFAMILY DETAIL FOUND!!!");
		}
		List<FriendFamilyDTO> dtoList=new ArrayList<>();
		list.forEach(s->{
			FriendFamilyDTO entityToDTO = FriendFamilyDTO.entityToDTO(s);
			dtoList.add(entityToDTO);
		});
		return dtoList;
	}

}
