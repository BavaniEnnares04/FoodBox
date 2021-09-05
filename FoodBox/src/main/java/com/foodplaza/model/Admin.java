package com.foodplaza.model;

public class Admin 
{
	 private int adminId;
     private String adminName,adminEmail,adminAddress,adminPassword,adminContact;
     
    public Admin()
    {
    	
    }
     
	public Admin(String adminName, String adminEmail, String adminAddress, String adminContact)
	{
		super();
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminAddress = adminAddress;
		this.adminContact = adminContact;
	}
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminAddress() {
		return adminAddress;
	}
	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminContact() {
		return adminContact;
	}
	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}
     
     
}
