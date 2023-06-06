package com.ty.restAPI.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.restAPI.Exception.CustomerIdNotFoundException;
import com.ty.restAPI.dto.Customer;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer insertCustomer(Customer customer) {

		return customerRepository.save(customer);
	}

	public List<Customer> getAll()
	{

		 List<Customer> findAll = customerRepository.findAll();
		 if(findAll.isEmpty())
		 {
				throw new CustomerIdNotFoundException("Customer ID is not available");

		 }
		 return findAll;
		 
	}

	public Optional<Customer> getCustById(int id) {
		Optional<Customer> findById = customerRepository.findById(id);
		if(findById.isPresent())
		{
			return findById;
		}
		throw new CustomerIdNotFoundException("Customer ID is not available");

		
     }
	
	public Customer deleteByID(int id)
	{
		Optional<Customer> findById = customerRepository.findById(id);
		if(findById.isPresent())
		{
			customerRepository.deleteById(id);
			return findById.get();
		 }
		throw new CustomerIdNotFoundException("Customer ID is not available");
	}

	

}
