<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<body background = "C:\Users\Bavani_Ennares_Mania\Documents\Full Stack Developer\Final Project\FoodPlaza-20210901T061139Z-001\FoodPlaza\src\main\webapp\images\background1.jpg">
</body>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>
   fieldset
   {
      border:2px solid black;
    -moz-border-radius:8px;
    -webkit-border-radius:8px;	
    border-radius:16px;
    background-color: SlateGray;
   }
</style>
<script type="text/javascript">
function validate()
{
	var userEmail=document.getElementById("userid").value;
	var userPass=document.getElementById("userpass").value;
	
	if(userEmail=="")
		{
		  document.getElementById("useridError").innerHTML="Please enter Email id";
		  return false;
		}
	
	else
		{
		  document.getElementById("useridError").innerHTML=("");
		}
	
	if(userPass=="")
	{
	  document.getElementById("userpassError").innerHTML="Please enter password";
	  return false;
	}
	
	else
	{
	  document.getElementById("userpassError").innerHTML=("");
	}
}
</script>
</head>
<body>

   <div align="center">
      <h1 style="color:white">FOOD BOX</h1>
      
<%
String status=(String)request.getAttribute("status");
if(status!=null)
{
   out.println(status);	
}
%>
         <form onsubmit="return validate()" action="login" method="post">
            <fieldset>
            <legend style = "color: white">Login</legend>
                  <table>
                       
                       <tr>
                        <td><INPUT TYPE="radio" NAME="type" VALUE="Customer">Customer</td>
                        <td><INPUT TYPE="radio" NAME="type" VALUE="Admin">Admin</td>
                       
                      </tr>
                       
                      <tr>
                        <td>Email Id : </td>
                        <td><input type="email" id="userid" name="email" placeholder="Enter Email-Id"></td>
                        <td><span id="useridError" style="color:white">*</span></td>
                      </tr>
                      
                      <tr>
                        <td>Password : </td>
                        <td><input type="password" id="userpass" name="pass" placeholder="Enter password"></td>
                        <td><span id="userpassError" style="color:white">*</span></td>
                      </tr>
                      
                      <%--<tr>
                        <td><a href="forgotPassword" style="color:white">Forgot Password</a></td>
                        <td><input type="submit" value="login" style="float: right;"></td>
                      </tr> --%>                 
                  </table>
                  <p align="center"><input type="submit" value="login"></p>
                  <div style="text-align: center">
                  <a href="forgotPassword" style="color:MediumAquaMarine;">Forgot Password</a>&emsp;&emsp;
                  <a href="Index.jsp" style="color:MediumAquaMarine;">Go to Home</a>
                  </div>
                  <%-- <a href="Index.jsp" align="center" style="color:MediumAquaMarine;">Go to Home</a> --%>
            </fieldset>
         </form>
                         
     </div>
</body>
</html>