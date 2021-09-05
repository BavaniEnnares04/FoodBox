package com.foodplaza.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.foodplaza.utility.DBUtility;

@Controller
public class ForgotPassController {

	@RequestMapping(path = "/forgotPass", method = RequestMethod.POST)
	public String forgotPassCustomer(HttpServletRequest request, HttpServletResponse response,Model model)
	{
		Connection con=DBUtility.connection();
		PreparedStatement stmt;
		String username=request.getParameter("email");
		String password=request.getParameter("pass");
		String type=request.getParameter("ftype");
		
		if(type.equals("Customer"))
		{
			String str="update Customer  set CustPassword=? where CustEmail=?";
			try
	    	{
	    	stmt=con.prepareStatement(str);
	    	stmt.setString(1,password);
	    	stmt.setString(2,username);
	    	
	    	
	    	int row=stmt.executeUpdate();   //return type of executeupdate is int, it returns ROWS affected in DATABASE
	    	if(row>0)
			{
				request.setAttribute("status","<b style='color:white;align:center;'>Your password has changed successfully,Now You can LOGIN<b>");
				return "login";
			}
			
			else
			{
				request.setAttribute("status","<b style='color:white;align:center;'>Failed to Update Password<b>");
				return "ForgotPassword";
			}
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
		}
		    
		
		if(type.equals("Admin"))
		{
			String str="update Admin  set adminPassword=? where adminEmail=?";
			try
	    	{
	    	stmt=con.prepareStatement(str);
	    	stmt.setString(1,password);
	    	stmt.setString(2,username);
	    	
	    	
	    	int row=stmt.executeUpdate();   //return type of executeupdate is int, it returns ROWS affected in DATABASE
	    	if(row>0)
			{
				request.setAttribute("status","<b style='color:white;align:center;'>Your password has changed successfully,Now You can LOGIN<b>");
				return "login";
			}
			
			else
			{
				request.setAttribute("status","<b style='color:white;align:center;'>Failed to Update Passwords<b>");
				return "ForgotPassword";
			}
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
		}
		
		request.setAttribute("status","<b style='color:white;align:center;'>Failed to Update Passwords<b>");
		return "ForgotPassword";
		
	}


}
