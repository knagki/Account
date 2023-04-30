package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import dto.CustomerVO;

public class CustoemrJoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/web/customerLoginForm.jsp";
		
		CustomerVO cVo = new CustomerVO();
		cVo.setName(request.getParameter("name"));
		cVo.setId(request.getParameter("id"));
		cVo.setPw(request.getParameter("pswd"));
		cVo.setPhone(request.getParameter("mobile"));
		
		System.out.println(cVo);
		CustomerDAO cDao = CustomerDAO.getInstance();
		cDao.insertCustomerInfo(cVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
