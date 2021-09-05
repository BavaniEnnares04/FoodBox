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
<title>Total Customer</title>
</head>
<body>

<%
    List<Customer> l=new ArrayList<Customer>();
    CustomerDaoImp cd=new CustomerDaoImp();
    l=cd.getAllCustomer();
%>

<div align="center">
         <form  >
             <fieldset>
                       <legend style = "color: white"><b>Available Customers</b></legend>
                       
<%
String status=(String)request.getAttribute("status");
if(status!=null)
{
   out.println(status);	
}
%>
              
                        <table border="1" cellpadding="5">
            
            <tr bgcolor="RosyBrown">
                <td style='color:black'>Customer Id</td>
                <td style='color:black'>Customer Name</td>
                <td style='color:black'>Customer Email</td>
                <td style='color:black'>Customer Address</td>
                <td style='color:black'>Customer Contact</td>
                <td style='color:black'>Action</td>
                   
            </tr>
            
             
            <% 
                 for(Customer c:l)
                 {
                	 int Custid=c.getCustId();
            %>
              <tr bgcolor="LavenderBlush">
                 <td style='color:black'><%=Custid%></td>
                 <td style='color:black'><%=c.getCustName()%></td>
                 <td style='color:black'><%=c.getCustEmail() %></td>
                 <td style='color:black'><%=c.getCustAddress() %></td>
                 <td style='color:black'><%=c.getContactNo() %></td>
                 <td style='color:black'><a href="updateCustomer?custId=<%=Custid%>">Delete</a></td>
                        
                
             </tr>
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