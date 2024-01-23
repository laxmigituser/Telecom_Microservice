package com.pkg.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.pkg.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}
