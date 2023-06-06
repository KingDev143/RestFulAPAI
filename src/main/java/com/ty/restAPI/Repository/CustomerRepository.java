package com.ty.restAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.restAPI.dto.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> 
{

}
