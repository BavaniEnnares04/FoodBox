package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodplaza.model.Customer;
import com.foodplaza.utility.DBUtility;

public class CustomerDaoImp implements CustomerDao
{
	String str;
	PreparedStatement stmt;
	ResultSet rs;
	int row=0;
	Customer c;
	
	
    static Connection con=DBUtility.connection();
    
	
	public boolean addCustomer(Customer c) 
	{
		str="insert into Customer(CustName,CustEmail,CustPassword,CustAddress,Contact_NO) values(?,?,?,?,?)";
    	try
    	{
    	stmt=con.prepareStatement(str);
    	stmt.setString(1,c.getCustName());
    	stmt.setString(2,c.getCustEmail());
    	stmt.setString(3,c.getCustPassword());
    	stmt.setString(4,c.getCustAddress());
    	stmt.setString(5,c.getContactNo());
    	
    	row=stmt.executeUpdate();   //return type of executeupdate is int, it returns ROWS affected in DATABASE
    	
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	if(row>0)
    		return true;
    	else
    		return false;

	}
	
	
	public boolean updateCustomer(Customer c) 
	{
		str="update Customer set CustName=?,CustEmail=?,CustAddress=?,Contact_No=? where CustId=?";
    	try
    	{
    	stmt=con.prepareStatement(str);
    	stmt.setString(1,c.getCustName());
    	stmt.setString(2,c.getCustEmail());
    	stmt.setString(3,c.getCustAddress());
    	stmt.setString(4,c.getContactNo());
    	stmt.setInt(5,c.getCustId() );
    	
    	row=stmt.executeUpdate();   //return type of executeupdate is int, it returns ROWS affected in DATABASE
    	
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	if(row>0)
    		return true;
    	else
    		return false;


	}


	public boolean deleteCustomer(int custId)
	{
		str="delete from Customer where CustId=?";
        try
      	{
      	stmt=con.prepareStatement(str);
      	stmt.setInt(1,custId);
        row=stmt.executeUpdate();   //return type of executeupdate is int, it returns ROWS affected in DATABASE
      	}
      	catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
      	if(row>0)
      		return true;
      	else
      		return false;
        
	}

	
	public Customer getCustById(String email) 
	{
		str="select * from Customer where CustEmail=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setString(1, email);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				c = new Customer();
				c.setCustId(rs.getInt("CustId"));
				c.setCustName(rs.getString("CustName"));
				c.setCustEmail(rs.getString("CustEmail"));
				c.setCustPassword(rs.getString("CustPassword"));
				c.setCustAddress(rs.getString("CustAddress"));
				c.setContactNo(rs.getString("Contact_No"));
		        
				
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		return c;

	}

	
	public List<Customer> getAllCustomer()
	{
		str="select * from Customer";
		List<Customer> li=new ArrayList<Customer>();
		try
		{
			stmt=con.prepareStatement(str);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				c= new Customer();
				
				c.setCustId(rs.getInt("CustId"));
				c.setCustName(rs.getString("CustName"));
				c.setCustEmail(rs.getString("CustEmail"));
				c.setCustPassword(rs.getString("CustPassword"));
				c.setCustAddress(rs.getString("CustAddress"));
				c.setContactNo(rs.getString("Contact_No"));
		        li.add(c);
		        
				
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		return li;

	}



	
	public Customer getCustById(int custId) 
	{
		str="select * from Customer where CustId=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setInt(1, custId);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				c = new Customer();
				c.setCustId(rs.getInt("CustId"));
				c.setCustName(rs.getString("CustName"));
				c.setCustEmail(rs.getString("CustEmail"));
				c.setCustPassword(rs.getString("CustPassword"));
				c.setCustAddress(rs.getString("CustAddress"));
				c.setContactNo(rs.getString("Contact_No"));
		        
				
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		return c;
	}

}
