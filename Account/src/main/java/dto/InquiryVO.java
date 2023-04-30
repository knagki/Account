package dto;

import java.util.Date;

public class InquiryVO {
	private String inquiry_num;
	private int customer_num;
	private Date inquiry_date;
	private String inquiry_content;

	public String getInquiry_num() {
		return inquiry_num;
	}

	public void setInquiry_num(String inquiry_num) {
		this.inquiry_num = inquiry_num;
	}

	public int getCustomer_num() {
		return customer_num;
	}

	public void setCustomer_num(int customer_num) {
		this.customer_num = customer_num;
	}

	public Date getInquiry_date() {
		return inquiry_date;
	}

	public void setInquiry_date(Date inquiry_date) {
		this.inquiry_date = inquiry_date;
	}

	public String getInquiry_content() {
		return inquiry_content;
	}

	public void setInquiry_content(String inquiry_content) {
		this.inquiry_content = inquiry_content;
	}

}
