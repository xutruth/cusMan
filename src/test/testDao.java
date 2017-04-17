package test;

import java.util.Date;

import dao.impl.CustomerDaoImpl;
import domain.Customer;

public class testDao {
	public static void main(String[] args) {
		Customer c  = new Customer();
		c.setBirthday(new Date());
		c.setCellphone("dddddddddd");
		c.setDescription("daaaaaaaaaa");
		c.setEmail("eeeeeeeeeee");
		c.setGender("d");
		c.setId("d");
		c.setName("dd");
		c.setPreference("ddd");
		c.setType("dd");
		CustomerDaoImpl dao = new CustomerDaoImpl();
		//dao.add(c);
		dao.find("d");
		System.out.println(dao.find("d").toString());
	}
}
