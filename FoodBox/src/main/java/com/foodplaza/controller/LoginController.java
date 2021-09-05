package com.foodplaza.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.foodplaza.utility.DBUtility;

@Controller
public class LoginController {

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response,Model model) throws ServletException, IOException
	{
	
		RequestDispatcher rd;
		PreparedStatement stmt;
		ResultSet rs;
		Connection con=DBUtility.connection();
		String USERNAME=request.getParameter("email");
		String PASSWORD=request.getParameter("pass");
		int count=0;
		
		String type=request.getParameter("type");
		
		if(type.equals("Customer"))
		{
			
			String str="select * from Customer";
			try
			{
				stmt= con.prepareStatement(str);
				rs=stmt.executeQuery();
				while(rs.next())
				{		
					
					if(USERNAME.equals(rs.getString("CustEmail"))&& PASSWORD.equals(rs.getString("CustPassword")))
					{
						count=1;
					}
					
				}
				if(count==1)
				{
					String statusString="<b style=color:white;>"+"You have Successfully Logined as "+"<b>"+"<b style=color:red;>"+USERNAME+"<b>";
					request.setAttribute("status",statusString);
					
					
					HttpSession session=request.getSession();
					session.setAttribute("USERNAME",USERNAME);
					session.setAttribute("usertype","Customer");
					
					count=0;
					rd=request.getRequestDispatcher("Index.jsp");
					rd.forward(request, response);
				}
				else
				{
					String statusString="<b style='color:white'>Failed to Login... Please try again...</b>";
					request.setAttribute("status",statusString);
					rd=request.getRequestDispatcher("Index.jsp");
					rd.forward(request, response);
				}
		   
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		
		if(type.equals("Admin"))
		{
			String str="select * from Admin";
			try
			{
				stmt= con.prepareStatement(str);
				rs=stmt.executeQuery();
				while(rs.next())
				{		
					
					if(USERNAME.equals(rs.getString("adminEmail"))&& PASSWORD.equals(rs.getString("adminPassword")))
					{
						count=1;
					}
					
				}
				if(count==1)
				{
					String statusString="<b style=color:white;>"+"You have Successfully Logined as "+"<b>"+"<b style=color:red;>"+USERNAME+"<b>";
					request.setAttribute("status",statusString);
					HttpSession session=request.getSession();
					session.setAttribute("USERNAME",USERNAME);
					session.setAttribute("usertype","Admin");
					rd=request.getRequestDispatcher("Index.jsp");
					rd.forward(request, response);
					
					count=0;
				}
				else
				{
					String statusString="<b style='color:white'>Failed to Login... Please try again...</b>";
					request.setAttribute("status",statusString);
					rd=request.getRequestDispatcher("Index.jsp");
					rd.forward(request, response);
				}
		   
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	@RequestMapping(path = "/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response,Model model) throws ServletException, IOException
	{
		RequestDispatcher rd;
		HttpSession session=request.getSession();
		session.invalidate();
		String statusString="<b style='color:white'>Successfully Logged Out.....</b>";
		request.setAttribute("status",statusString);
		rd=request.getRequestDispatcher("Index.jsp"); 
	    rd.forward(request, response);
		 
	    
		
	}

}
