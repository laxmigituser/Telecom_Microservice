package com.pkg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pkg.entity.FriendFamily;

public interface FriendFamilyRepository extends JpaRepository<FriendFamily, Integer>{
	
	List<FriendFamily> findByCustPhoneNo(long phoneNo);

}
