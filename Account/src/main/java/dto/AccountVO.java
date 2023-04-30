package dto;

public class AccountVO {
	private String account_num;
	private int balance;
	private int customer_num;

	public String getAccount_num() {
		return account_num;
	}

	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getCustomer_num() {
		return customer_num;
	}

	public void setCustomer_num(int customer_num) {
		this.customer_num = customer_num;
	}

	@Override
	public String toString() {
		return "AccountVO [account_num=" + account_num + ", balance=" + balance + ", customer_num=" + customer_num
				+ "]";
	}
	
	

}
