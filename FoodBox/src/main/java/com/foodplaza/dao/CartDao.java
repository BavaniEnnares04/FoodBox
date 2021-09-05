package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.model.Cart;

public interface CartDao
{
    boolean addToCart(Cart c);
    List<Cart> showCart(String email);
    boolean deleteCartById(int CartId);
    boolean clearCart(String email);
    boolean getCartById(String email);
    double totalPriceFromCart(String email);
}
