package dao;

import java.sql.*;
import java.util.Random;

import Util.DBManager;
import dto.AccountVO;

public class AccountDAO {

	private AccountDAO() {
	}

	private static AccountDAO instance = new AccountDAO();

	public static AccountDAO getInstance() {
		return instance;
	}

	// 문수

	public AccountVO createAccountVO(int customer_num) { // 계좌번호 랜덤 생성 메서드
		String sql = "select * from account where customer_num = ?";
		AccountVO aVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customer_num);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				aVo = new AccountVO();
				
				// 2222로 시작하는 10자리 랜덤 숫자를 생성합니다.
				String accountNumber = "2222" + String.format("%010d", new Random().nextInt(1000000000));
				aVo.setAccount_num(accountNumber);
				aVo.setBalance(1000000);
				aVo.setCustomer_num(customer_num);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return aVo;
	}

	// 1인당 1개의 계좌만 개설 가능 개설 여부 확인
	public boolean isAccountExist(String account_num) {
		String sql = "select * from account where account_num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isAccountExist = false;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				isAccountExist = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return isAccountExist;
	}

	// 계좌 정보 DB로 보내는 메서드
	public void insertAccountInfo(AccountVO aVo) {
		String sql = "insert into account values(?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aVo.getAccount_num());
			pstmt.setInt(2, aVo.getBalance());
			pstmt.setInt(3, aVo.getCustomer_num());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public AccountVO selectAllAccount(int customer_num) {
		String sql = "select * from account where customer_num = ?";
		AccountVO aVo = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, customer_num);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					aVo = new AccountVO();
					aVo.setAccount_num(rs.getString("account_num"));
					aVo.setBalance(rs.getInt("balance"));
					aVo.setCustomer_num(rs.getInt("customer_num"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aVo;
	}
}
