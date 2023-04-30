package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dao.CustomerDAO;
import dto.AccountVO;
import dto.CustomerVO;

public class CustomerCreateAccountFormAction implements Action {
	boolean isAccountExist;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/web/customerCreateAccount.jsp";

		HttpSession session = request.getSession();
		CustomerVO cVo = (CustomerVO) session.getAttribute("loginUser");
		cVo = customerVOUpdate(cVo, request, response);

		AccountDAO aDao = AccountDAO.getInstance();
		AccountVO aVo = aDao.createAccountVO(cVo.getCustomer_num());

		CustomerDAO cDao = CustomerDAO.getInstance();

		if (aVo != null) {
			isAccountExist = aDao.isAccountExist(aVo.getAccount_num());

			if (isAccountExist) {
				request.setAttribute("message", "NO");
				url = "/web/customerIndexAfterLogin.jsp";
			} else {
				cDao.updateCustomerInfo(cVo);
				aDao.insertAccountInfo(aVo);
				request.setAttribute("message", "OK");
				url = "/web/customerMyPage.jsp";
			}
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	private CustomerVO customerVOUpdate(CustomerVO cVo, HttpServletRequest request, HttpServletResponse response) {
		String reg_num = request.getParameter("reg_num1") + request.getParameter("reg_num2");
		String email = request.getParameter("email");
		String job = request.getParameter("job-select");

		cVo.setEmail(email);
		cVo.setReg_num(reg_num);
		cVo.setJob(job);

		return cVo;
	}
}
