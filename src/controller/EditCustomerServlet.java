package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.mysql.jdbc.ReplicationMySQLConnection;

import domain.Customer;
import service.impl.BusinessService;
import service.impl.BusinessServiceImpl;
import utils.Globals;
import utils.WebUtils;

/**
 * Servlet implementation class EditCustomerServlet
 */
@WebServlet("/EditCustomerServlet")
public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
        BusinessService service = new BusinessServiceImpl();
        Customer c = service.findCustomer(id);

        request.setAttribute("genders", Globals.genders);
        request.setAttribute("preferences", Globals.preferences);
        request.setAttribute("types", Globals.types);

        request.setAttribute("c", c);
        request.getRequestDispatcher("/WEB-INF/jsp/editcustomer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
            // 把填写后的表单的修改信息封装到customer对象中
            Customer c = WebUtils.request2Bean(request, Customer.class);
            BusinessService service = new BusinessServiceImpl();
            service.updateCustomer(c);

            request.setAttribute("message", "更新成功！！！");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "更新失败！！！");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

}
