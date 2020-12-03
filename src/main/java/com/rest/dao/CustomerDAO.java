package com.rest.dao;

import java.util.List;

import com.rest.service.Customer;

public interface CustomerDAO {
	    public void save(Customer e);
	    public void update(Customer e);
	    public void delete(Customer e);
	    public List<Customer> list();
}
