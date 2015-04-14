package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
/**
 * カスタマのサービスクラス
 * @author nagase
 *
 */
@Service //サービスクラスであることを示す。Componentと意味は変わらない
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer save(Customer customer){
		return customerRepository.save(customer);
	}
	/*
	 * すべてを返す
	 */
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
}
