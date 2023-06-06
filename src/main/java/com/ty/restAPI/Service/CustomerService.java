package com.ty.restAPI.Service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.restAPI.Repository.CustomerDao;
import com.ty.restAPI.Response.ResponseStructure;
import com.ty.restAPI.dto.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public ResponseStructure<?> insertCustomer(Customer customer) {

		Customer cust = customerDao.insertCustomer(customer);

		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		responseStructure.setData(cust);
		responseStructure.setHttpStatus(HttpStatus.CREATED);
		return responseStructure;
	}

	public ResponseStructure<?> getAll() {
		List<Customer> customers = customerDao.getAll();
		ResponseStructure<List<Customer>> responseStructure = new ResponseStructure<>();
		responseStructure.setData(customers);
		responseStructure.setHttpStatus(HttpStatus.OK);
		return responseStructure;
	}

	public ResponseStructure<?> getCustById(int id) {

		Optional<Customer> findCusId = customerDao.getCustById(id);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		Customer customer = findCusId.get();
		responseStructure.setData(customer);
		responseStructure.setHttpStatus(HttpStatus.OK);
		return responseStructure;

	}

	public ResponseStructure<?> deleteCustomer(int id) {
		Customer customer = customerDao.deleteByID(id);

		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		responseStructure.setData(customer);
		responseStructure.setHttpStatus(HttpStatus.OK);
		return responseStructure;
	}

}
