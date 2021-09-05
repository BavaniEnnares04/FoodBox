package com.foodplaza.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.foodplaza.dao.CartDaoImp;
import com.foodplaza.dao.FoodDaoImp;
import com.foodplaza.model.Cart;
import com.foodplaza.model.Food;

@Controller
public class UpdateFoodController {

	@RequestMapping(path = "/deleteFood", method = RequestMethod.GET)
	public String deleteFood(HttpServletRequest request, HttpServletResponse response,Model model)
	{
		FoodDaoImp fdao=new FoodDaoImp();
		int foodid=Integer.parseInt(request.getParameter("foodId"));
		boolean flag=fdao.deleteFoodById(foodid);
		if(flag==true)
		{
			request.setAttribute("status","<b style='color:white;align:center;'>Food Deleted Successfully...<b>");
			return "ShowFoods";
		}
		else
		{
			request.setAttribute("status","<b style='color:white;align:center;'>Food Not Deleted....<b>");
			return "ShowFoods";
		}
		
	}
	
	@RequestMapping(path = "/addToCart", method = RequestMethod.GET)
	public String addToCart(HttpServletRequest request, HttpServletResponse response,Model model)
	{
		int foodid=Integer.parseInt(request.getParameter("foodId"));
		int quantity=1;
		String foodName=(String)request.getParameter("foodName");
		HttpSession session=request.getSession() ;
		Cart c=new Cart();
		double price=Double.parseDouble(request.getParameter("price"));
		price=price*quantity;
		
		String username=(String)session.getAttribute("USERNAME");
		CartDaoImp cdao=new CartDaoImp();
		c.setFoodId(foodid);
		c.setQuantity(quantity);
		c.setEmail(username);
        c.setFoodName(foodName);
        c.setPrice(price);
        boolean flag=cdao.addToCart(c);
		if(flag==true)
		{
			request.setAttribute("foodName", foodName);
			request.setAttribute("status","<b style='color:white;align:center;'>Food Successfully Added to Cart....<b>");
			return "ShowFoods";
		}
		else
		{
			request.setAttribute("status","<b style='color:white;align:center;'>Food Not Added to Cart..<b>");
			return "ShowFoods";
		}
		
		
	}
	
	@RequestMapping(path = "/updateFood", method = RequestMethod.GET)
	public String updateFood(HttpServletRequest request, HttpServletResponse response,Model model)
	{
		Food f=new Food();
		FoodDaoImp fdao=new FoodDaoImp();
		int foodid=Integer.parseInt(request.getParameter("foodId"));
	    f=fdao.getFoodById(foodid);
	    request.setAttribute("Food", f);
	    return "updateFood";
	}
	
	@RequestMapping(path = "/updateFood", method = RequestMethod.POST)
	public String updateFoodPost(HttpServletRequest request, HttpServletResponse response,Model model)
	{
		Food f=new Food();
		FoodDaoImp fdao=new FoodDaoImp();
		int foodid=Integer.parseInt(request.getParameter("fid"));
		String foodname=request.getParameter("fname");
		String foodtype=request.getParameter("ftype"); 
		String foodcategory=request.getParameter("fcategory"); 
		String foodDes=request.getParameter("fdesc"); 
		double foodprice=Double.parseDouble(request.getParameter("fprice")); 
		
		f=new Food(foodname, foodtype, foodcategory, foodDes, foodprice);
		f.setFoodId(foodid);
		boolean flag=fdao.updateFood(f);
		if(flag==true)
		{
			request.setAttribute("status","<b style='color:white;align:center;'>Food Updated Successfully...<b>");
			return "ShowFoods";
		}
		else
		{
			request.setAttribute("status","<b style='color:white;align:center;'>Food Not Updated..<b>");
			return "ShowFoods";
		}
	}

}
