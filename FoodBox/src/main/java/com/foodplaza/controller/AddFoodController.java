package com.foodplaza.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.foodplaza.dao.FoodDaoImp;
import com.foodplaza.model.Food;

@Controller
public class AddFoodController {

	
	@RequestMapping(path = "/addFood", method = RequestMethod.POST)
	public String addFood(HttpServletRequest request, HttpServletResponse response,Model model) throws IOException, ServletException
	{

		Food f=new Food();
		FoodDaoImp fdao=new FoodDaoImp();
		
		String foodname=request.getParameter("fname");
		String foodtype=request.getParameter("ftype"); 
		String foodcategory=request.getParameter("fcategory"); 
		String foodDes=request.getParameter("fdesc"); 
		double foodprice=Double.parseDouble(request.getParameter("fprice")); 

		f=new Food(foodname, foodtype, foodcategory, foodDes, foodprice);
		boolean flag=fdao.addFood(f);
		if(flag==true)
		{
			request.setAttribute("status","<b style='color:white;align:center;'>Food Added Successfully...<b>");
			return "AddFood";
		}
		else
		{
			request.setAttribute("status","<b style='color:white;align:center;'>Food Not Added..<b>");
			return "AddFood";
		}
		
	}

}
