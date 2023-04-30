package dao;

import java.sql.*;
import java.util.*;

import Util.DBManager;
import dto.InquiryVO;

public class InquiryDAO {
	private InquiryDAO() {
	}

	private static InquiryDAO instance = new InquiryDAO();

	public static InquiryDAO getInstance() {
		return instance;
	}

	public List<InquiryVO> getInquiryVO(int customer_num) {
		String sql = "select * from inquiry where customer_num = ?";
		List<InquiryVO> list = new ArrayList<InquiryVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customer_num);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				InquiryVO iVo = new InquiryVO();

				iVo.setCustomer_num(rs.getInt("customer_num"));
				iVo.setInquiry_content(rs.getString("inquiry_content"));
				iVo.setInquiry_date(rs.getTimestamp("inquiry_date"));
				iVo.setInquiry_num(rs.getString("inquiry_num"));

				list.add(iVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

}