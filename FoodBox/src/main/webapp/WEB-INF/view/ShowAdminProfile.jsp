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
<title>Admin Profile</title>
</head>
<body>
<%
    String email=(String)session.getAttribute("USERNAME");
    AdminDaoImp ad=new AdminDaoImp();
    Admin a=ad.getAdminById(email);
%>

<div align="center">
         <form  >
             <fieldset>
                       <legend style = "color: white"><b>Admin Profile</b></legend>
                       
<%
String status=(String)request.getAttribute("status");
if(status!=null)
{
   out.println(status);	
}
%>
              
                        <table border="1" cellpadding="5">
            
            <tr bgcolor="RosyBrown">
                <td style='color:black'>Admin Id</td>
                <td style='color:black'>Admin Name</td>
                <td style='color:black'>Admin Email</td>
                <td style='color:black'>Admin Address</td>
                <td style='color:black'>Admin Contact</td>
                <td style='color:black'>Action</td>
                   
            </tr>
            
             
         
              <tr bgcolor="LavenderBlush">
                 <td style='color:black'><%=a.getAdminId()%></td>
                 <td style='color:black'><%=a.getAdminName()%></td>
                 <td style='color:black'><%=a.getAdminEmail() %></td>
                 <td style='color:black'><%=a.getAdminAddress() %></td>
                 <td style='color:black'><%=a.getAdminContact() %></td>
                 <td style='color:black'><a href="updateAdmin?adminId=<%=a.getAdminId() %>">Update</a></td>  
             </tr>
           
            
        </table>
        <br>
        <a href="Index.jsp" align="center" style="color:MediumAquaMarine;">Go to Home</a>
             </fieldset>   
         </form>
</div>

</body>
</html>