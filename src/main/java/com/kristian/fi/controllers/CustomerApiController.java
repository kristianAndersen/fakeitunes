package com.kristian.fi.controllers;

import com.kristian.fi.dataAcces.CustomerRepository;
import com.kristian.fi.models.Customer;
import com.kristian.fi.models.CustomerGenre;
import com.kristian.fi.models.CustomerHighSpender;
import com.kristian.fi.models.CustomerInCountry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerApiController {

    private CustomerRepository customerRepository = new CustomerRepository();


/**
 * 1. Read all customers in the DB.
 * display: id, firstname lastname, country, PostalCode, phone number , email*/
@RequestMapping(value="/api/customers", method = RequestMethod.GET)
public ArrayList<Customer> getAllCustomers(){
    return customerRepository.getAllCustomers();
}


/**
 * 2. Add new customer to DB.
 * Add: id, firstname lastname, country, PostalCode, phone number , email*/
@RequestMapping(value = "/api/customers", method = RequestMethod.POST)
public Boolean addNewCustomer(@RequestBody Customer customer){
    return customerRepository.addCustomer(customer);
}


/**
 * 3. Update existing customer*/
@RequestMapping(value = "/api/customers/customer/{customerId}", method = RequestMethod.PUT)
public Boolean updateExistingCustomer(@PathVariable String customerId, @RequestBody Customer customer){
    return customerRepository.updateCustomer(customer);
}


/**
 * 4. Return the highest number of customers i each country in descending order*/
@RequestMapping(value="/api/customers/in-country", method = RequestMethod.GET)
public ArrayList<CustomerInCountry> getCustomersinCountry(){
    return customerRepository.getCustomersinCountry();
}


/**
 * 5 Return big spender customers (total in invoice) descending order*/
@RequestMapping(value="/api/customers/highest-spend", method = RequestMethod.GET)
public ArrayList<CustomerHighSpender> getHighestSpender(){
    return customerRepository.getHighestSpender();
}


/**
 * 6. Most popular genre for a customer if tie then both get from tracks/invoice*/
@RequestMapping(value = "/api/customers/customer/{customerId}/favorite/genre", method = RequestMethod.GET)
public ArrayList<CustomerGenre> getCustomerGenre(@PathVariable String customerId){
    return customerRepository.getCustomerGenre(customerId);
}

}
