package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodplaza.model.Cart;
import com.foodplaza.utility.DBUtility;

public class CartDaoImp implements CartDao
{
    Cart c;
    String str;
    PreparedStatement stmt;
    ResultSet rs;
    int row=0;
    static Connection con=DBUtility.connection();
    
	
	public boolean addToCart(Cart c) 
	{
		str="insert into Cart(FoodId,FoodName,Quantity,Email,Price) values(?,?,?,?,?)";
		
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setInt(1,c.getFoodId());
			stmt.setString(2,c.getFoodName());
			stmt.setInt(3,c.getQuantity());
			stmt.setString(4,c.getEmail());
			stmt.setDouble(5,c.getPrice());
			row=stmt.executeUpdate();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		if(row > 0)
			return true;
		else 
			return false;
		
	}

	
	public List<Cart> showCart(String email) 
	{
		str="select * from Cart where Email=?";
		List<Cart>  li=new ArrayList<Cart>();
	  try
	  {	
		  stmt=con.prepareStatement(str);
		stmt.setString(1,email);
		rs=stmt.executeQuery();
		while(rs.next())
		{
			c=new Cart(rs.getInt("FoodId"),rs.getInt("Quantity"),rs.getString("FoodName"),rs.getString("Email"),
					rs.getDouble("Price"));
			c.setCartId(rs.getInt("CartId"));
			li.add(c);
		}
	  }
	
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	  return li;
		
	}

	public boolean deleteCartById(int cartId) 
	{
		str="delete from Cart where CartId=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setInt(1, cartId);
			row=stmt.executeUpdate();
		}
		catch(SQLException e)
		{
		   e.printStackTrace();	
		}
		
		if(row > 0)
			return true;
		else 
			return false;
		

		
	}

	
	public boolean clearCart(String email) 
	{
		str="delete from Cart where Email=? ";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setString(1, email);
			row=stmt.executeUpdate();
		}
		catch(SQLException e)
		{
		   e.printStackTrace();	
		}
		
		if(row > 0)
			return true;
		else 
			return false;
 	}


	public boolean getCartById(String email) {
		// TODO Auto-generated method stub
		return false;
	}


	public double totalPriceFromCart(String email) {
	
		ResultSet rs;
		Connection con=DBUtility.connection();
		Statement stmt;
		double price=0;
		String query="select price from Cart where email='"+email+"'";
		
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(query); 
			
			while(rs.next())
			{
				double p=rs.getDouble("price");
				price=price+p;
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		return price;
	}

}
