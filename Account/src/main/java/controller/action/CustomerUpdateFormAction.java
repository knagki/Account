package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import dto.CustomerVO;


public class CustomerUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/customer/customerUpdateForm.jsp";
		int customer_num = Integer.parseInt(request.getParameter("customer_num"));
		
		CustomerDAO cDao = CustomerDAO.getInstance();
		CustomerVO cVo = cDao.getCustomerInfo(customer_num);
		request.setAttribute("customer", cVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		

	}

}
