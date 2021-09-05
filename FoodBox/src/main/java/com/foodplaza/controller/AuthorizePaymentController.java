package com.foodplaza.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodplaza.dao.CartDaoImp;
import com.foodplaza.model.Cart;
import com.foodplaza.paypal.PaymentServices;
import com.paypal.base.rest.PayPalRESTException;

@Controller
public class AuthorizePaymentController {

	@RequestMapping(path = "/authorize_payment", method = RequestMethod.POST)
	public void authorizePayment(HttpServletRequest request, HttpServletResponse response,Model model) throws IOException, ServletException
	{
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("USERNAME");
    	System.out.println("User Id : "+email);
    	List<Cart> listOfproductInCart=new CartDaoImp().showCart(email);
 
        try {
            PaymentServices paymentServices = new PaymentServices();
            String approvalLink = paymentServices.authorizePayment(listOfproductInCart);
 
            response.sendRedirect(approvalLink);
             
        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
	}

}
