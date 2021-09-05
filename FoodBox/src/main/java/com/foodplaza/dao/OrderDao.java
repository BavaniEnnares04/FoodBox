package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.model.Cart;
import com.foodplaza.model.Order;

public interface OrderDao 
{
	boolean placeOrder(String email,List<Cart> cart);
	List<Order> showOrder(String email);
	List<Order> getAllOrders();
	double totalPriceFromOrder(String email);
	boolean addDelivery(String email, String delivery);
	String getDelivery(String email);
}
