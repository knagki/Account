package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDAO;
import dto.CustomerVO;

public class CustomerIndexAfterLogin implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/web/customerLoginForm.jsp";
        String userid = request.getParameter("userid");
        String pwd = request.getParameter("pwd");

        HttpSession session = request.getSession();

        if (session.getAttribute("loginUser") != null) {
            url = "/web/customerIndexAfterLogin.jsp";
        }

        CustomerDAO cDao = CustomerDAO.getInstance();
        int customer_num = cDao.customerCheck(userid, pwd);

        if (customer_num != 0) {
            CustomerVO cVo = cDao.getCustomerInfo(customer_num);

            session.setAttribute("loginUser", cVo);
            url = "/web/customerIndexAfterLogin.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
	}

}
