package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dao.TransactionDAO;
import dto.AccountVO;
import dto.CustomerVO;
import dto.TransactionVO;

public class CustoemrTransactionAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String url = "/web/customerTransaction.jsp";
		
		TransactionDAO tDao = TransactionDAO.getInstance();
		HttpSession session = request.getSession();
		AccountDAO aDao = AccountDAO.getInstance();
		
		CustomerVO cVo = (CustomerVO) session.getAttribute("loginUser");
		AccountVO aVo = aDao.selectAllAccount(cVo.getCustomer_num());
		List<TransactionVO> transaction = tDao.selectAlltransaction(aVo.getAccount_num());

		request.setAttribute("customer", cVo);
		request.setAttribute("transaction", transaction);
		request.setAttribute("account", aVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
