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
<title>My Cart</title>
</head>
<body>
<%
    String user=(String)session.getAttribute("usertype");
    String email=(String)session.getAttribute("USERNAME");
    List<Order> l=new ArrayList<Order>();
    OrderDaoImp cd=new OrderDaoImp();
    l=cd.showOrder(email);
%>

<div align="center">
         <form  >
             <fieldset>
                       <legend style = "color: white"><b>My Orders</b></legend>
                       
<%
String status=(String)request.getAttribute("status");
if(status!=null)
{
   out.println(status);	
}
%>

              <table border="1" cellpadding="5">
              
            <tr bgcolor="RosyBrown">
                <td style='color:black'>Order Id</td>
                <td style='color:black'>Food Id</td>
                <td style='color:black'>Quantity</td>
                <td style='color:black'>email</td>
                <td style='color:black'>Date</td>
                <td style='color:black'>Price</td> 
            </tr>
            
             
            <% 
                 for(Order c:l)
                 {
                	 int orderid=c.getOrderId();
                	 int foodid=c.getFoodId();
            %>
              <tr bgcolor="LavenderBlush">
                 <td style='color:black'><%=orderid%></td>
                 <td style='color:black'><%=foodid%></td>
                 <td style='color:black'><%=c.getQuantity()%></td>
                 <td style='color:black'><%=c.getEmail()%></td>
                 <td style='color:black'><%=c.getDate()%></td>
                 <td style='color:black'><%=c.getTotalBill()%></td>
               </tr>
           <%
             }  
           %>    
           
           
            
        </table>
        <hr>
        <h3 style="color:white;">Delivery Date : <%if(cd.getDelivery(email)!=null){ %><%=cd.getDelivery(email)%><%} else{%>processing...<%} %></h3>
<%

 String user1=(String)session.getAttribute("usertype");
%>
    <h3 style="color:white;">Total : <%=new OrderDaoImp().totalPriceFromOrder((String)session.getAttribute("USERNAME")) %></h3>
    <br>
	<div align="center">
   <a href="Index.jsp" style="color:MediumAquaMarine;">Go to Home</a>
    </div>
             </fieldset>   
         </form>
</div>
</body>
</html>