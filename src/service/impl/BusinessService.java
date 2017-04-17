package service.impl;

import java.util.List;

import domain.Customer;
import domain.PageBean;
import domain.QueryInfo;

public interface BusinessService {
	void addCustomer(Customer c);

    void updateCustomer(Customer c);

    void deleteCustomer(String id);

    Customer findCustomer(String id);

    List<Customer> getAllCustomer();
    
    PageBean pageQuery(QueryInfo queryInfo);
}
