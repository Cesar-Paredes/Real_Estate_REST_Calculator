<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>

 rental.setPurchasePrice(purchasePrice);
		  rental.setDownPayment(downPayment);
		  rental.setInterestRate(interestRate);
		  rental.setAmortizationPeriod(amortizationPeriod);	
		  rental.setMonthlyRentProfit(monthlyRentProfit);//sets how much over the mortgage monthly payments i want to rent out 
		  
		  rental.setMortgagePayments();//it will set the mortgage payment you need to pay to the bank
		  rental.setMonthlyRent();//what the tenant would pay
		  rental.setGrossRentalIncome();//it will calculate the gross rental income
		  rental.setNetRentalIncome();
		  
		   <input type=\"number\" name=\"purchasePrice\" id=\"form3Example3\" class=\"form-control form-control-lg\"\r\n"
				 + "              placeholder=\"Purchase Price in dollars\" value=\" " +  8999  +   "\"   />\r\n"