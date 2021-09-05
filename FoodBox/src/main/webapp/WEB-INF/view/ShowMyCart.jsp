<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.foodplaza.dao.*"%>
<%@ page import="com.foodplaza.model.*"%>
<%@ page import="java.util.*"%>
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
	String user = (String) session.getAttribute("usertype");
	String email = (String) session.getAttribute("USERNAME");
	List<Cart> l = new ArrayList<Cart>();
	CartDaoImp cd = new CartDaoImp();
	l = cd.showCart(email);
	%>

	<div align="center">
		<form>
			<fieldset>
				<legend style = "color: white">
					<b>My Cart</b>
				</legend>

				<%
				String status = (String) request.getAttribute("status");
				if (status != null) {
					out.println(status);
				}
				%>

				<table border="1" cellpadding="5">

					<tr bgcolor="RosyBrown">
						<td style='color:black'>Cart Id</td>
						<td style='color:black'>Food Id</td>
						<td style='color:black'>Food Name</td>
						<td style='color:black'>Quantity</td>
						<td style='color:black'>Price</td>
						<td style='color:black'>Action</td>
					</tr>


					<%
					for (Cart c : l) {
						int cartid = c.getCartId();
						int foodid = c.getFoodId();
					%>
					<tr bgcolor="LavenderBlush">
						<td style='color:black'><%=cartid%></td>
						<td style='color:black'><%=foodid%></td>
						<td style='color:black'><%=c.getFoodName()%></td>
						<td style='color:black'><%=c.getQuantity()%></td>
						<td style='color:black'><%=c.getPrice()%></td>
						<td style='color:black'><a href="deleteCart?cartId=<%=cartid%>">Delete</a></td>
					</tr>
					<%
					}
					%>



				</table>


			</fieldset>
		</form>
		<%
		String user1 = (String) session.getAttribute("usertype");
		%>
		<h3 style="color:white;">
			Total :
			<%=new CartDaoImp().totalPriceFromCart((String) session.getAttribute("USERNAME"))%></h3>
		<%-- <br> --%>


		<%
		if (user1 != null && user1 == "Customer" && l != null) {
		%>
		<form action="authorize_payment" method="post">
			<input type="submit" value="Order">
		</form>
		<br>
		<div align="center">
		<a href="clearCart" style="color:MediumAquaMarine;">Clear My Cart</a>&emsp;&emsp;
		<%
		}
		%>
		<a href="Index.jsp" style="color:MediumAquaMarine;">Go to Home</a>
		</div>
	</div>
</body>
</html>