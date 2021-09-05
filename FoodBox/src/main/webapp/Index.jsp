<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body style="background-color:Black;">
<head>
<meta charset="ISO-8859-1">
<title>Food Box</title>

<style type="text/css">
.img
{
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}
</style>
</head>
<body>

<h1 style="color:White;text-align:center;">Welcome to Food Box</h1>

<%
String status=(String)request.getAttribute("status");
if(status!=null)
{
   out.println(status);	
}
%>

<hr>
<%
   String active=(String)session.getAttribute("usertype");
   if(active==null)
   {
%>
   <%-- &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="signup">SIGN UP</a>&emsp;&emsp;
   <a href="login">LOGIN</a> --%>
   <%-- <center><a href="signup">SIGN UP</a>&emsp;&emsp;<a href="login">LOGIN</a></center> --%>
   <div style="text-align: center">
   	<a href="signup" style="color:white;">SIGN UP</a>&emsp;&emsp;<a href="login" style="color:white;">LOGIN</a>
   </div>
<%   
   }
%>

<%
   String user=(String)session.getAttribute("usertype");
   if(user!=null && user=="Admin")
   {
%>
    <%-- &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="addFood" style="color:MediumAquaMarine;">Add Food</a>&emsp;&emsp;
     <a href="showCustomers" style="color:MediumAquaMarine;">All Customers</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
     <a href="showCustomersOrder" style="color:MediumAquaMarine;">Show Customers Orders</a> --%>
     
    <div style="text-align: center">
    <a href="addFood" style="color:MediumAquaMarine;">Add Food</a>&emsp;&emsp;
    <a href="showCustomers" style="color:MediumAquaMarine;">All Customers</a>&emsp;&emsp;
    <a href="showCustomersOrder" style="color:MediumAquaMarine;">Show Customers Orders</a>
    </div>
    <div style="text-align: right">
    <a href="logout" style="color:MediumAquaMarine;">ADMIN LOGOUT</a>
    </div>
<%
     
   }
%>

<%
 String user1=(String)session.getAttribute("usertype");
   if(user1!=null && user1=="Customer")
   {
%>
    <%-- &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="showMyCart" style="color:MediumAquaMarine;">Show My Cart</a>&emsp;&emsp;
    <a href="showMyProfile" style="color:MediumAquaMarine;">Show My Profile</a>&emsp;&emsp;&emsp;&emsp;
    <a href="showMyOrders" style="color:MediumAquaMarine;">Show My Orders</a> --%>
    
    <div style="text-align: center">
    <a href="showMyCart" style="color:MediumAquaMarine;">Show My Cart</a>&emsp;&emsp;
    <a href="showMyProfile" style="color:MediumAquaMarine;">Show My Profile</a>&emsp;&emsp;
    <a href="showMyOrders" style="color:MediumAquaMarine;">Show My Orders</a>&emsp;&emsp;
    <%-- <a href="showAdminProfile" style="color:MediumAquaMarine;">Show My Admin Profile</a> --%>
    </div>
    <div style="text-align: right">
    <a href="logout" style="color:MediumAquaMarine;">CUSTOMER LOGOUT</a>
    </div>
    
<%   
   }
%>

 
   
<hr>
<br>
   
   


     <img align="middle" src="C:\Users\Bavani_Ennares_Mania\Documents\Full Stack Developer\Final Project\FoodPlaza-20210901T061139Z-001\FoodPlaza\src\main\webapp\images\WelcomeImage.jpg" style="width: 830px; height: 350px;" class="img"><br>
     



<hr>
<%-- &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="showFoods">SHOW AVAILABLE FOODS</a>&emsp;&emsp;
<a href="forgotPassword">FORGET PASSWORD</a>&emsp;&emsp; --%>
<%-- <center></center> --%>
<div style="text-align: center">
	<a href="showFoods" style="color:white;">SHOW AVAILABLE FOODS</a>&emsp;&emsp;<a href="forgotPassword" style="color:white;">FORGET PASSWORD</a>
</div>

<%
   String user2=(String)session.getAttribute("usertype");
   String email=(String)session.getAttribute("USERNAME");
   if(user2!=null && user2=="Admin")
   {
%>
    <a href="showAdminProfile" style="color:MediumAquaMarine;">Show My Admin Profile</a>&emsp;&emsp;
    
    <%-- <a href="AdminServ?adminEmail=<%=email %>&action=deleteAdmin>">Delete My Admin Account</a> --%>
<%    
   }
%>

<%
   String active1=(String)session.getAttribute("usertype");
   if(active1!=null)
   {
%>   <%-- <div style="text-align: right">
    <a href="logout" style="color:MediumAquaMarine;">LOGOUT</a>
    </div> --%>
<%   
   }
%>

<hr>
</body>
</body>
</html>