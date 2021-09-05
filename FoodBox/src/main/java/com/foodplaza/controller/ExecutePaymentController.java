package com.foodplaza.controller;

import java.io.IOException;
import java.time.LocalDate;
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
import com.foodplaza.dao.CustomerDaoImp;
import com.foodplaza.dao.FoodDaoImp;
import com.foodplaza.dao.OrderDaoImp;
import com.foodplaza.model.Cart;
import com.foodplaza.model.Customer;
import com.foodplaza.model.Food;
import com.foodplaza.model.Order;
import com.foodplaza.paypal.PaymentServices;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;

@Controller
public class ExecutePaymentController {

	@RequestMapping(path = "/execute_payment", method = RequestMethod.POST)
	public String executePayment(HttpServletRequest request, HttpServletResponse response,Model model) throws IOException, ServletException
	{
		String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");
        HttpSession session=request.getSession();
        try {
            PaymentServices paymentServices = new PaymentServices();
            Payment payment = paymentServices.executePayment(paymentId, payerId);
             
            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
            Transaction transaction = payment.getTransactions().get(0);
             
            String email=(String)session.getAttribute("USERNAME");
            Customer cust=new CustomerDaoImp().getCustById(email);
			LocalDate date=LocalDate.now();
			String orderedDate=String.valueOf(date);
			OrderDaoImp od=new OrderDaoImp();
			CartDaoImp cd=new CartDaoImp();
			Order order=new Order();
			FoodDaoImp pd=new FoodDaoImp();
			
			List<Cart> cart=cd.showCart(email);
		    for(Cart c:cart)
		    {
			    int foodId=c.getFoodId();
			    Food f=pd.getFoodById(foodId) ;
		  
			    order.setFoodId(foodId);
		    	order.setEmail(email);
		    	order.setQuantity(c.getQuantity());
		    	order.setTotalBill(c.getPrice());
		    	order.setDate(orderedDate);
		    	od.placeOrder(email,cart);
		    		
		    }
		        cd.clearCart(email);
            
            request.setAttribute("payer", payerInfo);
            request.setAttribute("transaction", transaction);  
            return "receipt";
             
        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            return "error";
        }
	}

}
