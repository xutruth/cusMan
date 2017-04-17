package dao.impl;

import java.util.List;

import domain.Customer;
import domain.QueryResult;

public interface CustomerDao {

    void add(Customer c);

    void update(Customer c);

    void delete(String id);

    Customer find(String id);

    List<Customer> getAll();
 // 获取到页面数据和页面大小
    QueryResult pageQuery(int startindex, int pagesize);
}