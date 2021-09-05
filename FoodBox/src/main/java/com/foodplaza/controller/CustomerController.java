package com.foodplaza.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.foodplaza.dao.CustomerDaoImp;
import com.foodplaza.model.Customer;

@Controller
public class CustomerController {

	@RequestMapping(path = "/deleteCustomer", method = RequestMethod.GET)
	public String deleteCustomer(HttpServletRequest request, HttpServletResponse response,Model model)
	{
		CustomerDaoImp cdao=new CustomerDaoImp();
		int Custid=Integer.parseInt(request.getParameter("custId"));
		boolean flag=cdao.deleteCustomer(Custid);
		if(flag==true)
		{
			request.setAttribute("status","<b style='color:white;align:center;'>Customer Deleted Successfully...<b>");
			return "ShowCustomers";
		}
		else
		{
			request.setAttribute("status","<b style='color:white;align:center;'>Customer Not Deleted....<b>");
			return "ShowCustomers";
		}
	}
	
	@RequestMapping(path = "/updateCustomer", method = RequestMethod.GET)
	public String updateCustomer(HttpServletRequest request, HttpServletResponse response,Model model)
	{
		CustomerDaoImp cdao=new CustomerDaoImp();
		int Custid=Integer.parseInt(request.getParameter("custId"));
		 Customer c=cdao.getCustById(Custid);
		 request.setAttribute("Customer", c);
		 return "updateCustomer";
		
	}
	
	@RequestMapping(path = "/updateCustomer", method = RequestMethod.POST)
	public String updateCustomerProfile(HttpServletRequest request, HttpServletResponse response,Model model)
	{
		Customer c=new Customer();
		CustomerDaoImp cdao=new CustomerDaoImp();
		int custid=Integer.parseInt(request.getParameter("cid"));
		String cname=request.getParameter("cname");
		String caddress=request.getParameter("caddress"); 
		String ccontact=request.getParameter("ccontact");
		String cemail=request.getParameter("cemail");
		
		c=new Customer(cname, cemail, caddress, ccontact);
		c.setCustId(custid);
		boolean flag=cdao.updateCustomer(c);
		if(flag==true)
		{
			request.setAttribute("status","<b style='color:white;align:center;'>Profile Updated Successfully...<b>");
			return "ShowMyProfile";
		}
		else
		{
			request.setAttribute("status","<b style='color:white;align:center;'>Profile Not Updated..<b>");
			return "ShowMyProfile";
     	}
		
	}
	


}
