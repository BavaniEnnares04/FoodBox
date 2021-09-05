<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Receipt</title>
<style type="text/css">
table {
	border: 0;
}

table td {
	padding: 5px;
}
</style>
</head>
<body>
	<div align="center">
		<h1>Payment Done. Thank you for purchasing our foods</h1>
	</div>
	
		<div align="center">
			
				<h3>Receipt Details:</h3>
			
								<table class="table">
						<thead>
							<tr>
								<th>Merchant:</th>
								<td>FOOD PLAZA</td>
							</tr>
							<tr>
								<th>Payer:</th>
								<td>${payer.firstName}</td>
							</tr>

							<tr>
								<th>Subtotal:</th>
								<td>${transaction.amount.details.subtotal}USD</td>
							</tr>
							<tr>
								<th>Shipping:</th>
								<td>${transaction.amount.details.shipping}USD</td>
							</tr>
							<tr>
								<th>Tax:</th>
								<td>${transaction.amount.details.tax}USD</td>
							</tr>
							<tr>
								<th>Total:</th>
								<td>${transaction.amount.total}USD</td>
							</tr>
						</thead>
					</table>
				</div>

				<div align="center">
					<a href="Index.jsp"><button>Order
							More</button></a>
				</div>
		
	
</body>
</html>