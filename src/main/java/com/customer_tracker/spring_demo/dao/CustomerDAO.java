package com.customer_tracker.spring_demo.dao;

import com.customer_tracker.spring_demo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

}
