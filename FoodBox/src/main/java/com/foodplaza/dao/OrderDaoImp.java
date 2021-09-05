package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.foodplaza.model.Cart;
import com.foodplaza.model.Order;
import com.foodplaza.utility.DBUtility;

public class OrderDaoImp implements OrderDao
{
	    Order o;
	    String str;
	    PreparedStatement stmt;
	    ResultSet rs;
	    int row=0,row1=0;
	    static Connection con=DBUtility.connection();
	    
		public boolean placeOrder(String email,List<Cart> cart) 
		{
		   double bill;
		   LocalDate ld=LocalDate.now();
		   String date=ld.toString();
		   String str1="insert into FoodOrder(Email,Date,Total_Bill,FoodId,quantity) values (?,?,?,?,?)";
		   try {
			   
			   for(Cart c:cart)
			   {
				   stmt=con.prepareStatement(str1);
					stmt.setString(1,email);
					stmt.setString(2,date);
					stmt.setDouble(3,c.getPrice());
					stmt.setInt(4,c.getFoodId());
					stmt.setInt(5,c.getQuantity());
					row=stmt.executeUpdate();   
			   }
				
				
	
		   }
		   catch(SQLException e)
		   {
			   System.out.println(e);
		   }
		   
			   String sql="delete from cart where CartId=?";
			   for(Cart c:cart)
			   {
				   try {
					   stmt=con.prepareStatement(sql);
						stmt.setInt(1,c.getCartId());
						row1=stmt.executeUpdate();
					   }
					   
					   catch(Exception e)
					   {
						   e.printStackTrace();
					   }   
			   }
			     
		   if(row>0&&row1>0)
		   {
			   return true;
		   }
		   else
		   {
			   return false;
		   }
		}
		
		public List<Order> showOrder(String email) 
		{
		     Order od=null;
		     List<Order> oli=new ArrayList<Order>();
		     
		     try 
		     {
		    	 String str="select * from FoodOrder where Email=?";
		    	 stmt=con.prepareStatement(str);
		    	 stmt.setString(1,email);
		    	 rs=stmt.executeQuery();
		    	 while(rs.next())
		    	 {
		    		 od=new Order();
		    		 od.setOrderId(rs.getInt("OrderId"));
		    		 od.setEmail(rs.getString("Email"));
		    		 od.setDate(rs.getString("Date"));
		    		 od.setTotalBill(rs.getInt("Total_Bill"));
		    		 od.setFoodId(rs.getInt("FoodId"));
		    		 od.setQuantity(rs.getInt("quantity"));
		    		 oli.add(od);
		    	 }
		     }
		     catch(SQLException e)
		     {
		    	 e.printStackTrace();
		     }
		     
		     return oli;
		}

		public double totalPriceFromOrder(String email) {
		
			ResultSet rs;
			Connection con=DBUtility.connection();
			Statement stmt;
			double price=0;
			String query="select Total_Bill from foodorder where email='"+email+"'";
			
			try
			{
				stmt=con.createStatement();
				rs=stmt.executeQuery(query); 
				
				while(rs.next())
				{
					double p=rs.getDouble("Total_Bill");
					System.out.println(p);
					price=price+p;
				}
			}
			
			catch(SQLException e)
	      	{
	      		e.printStackTrace();
	      	}
			
			return price;
		}

		public List<Order> getAllOrders() {
			 Order od=null;
		     List<Order> oli=new ArrayList<Order>();
		     
		     try 
		     {
		    	 String str="select * from FoodOrder";
		    	 stmt=con.prepareStatement(str);
		    	 rs=stmt.executeQuery();
		    	 while(rs.next())
		    	 {
		    		 od=new Order();
		    		 od.setOrderId(rs.getInt("OrderId"));
		    		 od.setEmail(rs.getString("Email"));
		    		 od.setDate(rs.getString("Date"));
		    		 od.setTotalBill(rs.getInt("Total_Bill"));
		    		 od.setFoodId(rs.getInt("FoodId"));
		    		 od.setQuantity(rs.getInt("quantity"));
		    		 oli.add(od);
		    	 }
		     }
		     catch(SQLException e)
		     {
		    	 e.printStackTrace();
		     }
		     
		     return oli;
		}

		public boolean addDelivery(String email, String delivery) {
			
			   String str1="update foodorder set delivery=? where email=?";
			   try {
					   stmt=con.prepareStatement(str1);
						stmt.setString(1,delivery);
						stmt.setString(2,email);
						row=stmt.executeUpdate();
			   }
			   catch(SQLException e)
			   {
				   System.out.println(e);
			   }
				     
			   if(row>0)
			   {
				   return true;
			   }
			   else
			   {
				   return false;
			   }
		}

		public String getDelivery(String email) {
			ResultSet rs;
			Connection con=DBUtility.connection();
			Statement stmt;
			String delivery=null;
			String query="select delivery from foodorder where email='"+email+"'";
			
			try
			{
				stmt=con.createStatement();
				rs=stmt.executeQuery(query); 
				
				while(rs.next())
				{
					delivery=rs.getString("delivery");
					break;
				}
			}
			
			catch(SQLException e)
	      	{
	      		e.printStackTrace();
	      	}
		
			return delivery;
		}
	
}
