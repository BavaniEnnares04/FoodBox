<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="com.foodplaza.dao.*"%>
<%@ page import ="com.foodplaza.model.*"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<body background = "C:\Users\Bavani_Ennares_Mania\Documents\Full Stack Developer\Final Project\FoodPlaza-20210901T061139Z-001\FoodPlaza\src\main\webapp\images\background1.jpg">
</body>
<meta charset="ISO-8859-1">
<title>Available Food</title>
</head>
<body>

<%
    List<Food> l=new ArrayList<Food>();
    FoodDaoImp fd=new FoodDaoImp();
    l=fd.getAllFood();
    String user=(String)session.getAttribute("usertype");
%>

<div align="center">
         <form  >
             <fieldset>
                       <legend style = "color: white"><b>Available Food Items</b></legend>
                       
<%
String status=(String)request.getAttribute("status");
if(status!=null)
{
   out.println(status);	
}
%>

              <table border="1" cellpadding="5">
              
            <tr bgcolor="RosyBrown">
                <td style='color:black'>Food Id</td>
                <td style='color:black'>Food Name</td>
                <td style='color:black'>Food Type</td>
                <td style='color:black'>Food Category</td>
                <td style='color:black'>Food Description</td>
                <td style='color:black'>Food Price</td>
                
                
           <% 
           if(user!=null && user=="Admin")
             {
           %>
                 <td colspan="2">Action</td>
           <%
             }  
           %>
           
            <% 
           if(user!=null && user=="Customer")
             {
           %>
                 <td>Action</td>
           <%
             }  
           %>   
                
            </tr>
            
             
            <% 
                 for(Food f:l)
                 {
                	 int foodid=f.getFoodId();
                	 String foodname=f.getFoodName();
            %>
              <tr bgcolor="LavenderBlush">
                 <td style='color:black'><%=foodid%></td>
                 <td style='color:black'><%=foodname%></td>
                 <td style='color:black'><%=f.getFoodType() %></td>
                 <td style='color:black'><%=f.getFoodCategory() %></td>
                 <td style='color:black'><%=f.getFoodDescription() %></td>
                 <td style='color:black'><%=f.getPrice()%></td>
                 
                 
                  <% 
           if(user!=null && user=="Customer")
             {
           %>
               <td><a href="addToCart?foodId=<%=foodid %>&foodName=<%=foodname %>&price=<%=f.getPrice() %>">Add to Cart</a></td>                
               </tr>
           <%
             }  
           %>    
                 
             <% 
           if(user!=null && user=="Admin")
             {
           %>
               <td><a href="deleteFood?foodId=<%=foodid %>">Delete</a></td>
               <td><a href="updateFood?foodId=<%=foodid %>">Update</a></td>  
               </tr>
           <%
             }  
           %> 
           
            
                             
             
            <%
              }
            %>
           
            
        </table>
        <br>
        <a href="Index.jsp" align="center" style="color:MediumAquaMarine;">Go to Home</a>
             </fieldset>   
         </form>
</div>
         
</body>
</html>