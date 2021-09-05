package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.foodplaza.model.Admin;
import com.foodplaza.utility.DBUtility;

public class AdminDaoImp implements AdminDao
{
	String str;
	PreparedStatement stmt;
	ResultSet rs;
	int row=0;
	Admin a;
	static Connection con=DBUtility.connection();
	
	public boolean addAdmin(Admin a) 
	{
		str="insert into Admin(adminName,adminEmail,adminPassword,adminAddress,adminContact) values(?,?,?,?,?)";
    	try
    	{
    	stmt=con.prepareStatement(str);
    	stmt.setString(1,a.getAdminName());
    	stmt.setString(2,a.getAdminEmail());
    	stmt.setString(3,a.getAdminPassword());
    	stmt.setString(4,a.getAdminAddress());
    	stmt.setString(5,a.getAdminContact());
    	
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

	public boolean updateAdmin(Admin a) 
	{
		str="update Admin set adminName=?,adminEmail=?,adminAddress=?,adminContact=? where adminId=?";
    	try
    	{
    	stmt=con.prepareStatement(str);
    	stmt.setString(1,a.getAdminName());
    	stmt.setString(2,a.getAdminEmail());
    	stmt.setString(3,a.getAdminAddress());
    	stmt.setString(4,a.getAdminContact());
    	stmt.setInt(5,a.getAdminId() );
    	
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

	public boolean deleteAdmin(String adminEmail) 
	{
		str="delete from Admin where adminEmail=?";
        try
      	{
      	stmt=con.prepareStatement(str);
      	stmt.setString(1,adminEmail);
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

	public Admin getAdminById(int adminId) 
	{
		str="select * from Admin where adminId=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setInt(1, adminId);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				a = new Admin();
				a.setAdminId(rs.getInt("adminId"));
				a.setAdminName(rs.getString("adminName"));
				a.setAdminEmail(rs.getString("adminEmail"));
				a.setAdminPassword(rs.getString("adminPassword"));
				a.setAdminAddress(rs.getString("adminAddress"));
				a.setAdminContact(rs.getString("adminContact"));	
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		return a;
	}

	public Admin getAdminById(String adminEmail) 
	{
		str="select * from Admin where adminEmail=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setString(1, adminEmail);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				a = new Admin();
				a.setAdminId(rs.getInt("adminId"));
				a.setAdminName(rs.getString("adminName"));
				a.setAdminEmail(rs.getString("adminEmail"));
				a.setAdminPassword(rs.getString("adminPassword"));
				a.setAdminAddress(rs.getString("adminAddress"));
				a.setAdminContact(rs.getString("adminContact"));	
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		return a;
	}

}
