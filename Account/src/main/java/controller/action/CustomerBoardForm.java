package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.InquiryDAO;
import dto.CustomerVO;
import dto.InquiryVO;

public class CustomerBoardForm implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/web/customerBoard.jsp";
		
		HttpSession session = request.getSession();
		CustomerVO cVo = (CustomerVO)session.getAttribute("loginUser");
		
		InquiryDAO iDao = InquiryDAO.getInstance();
		List<InquiryVO> iVoList = iDao.getInquiryVO(cVo.getCustomer_num());
		
		request.setAttribute("inquiryList", iVoList);
		request.setAttribute("customer", cVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}
