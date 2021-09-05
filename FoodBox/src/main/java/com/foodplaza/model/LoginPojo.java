package com.foodplaza.model;

public class LoginPojo 
{
    private String username;
    private String password;
    private String cpassword;
    
    public LoginPojo()
    {
    	
    }
    
	public LoginPojo(String username, String password,String cpassword) 
	{
		super();
		this.username = username;
		this.password = password;
		this.cpassword = cpassword;
	}
	
	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	@Override
	public String toString() {
		return "LoginPojo [username=" + username + ", password=" + password + ", cpassword=" + cpassword + "]";
	}
  
}
