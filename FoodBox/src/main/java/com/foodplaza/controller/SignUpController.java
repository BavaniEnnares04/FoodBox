package com.foodplaza.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.foodplaza.dao.AdminDaoImp;
import com.foodplaza.dao.CustomerDaoImp;
import com.foodplaza.model.Admin;
import com.foodplaza.model.Customer;

@Controller
public class SignUpController {

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String signupCustomer(HttpServletRequest request, HttpServletResponse response,Model model)
	{			
		CustomerDaoImp cd=new CustomerDaoImp();
		AdminDaoImp ad=new AdminDaoImp();
		String name=request.getParameter("sname");
		String address=request.getParameter("saddress");
		String contact=request.getParameter("scontact");
		String username=request.getParameter("email");
		String password=request.getParameter("pass");
		String type=request.getParameter("stype");
		
		    
		if(type.equals("Customer"))
		{
			Customer c=new Customer(name, username, address, contact);
			c.setCustPassword(password);
			boolean flag=cd.addCustomer(c);
			if(flag==true)
			{
				request.setAttribute("status","<b style='color:white;align:center;'>You have succesfully signed up,Now You can LOGIN<b>");
				/*
				 * rd=request.getRequestDispatcher("login.jsp"); rd.forward(request, response);
				 */
				return "login";
			}
			
			else
			{
				request.setAttribute("status","<b style='color:white;align:center;'>Failed to sign up<b>");
				/*
				 * rd=request.getRequestDispatcher("SignUp.jsp"); rd.forward(request, response);
				 */
				return "SignUp";
			}
		}
			
		if(type.equals("Admin"))
		{
			Admin a=new Admin(name,username , address, contact);
			a.setAdminPassword(password);
			boolean flag=ad.addAdmin(a);
			if(flag==true)
			{
				request.setAttribute("status","<b style='color:white;align:center;'>You have succesfully signed up,Now You can LOGIN<b>");
				/*
				 * rd=request.getRequestDispatcher("login.jsp"); rd.forward(request, response);
				 */
				return "login";
			}
			
			else
			{
				request.setAttribute("status","<b style='color:white;align:center;'>Failed to sign up<b>");
				/*
				 * rd=request.getRequestDispatcher("SignUp.jsp"); rd.forward(request, response);
				 */
				return "SignUp";
			}
		}
		request.setAttribute("status","<b style='color:white;align:center;'>Failed to Sign up.<b>");
		return "SignUp";
	}

}
