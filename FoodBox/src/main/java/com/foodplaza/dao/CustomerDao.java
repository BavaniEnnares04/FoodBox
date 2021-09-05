package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.model.Customer;

public interface CustomerDao 
{
    boolean addCustomer(Customer c);
    boolean updateCustomer(Customer c);
    boolean deleteCustomer(int custId);
    Customer getCustById(String custEmail);
    Customer getCustById(int custId);
    List<Customer> getAllCustomer();
}
