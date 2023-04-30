package dto;

public class TransactionVO {
	private int transaction_num;
	private String sender_account;
	private String receiver_account;
	private int amount;
	private String send_context;
	private String transaction_date;
	private String transaction_type;

	public int getTransaction_num() {
		return transaction_num;
	}

	public void setTransaction_num(int transaction_num) {
		this.transaction_num = transaction_num;
	}

	public String getSender_account() {
		return sender_account;
	}

	public void setSender_account(String sender_account) {
		this.sender_account = sender_account;
	}

	public String getReceiver_account() {
		return receiver_account;
	}

	public void setReceiver_account(String receiver_account) {
		this.receiver_account = receiver_account;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSend_context() {
		return send_context;
	}

	public void setSend_context(String send_context) {
		this.send_context = send_context;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
}
