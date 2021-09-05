package com.foodplaza.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodplaza.dao.CartDaoImp;
import com.foodplaza.dao.OrderDaoImp;
import com.foodplaza.model.Cart;

@Controller
public class CartOrderController {

	@RequestMapping(path = "/deleteCart", method = RequestMethod.GET)
	public String deleteCart(HttpServletRequest request, HttpServletResponse response,Model model)
	{
		CartDaoImp cd=new CartDaoImp();
		int cartId=Integer.parseInt(request.getParameter("cartId"));
		boolean flag=cd.deleteCartById(cartId);
		if(flag==true)
		{
			request.setAttribute("status","<b style='color:white;align:center;'>Selected Cart Deleted Successfully...<b>");
			return "ShowMyCart";
		}
		else
		{
			request.setAttribute("status","<b style='color:white;align:center;'>Cart Not Deleted....<b>");
			return "ShowMyCart";
		}
	}
	
	@RequestMapping(path = "/clearCart", method = RequestMethod.GET)
	public String clearCart(HttpServletRequest request, HttpServletResponse response,Model model)
	{
	
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("USERNAME");
		CartDaoImp cd=new CartDaoImp();
		boolean flag=cd.clearCart(email);
		if(flag==true)
		{
			request.setAttribute("status","<b style='color:white;align:center;'>Cart Deleted Successfully...<b>");
			return "ShowMyCart";
		}
		else
		{
			request.setAttribute("status","<b style='color:white;align:center;'>Cart Not Deleted....<b>");
			return "ShowMyCart";
		}
	}
	
	@RequestMapping(path = "/orderCart", method = RequestMethod.GET)
	public String orderCart(HttpServletRequest request, HttpServletResponse response,Model model)
	{
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("USERNAME");
		double totalBill=new CartDaoImp().totalPriceFromCart((String)session.getAttribute("USERNAME"));
		OrderDaoImp od=new OrderDaoImp();
		List<Cart> l=new ArrayList<Cart>();
	    CartDaoImp cd=new CartDaoImp();
	    l=cd.showCart(email);
	boolean flag=od.placeOrder(email,l);
	if(flag==true)
	{
		request.setAttribute("status","<b style='color:white;align:center;'>Foods Successfully Ordered. Your Total Bill is "+totalBill+"<b>");
		return "ShowFoods";
	}
	else
	{
		request.setAttribute("status","<b style='color:white;align:center;'>Cart Not Deleted....<b>");
		return "ShowMyCart";
	}
	}
	
	@RequestMapping(path = "/addDelivery", method = RequestMethod.POST)
	public String addDelivery(HttpServletRequest request, HttpServletResponse response)
	{
		String email=request.getParameter("email");
		String delivery=request.getParameter("delivery");
		OrderDaoImp od=new OrderDaoImp();
		
	    boolean flag=od.addDelivery(email, delivery);
	
	if(flag==true)
	{
		request.setAttribute("status","<b style='color:white;align:center;'>Delivery Date Added Sucessfully<b>");
		return "showCustomersOrder";
	}
	else
	{
		request.setAttribute("status","<b style='color:white;align:center;'>Failed to add delivery date.<b>");
		return "showCustomersOrder";
	}
	}
	
}
