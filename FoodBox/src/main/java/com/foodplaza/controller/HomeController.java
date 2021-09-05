package com.foodplaza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(path = "/signup")
	public String updateAdminGet()
	{		 
	    return "SignUp";	
	}
	
	@RequestMapping(path = "/home")
	public String home()
	{		 
	    return "Index";	
	}
	
	@RequestMapping(path = "/login")
	public String login()
	{		 
	    return "login";	
	}
	
	@RequestMapping(path = "/showFoods")
	public String showFoods()
	{		 
	    return "ShowFoods";	
	}
	
	@RequestMapping(path = "/forgotPassword")
	public String forgotPassword()
	{		 
	    return "ForgotPassword";	
	}
	
	@RequestMapping(path = "/showCustomers")
	public String showCustomers()
	{		 
	    return "ShowCustomers";	
	}
	
	@RequestMapping(path = "/showMyProfile")
	public String showMyProfile()
	{		 
	    return "ShowMyProfile";	
	}
	
	@RequestMapping(path = "/addFood")
	public String addFood()
	{		 
	    return "AddFood";	
	}
	
	@RequestMapping(path = "/showMyCart")
	public String showMyCart()
	{		 
	    return "ShowMyCart";	
	}
	
	@RequestMapping(path = "/showAdminProfile")
	public String showAdminProfile()
	{		 
	    return "ShowAdminProfile";	
	}
	
	@RequestMapping(path = "/showMyOrders")
	public String showMyOrders()
	{		 
	    return "showMyOrders";	
	}
	
	@RequestMapping(path = "/showCustomersOrder")
	public String showCustomersOrder()
	{		 
	    return "showCustomersOrder";	
	}

}
