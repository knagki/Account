package dto;

public class CustomerVO {
	private int customer_num;
	private String name;
	private String id;
	private String pw;
	private String phone;
	private String reg_num;
	private String email;
	private String job;

	public int getCustomer_num() {
		return customer_num;
	}

	public void setCustomer_num(int customer_num) {
		this.customer_num = customer_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getReg_num() {
		return reg_num;
	}

	public void setReg_num(String reg_num) {
		this.reg_num = reg_num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "CustomerVO [customer_num=" + customer_num + ", name=" + name + ", id=" + id + ", pw=" + pw + ", phone="
				+ phone + ", reg_num=" + reg_num + ", email=" + email + ", job=" + job + "]";
	}
	
}
