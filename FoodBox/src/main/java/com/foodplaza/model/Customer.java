package com.foodplaza.model;

public class Customer 
{
     private int custId;
     private String custName,custEmail,custAddress,custPassword,contactNo;
     
     public Customer()
     {
    	 
     }
     
	 public Customer( String custName, String custEmail, String custAddress,
			String contactNo)
	 {
		super();
		this.custName = custName;
		this.custEmail = custEmail;        
		this.custAddress = custAddress;
		this.contactNo = contactNo;
	 }

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custEmail=" + custEmail + ", custAddress="
				+ custAddress + ", custPassword=" + custPassword + ", contactNo=" + contactNo + "]";
	}
	 
	 
     
     
}
