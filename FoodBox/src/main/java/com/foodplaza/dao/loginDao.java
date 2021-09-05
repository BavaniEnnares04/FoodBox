package com.foodplaza.dao;

public interface loginDao 
{
    boolean CustomerLogin(String username,String password);
    boolean AdminLogin(String username,String password);
    
}
