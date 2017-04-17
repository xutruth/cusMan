package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Customer;
import domain.PageBean;
import domain.QueryInfo;
import service.impl.BusinessService;
import service.impl.BusinessServiceImpl;
import utils.WebUtils;

/**
 * Servlet implementation class ListCustomerServlet
 */
@WebServlet("/ListCustomerServlet")
public class ListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
	        /*    BusinessService service = new BusinessServiceImpl();
	            List<Customer> list = service.getAllCustomer();
	            request.setAttribute("list", list);
	            request.getRequestDispatcher("/WEB-INF/jsp/listcustomer.jsp").forward(request, response);*/
			 /*
	             * 如果用户带查询条件过来，就将查询条件封装到QueryInfo里面去。
	             * 如果用户没带带查询条件过来，也即第一次查询，也要生成一个QueryInfo，使用默认查询条件，即从第1页查看5条记录。
	             */
	            QueryInfo info = WebUtils.request2Bean(request, QueryInfo.class);
	            BusinessService service = new BusinessServiceImpl();
	            PageBean pagebean =  service.pageQuery(info);

	            request.setAttribute("pagebean", pagebean);
	            request.getRequestDispatcher("/WEB-INF/jsp/listcustomer.jsp").forward(request, response);
	        
		 } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("message", "查看客户失败！！！");
	            request.getRequestDispatcher("/message.jsp").forward(request, response);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
