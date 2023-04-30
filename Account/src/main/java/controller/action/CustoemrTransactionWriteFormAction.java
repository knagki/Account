package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dto.AccountVO;
import dto.CustomerVO;

public class CustoemrTransactionWriteFormAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String url = "/web/customerTransactionWriteForm.jsp";
		
		HttpSession session = request.getSession();
		AccountDAO aDao = AccountDAO.getInstance();
		
		CustomerVO cVo = (CustomerVO) session.getAttribute("loginUser");
		AccountVO aVo = aDao.selectAllAccount(cVo.getCustomer_num());
		
		request.setAttribute("customer", cVo);
		request.setAttribute("account", aVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
