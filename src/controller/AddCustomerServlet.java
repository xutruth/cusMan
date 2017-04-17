package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Customer;
import service.impl.BusinessService;
import service.impl.BusinessServiceImpl;
import utils.Globals;
import utils.WebUtils;


/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("genders", Globals.genders);
        request.setAttribute("preferences", Globals.preferences);
        request.setAttribute("types", Globals.types);
     // 跳转到一个视图 
        request.getRequestDispatcher("/WEB-INF/jsp/addcustomer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            request.setCharacterEncoding("UTF-8");
            // 把表单数据封装到customer对象中
            Customer c = WebUtils.request2Bean(request, Customer.class);
            c.setId(WebUtils.generateID());

            BusinessService service = new BusinessServiceImpl();
            service.addCustomer(c);

            request.setAttribute("message", "添加成功！！！");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "添加失败！！！");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);

    }


}
