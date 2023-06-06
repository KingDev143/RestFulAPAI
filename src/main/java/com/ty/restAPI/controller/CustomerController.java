package com.ty.restAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.restAPI.Response.ResponseStructure;
import com.ty.restAPI.Service.CustomerService;
import com.ty.restAPI.dto.Customer;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(path = "/persist")
	public ResponseEntity<?> insertCustomer(@RequestBody Customer customer) {

		ResponseStructure<?> responestructure = customerService.insertCustomer(customer);
		return new ResponseEntity<>(responestructure, responestructure.getHttpStatus());
	}

	@GetMapping(path = "/fetchall")
	public ResponseEntity<?> getAll() {
		ResponseStructure<?> responseStructure = customerService.getAll();
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpStatus());
	}

	@GetMapping(path = "getcust/{id}")
	public ResponseEntity<?> getCustById(@PathVariable int id) {

		ResponseStructure<?> responseStructure = customerService.getCustById(id);
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpStatus());
	}

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<?> deleteCustomer (@PathVariable int id)
    {
    	ResponseStructure<?> responseStructure =customerService.deleteCustomer(id);
    	return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
    }
}
