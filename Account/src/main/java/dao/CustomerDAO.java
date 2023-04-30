package dao;

import java.sql.*;

import Util.DBManager;
import dto.CustomerVO;

public class CustomerDAO {
	private CustomerDAO() {}

	private static CustomerDAO instance = new CustomerDAO();

	public static CustomerDAO getInstance() {
		return instance;
	}

	// 유저 회원가입 메서드
		public void insertCustomerInfo(CustomerVO cVo) {
			String sql = "insert into customer (customer_num, name, id, pw, phone) values (customer_seq.nextval, ?, ?, ?, ?)";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cVo.getName());
				pstmt.setString(2, cVo.getId());
				pstmt.setString(3, cVo.getPw());
				pstmt.setString(4, cVo.getPhone());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		
	// 계좌 개설 후 고객정보 update 하는 메서드
	public int addCustomerInfo(CustomerVO cVo) { 
		int result = -1;
		String sql = "update customer set reg_num = ?, email = ?, job = ? where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cVo.getReg_num());
			pstmt.setString(2, cVo.getEmail());
			pstmt.setString(3, cVo.getJob());
			pstmt.setString(4, cVo.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	// 유저 로그인시 id, pw확인하는 메서드
	public int customerCheck(String id, String pw) {
		String sql = "select * from customer where id = ?";
		int customer_num = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString("pw")!= null && rs.getString("pw").equals(pw)) {
					customer_num = rs.getInt("customer_num");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return customer_num;
	}

	// 유저 정보 얻어오는 메서드
	public CustomerVO getCustomerInfo(int customer_num) {
		CustomerVO cVo = null;
		String sql = "select * from customer where customer_num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		 try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customer_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cVo = new CustomerVO();
				cVo.setCustomer_num(rs.getInt("customer_num"));
				cVo.setEmail(rs.getString("email"));
				cVo.setId(rs.getString("id"));
				cVo.setJob(rs.getString("job"));
				cVo.setReg_num(rs.getString("reg_num"));
				cVo.setName(rs.getString("name"));
				cVo.setPhone(rs.getString("phone"));
				cVo.setPw(rs.getString("pw"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		 
		return cVo;
	}
	
	// 계좌 개설시 유저정보 업데이트 메서드
	public void updateCustomerInfo(CustomerVO cVo) {
		String sql = "update customer set reg_num=?, email=?, job=? where customer_num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cVo.getReg_num());
			pstmt.setString(2, cVo.getEmail());
			pstmt.setString(3, cVo.getJob());
			pstmt.setInt(4, cVo.getCustomer_num());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

}
