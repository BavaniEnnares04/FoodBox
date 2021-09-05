package com.foodplaza.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.foodplaza.dao.AdminDaoImp;
import com.foodplaza.model.Admin;

@Controller
public class AdminController {

	@RequestMapping(path = "/updateAdmin", method = RequestMethod.POST)
	public String updateAdminPost(HttpServletRequest request, HttpServletResponse response,Model model)
	{
		Admin a=new Admin();
		AdminDaoImp adao=new AdminDaoImp();
		RequestDispatcher rd;
		int adminid=Integer.parseInt(request.getParameter("aid"));
		String adminname=request.getParameter("aname");
		String adminaddress=request.getParameter("aaddress"); 
		String admincontact=request.getParameter("acontact");
		String adminemail=request.getParameter("aemail");
		
		a=new Admin(adminname, adminemail, adminaddress, admincontact);
		a.setAdminId(adminid);
		boolean flag=adao.updateAdmin(a);
		if(flag==true)
		{
			request.setAttribute("status","<b style='color:white;align:center;'>Admin Profile Updated Successfully...<b>");
			return "ShowAdminProfile";
		}
		else
		{
			request.setAttribute("status","<b style='color:white;align:center;'>Admin Profile Not Updated..<b>");
			return "ShowAdminProfile";
	    }
		
	}
	
	@RequestMapping(path = "/updateAdmin", method = RequestMethod.GET)
	public String updateAdminGet(HttpServletRequest request, HttpServletResponse response,Model model)
	{
		
		AdminDaoImp adao=new AdminDaoImp();
			int adminid=Integer.parseInt(request.getParameter("adminId"));
			 Admin a=adao.getAdminById(adminid);
			 request.setAttribute("Admin", a);
			 
			 return "updateAdmin";
		
	}

}
