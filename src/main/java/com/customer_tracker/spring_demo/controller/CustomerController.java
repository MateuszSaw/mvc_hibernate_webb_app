package com.customer_tracker.spring_demo.controller;


import com.customer_tracker.spring_demo.dao.CustomerDAO;
import com.customer_tracker.spring_demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //inject the customer dao
    @Autowired
    private CustomerDAO customerDAO;

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {

	    //get customer from dao
        List<Customer> theCustomers = customerDAO.getCustomers();

        //add the customrs to the model
	    theModel.addAttribute("customers", theCustomers);

	    return "list-customers";
	}

}










