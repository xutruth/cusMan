package service.impl;

import java.util.List;

import dao.impl.CustomerDao;
import dao.impl.CustomerDaoImpl;
import domain.Customer;
import domain.PageBean;
import domain.QueryInfo;
import domain.QueryResult;

public class BusinessServiceImpl implements BusinessService{

	private CustomerDao dao = new CustomerDaoImpl();

    @Override
    public void addCustomer(Customer c) {
        dao.add(c);
    }

    @Override
    public void updateCustomer(Customer c) {
        dao.update(c);
    }

    @Override
    public void deleteCustomer(String id) {
        dao.delete(id);
    }

    @Override
    public Customer findCustomer(String id) {
        return dao.find(id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return dao.getAll();
    }

	@Override
	public PageBean pageQuery(QueryInfo queryInfo) {
		// 调用dao获取到页面数据
        QueryResult qr = dao.pageQuery(queryInfo.getStartindex(), queryInfo.getPagesize());

        // 根据dao的查询结果，生成页面显示需要的PageBean
        PageBean bean = new PageBean();
        bean.setCurrentpage(queryInfo.getCurrentpage());
        bean.setList(qr.getList());
        bean.setPagesize(queryInfo.getPagesize());
        bean.setTotalrecord(qr.getTotalrecord());

        return bean;
	}
}
