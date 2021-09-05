package com.foodplaza.model;

public class Food 
{
	private int FoodId;
	private String FoodName,FoodType,FoodCategory,FoodDescription;  
	private double Price;
	
	//Non-Parameterized Constructor
	public Food()
	{
		
	}
	
	//Parameterized Constructor
	public Food(String foodName, String foodType, String foodCategory, String foodDescription,double price) 
	{
		super();
		FoodName = foodName;
		FoodType = foodType;
		FoodCategory = foodCategory;
		FoodDescription = foodDescription;
		Price = price;
	}
	

	public int getFoodId() {
		return FoodId;
	}

	public void setFoodId(int foodId) {
		FoodId = foodId;
	}

	public String getFoodName() {
		return FoodName;
	}

	public void setFoodName(String foodName) {
		FoodName = foodName;
	}

	public String getFoodType() {
		return FoodType;
	}

	public void setFoodType(String foodType) {
		FoodType = foodType;
	}

	public String getFoodCategory() {
		return FoodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		FoodCategory = foodCategory;
	}

	

	public String getFoodDescription() {
		return FoodDescription;
	}

	public void setFoodDescription(String foodDescription) {
		FoodDescription = foodDescription;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "Food [FoodId=" + FoodId + ", FoodName=" + FoodName + ", FoodType=" + FoodType + ", FoodCategory="
				+ FoodCategory + ",  FoodDescription=" + FoodDescription + ", Price=" + Price + "]";
	}
	
	
	
	
	
    
}
