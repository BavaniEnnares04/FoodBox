package com.foodplaza.model;

public class Cart 
{
   private int cartId,foodId,quantity;
   private String email,foodName;
   private double price;
   
   public Cart()
   {
	   
   }
   
    public Cart( int foodId, int quantity, String foodName,String email,  double price) 
    {
	super();
	this.foodId = foodId;
	this.quantity = quantity;
	this.email = email;
	this.foodName = foodName;
	this.price = price;
    }

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", foodId=" + foodId + ", quantity=" + quantity + ", email=" + email
				+ ", foodName=" + foodName + ", price=" + price + "]";
	}
    
    
   
   
}
