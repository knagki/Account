package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Util.DBManager;
import dto.TransactionVO;

public class TransactionDAO {
	private TransactionDAO() {

	}

	private static TransactionDAO instance = new TransactionDAO();

	public static TransactionDAO getInstance() {
		return instance;
	}

	public List<TransactionVO> selectAlltransaction(String account_num) {
		String sql = "select * from transaction where receiver_account = ? or sender_account= ? order by transaction_date desc";
		// 1: account.customer_num 2 : transaction.sender_account
		List<TransactionVO> list = new ArrayList<TransactionVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account_num);
			pstmt.setString(2, account_num);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				TransactionVO tVo = new TransactionVO();

				tVo.setTransaction_num(rs.getInt("transaction_num"));
				tVo.setSender_account(rs.getString("sender_account"));
				tVo.setReceiver_account(rs.getString("receiver_account"));
				tVo.setAmount(rs.getInt("amount"));
				tVo.setSend_context(rs.getString("send_context"));
//				tVo.setTransaction_date(rs.getTimestamp("transaction_date").toLocalDateTime());
//				Timestamp timestamp = rs.getTimestamp("transaction_date");
//				LocalDateTime localDateTime = timestamp.toLocalDateTime();
//				tVo.setTransaction_date(localDateTime);
				tVo.setTransaction_date(rs.getString("transaction_date"));
				tVo.setTransaction_type(rs.getString("transaction_type"));
				list.add(tVo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 본인 계좌 번호 고정, 이름 고정, 본인 총금액 고정, 받는사람 계좌 입력, 내통장 매모 입력, 이체 금액 입력 각 고객dao, 계좌dao list를 이용해서 이름값, 총액만 불어오기
	// 일단은 본인 계좌번호도 고정으로 설정해 둠
	public void insertTransction(TransactionVO tVo, String sender_account) {
		String sql = "insert into transaction(transaction_num, sender_account, receiver_account, amount, send_context, transaction_date, transaction_type) "
				+ "values(transaction_seq.nextval, ?, ?, ?, ?, SYSTIMESTAMP, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, sender_account);
			pstmt.setString(2, tVo.getReceiver_account());
			pstmt.setInt(3, tVo.getAmount());
			pstmt.setString(4, tVo.getSend_context());
			pstmt.setString(5, tVo.getTransaction_type());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
