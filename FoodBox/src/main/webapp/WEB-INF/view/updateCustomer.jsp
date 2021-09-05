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
<title>Update Customer</title>
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
	var cid=document.getElementById("custid").value;
	var cname=document.getElementById("custname").value;
	var cemail=document.getElementById("custemail").value;
	var caddress=document.getElementById("custAddress").value;
	var cContact=document.getElementById("custContact").value;

	if(cid=="")
	{
	 document.getElementById("cidError").innerHTML="Please enter Customer Id";
	 return false;
	}

    else
	{
	  document.getElementById("cidError").innerHTML="";
	}
	
	if(cname=="")
		{
		 document.getElementById("cnameError").innerHTML="Please enter name";
		  return false;
		}
	
	else
		{
		  document.getElementById("cnameError").innerHTML="";
		}
	
	if(cemail=="")
	{
	 document.getElementById("cemailError").innerHTML="Please enter Email";
	  return false;
	}

    else
	{
	  document.getElementById("cemailError").innerHTML="";
	}
	
	if(caddress=="")
	{
	 document.getElementById("cAddError").innerHTML="Please enter Address";
	  return false;
	}

    else
	{
	  document.getElementById("cAddError").innerHTML="";
	}
	
	if(cContact=="")
 	{
 	  document.getElementById("cContactError").innerHTML="Please enter Contact no";
	  return false;
	}

    else
	{
	  document.getElementById("cContactError").innerHTML="";
	}
	
	return true;
}

</script>
</head>
<body>
<br>
<div align="center">
         
         <form onsubmit="return validate()" action="updateCustomer" method="post">
            <fieldset>
            <legend style = "color: white">UPDATE CUSTOMER</legend>
            
            <%

            String status=(String)request.getAttribute("status");
            if(status!=null)
            {
               out.println(status);	
            }
            %>
            
            <%
                   Customer c=(Customer)request.getAttribute("Customer");
            %>
                  <table>
                      <tr>
                        <td>Customer Id : </td>
                        <td><input type="text" id="custid" name="cid" value=<%=c.getCustId() %> readonly></td>
                        <td><span style="color:white" id="cidError">*</span></td>
                      </tr>
                      <tr>
                        <td>Customer Name : </td>
                        <td><input type="text" id="custname" name="cname" value=<%=c.getCustName() %>></td>
                        <td><span style="color:white" id="cnameError">*</span></td>
                      </tr>
                      
                      <tr>
                        <td>Customer Email : </td>
                        <td><input type="email" id="custemail" name="cemail" value=<%=c.getCustEmail() %> readonly></td>
                        <td><span style="color:white" id="cemailError">*</span></td>
                      </tr>
                      
                      <tr>
                        <td>Customer Address : </td>
                        <td><input type="text" id="custAddress" name="caddress" value=<%=c.getCustAddress() %>></td>
                        <td><span style="color:white" id="cAddError">*</span></td>
                      </tr>
                      
                      <tr>
                        <td>Customer Contact No. : </td>
                        <td><input type="text" id="custContact" name="ccontact" value=<%=c.getContactNo() %>></td>
                        <td><span style="color:white" id="cContactError">*</span></td>
                      </tr>
                      
                      <%-- <tr>
                      	
                        <td><input type="submit" value="Update"/></td>
                        
                      </tr> --%>
                      
                  </table>
                  <p align="center">
                  <input type="submit" value="Update"/></p>
                  
                  <div style="text-align: center">
                  <a href="showMyProfile" style="color:MediumAquaMarine;">My Profile</a>&emsp;&emsp;
                  <a href="Index.jsp" style="color:MediumAquaMarine;">Go to Home</a>
                  </div>
            </fieldset>
         </form>
                         
     </div>
</body>
</html>