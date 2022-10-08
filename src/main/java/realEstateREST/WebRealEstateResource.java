package realEstateREST;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("WebRealEstate")
public class WebRealEstateResource {
	
	
	
	
	
	//this method will calculate how much return you can get from your rental property
	
	//im using get because im not updating, or adding anything to the database
	//im just using the information from the user and return it.
	@GET
	@Path("/rent")
	@Produces(MediaType.APPLICATION_JSON)
	public String rentalProperty(
			@QueryParam("purchasePrice") double purchasePrice, 
			@QueryParam("downPayment") double downPayment,
			@QueryParam("interestRate") double interestRate,
			@QueryParam("amortizationPeriod") double amortizationPeriod,
			@QueryParam("monthlyRentProfit") double monthlyRentProfit){
		
		Rental rental = new Rental();

	
		
		  rental.setPurchasePrice(purchasePrice);
		  rental.setDownPayment(downPayment);
		  rental.setInterestRate(interestRate);
		  rental.setAmortizationPeriod(amortizationPeriod);	
		  rental.setMonthlyRentProfit(monthlyRentProfit);//sets how much over the mortgage monthly payments i want to rent out 
		  
		  rental.setMortgagePayments();//it will set the mortgage payment you need to pay to the bank
		  rental.setMonthlyRent();//what the tenant would pay
		  rental.setGrossRentalIncome();//it will calculate the gross rental income
		  rental.setNetRentalIncome();
		  
		  
		  
	  
		  return 
				  
				  
				  
		  "Your down payment is: $"  + rental.getDownPayment()+ ". That is " + rental.downPaymentPercentage()+"%" + "\n" +
		  "Your mortgage monthly payments would be: $" + rental.getMortgagePayments()+ "\n" +
		  "Our mortgage payments per year: $" + (rental.getMortgagePayments()*12) + "\n" +
		  "We would rent it to tenants monthly for  $" + rental.getMonthlyRent()  + "\n" +
		  "Our gross rental annual income would be: $" + rental.getGrossRentalIncome() + "\n" +
		  "Our profits per year for this property: $" +  rental.getNetRentalIncome();
		 
		 		  
	}
	
	//same as above but this one will return the values in HTML
	//it will display a form with our values.
	@GET
	@Path("/rent2")
	@Produces(MediaType.TEXT_HTML)
	public String rentalProperty2(
			@QueryParam("purchasePrice") double purchasePrice, 
			@QueryParam("downPayment") double downPayment,
			@QueryParam("interestRate") double interestRate,
			@QueryParam("amortizationPeriod") double amortizationPeriod,
			@QueryParam("monthlyRentProfit") double monthlyRentProfit){
		
		Rental rental = new Rental();

		  rental.setPurchasePrice(purchasePrice);
		  rental.setDownPayment(downPayment);
		  rental.setInterestRate(interestRate);
		  rental.setAmortizationPeriod(amortizationPeriod);	
		  rental.setMonthlyRentProfit(monthlyRentProfit);//sets how much over the mortgage monthly payments i want to rent out 
		  
		  rental.setMortgagePayments();//it will set the mortgage payment you need to pay to the bank
		  rental.setMonthlyRent();//what the tenant would pay
		  rental.setGrossRentalIncome();//it will calculate the gross rental income
		  rental.setNetRentalIncome();
		  
		  if(purchasePrice<=0) {
			  
			  
			  
			  return 
					  "<!DOCTYPE html>\r\n"
					  + "<html>\r\n"
					  + "<head>\r\n"
					  + "\r\n"
					  + "<meta charset=\"UTF-8\">\r\n"
					  + " <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					  + " <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					  + "\r\n"
					  + "<!-- bootstrap -->\r\n"
					  + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n"					 
					  + "\r\n"
					  + "<!-- jquery library and jsdelivr -->\r\n"
					  + "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
					  + "<script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\r\n"					 
					  + "\r\n"
					  
					  //javascript library in bootstrap
					  
					  + "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\r\n"
					  + "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>"
					  
					  
					  
					  + "\r\n"
					  + "\r\n"		
					  
					  
					  + "<!--  this is the style CSS  -->\r\n"
					  + "<style>\r\n"
					  + "	.divider:after,\r\n"
					  + ".divider:before {\r\n"
					  + "content: \"\";\r\n"
					  + "flex: 1;\r\n"
					  + "height: 1px;\r\n"
					  + "background: #eee;\r\n"
					  + "}\r\n"
					  + ".h-custom {\r\n"
					  + "height: calc(100% - 73px);\r\n"
					  + "}\r\n"
					  + "@media (max-width: 450px) {\r\n"
					  + ".h-custom {\r\n"
					  + "height: 100%;\r\n"
					  + "}\r\n"
					  + "}\r\n"
					  + "\r\n"
					  + ".form-label{\r\n"
					  + "font-size:15px;\r\n"
					  + "}\r\n"
					  + "\r\n"
					  + "p{\r\n"
					  + "font-size:15px;}\r\n"
					  + "\r\n"
					  + ".mb-3{\r\n"
					  + "	font-size:25px;\r\n"
					  + "}\r\n"
					  + ".profile{\r\n"
					  + "	font-size:20px;\r\n"
					  + "	background-color:black;\r\n"
					  + "	text-align: center;\r\n"
					  + "}\r\n"
					  + ".alert-warning{\r\n"
					  + "	font-size: 30px;\r\n"
					  + "}\r\n"
					  + ".font-weight-normal{\r\n"
					  + "	font-size:17px;\r\n"
					  + "}"
					  + "\r\n"
					  + "/* form button \"calculate profit\"  */\r\n"
					  + ".btn-lg{\r\n"
					  + "  font-size: 20px;\r\n"
					  + " \r\n"
					  + "}"
					  +"/* text under the title */\r\n"
					  + ".intro{\r\n"
					  + "  color: rgb(60, 5, 149);\r\n"
					  + "  font-weight: 500;\r\n"
					  + "}"
					  + "\r\n"
					  + "</style>\r\n"
					  
					  
					  + "\r\n"
					  + "\r\n"
					  + "<title>Real Estate Calculator</title>\r\n"
					  + "</head>\r\n"
					  + "<body>\r\n"
					  + "\r\n"
					  + "\r\n"
					  
					  //javascript alert
					  + "<div class=\"alert alert-warning\" role=\"alert\">\r\n"
					  + "<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\r\n"
					  + "  <strong>Warning!</strong> This could be dangerous, you are missing the purchase price! :D\r\n"
					  + "</div>"
					  
					  
					  + "	<section class=\"vh-100\">\r\n"
					  + "  <div class=\"container-fluid h-custom\">\r\n"
					  + "  \r\n"
					  + "    <div class=\"row d-flex justify-content-center align-items-center h-100\"> \r\n"
					  + "      <div class=\"col-md-9 col-lg-6 col-xl-5\">\r\n"
					  + "        <img src=\"https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp\"\r\n"
					  + "          class=\"img-fluid\" alt=\"Sample image\">\r\n"
					  + "      </div>\r\n"
					  + "      \r\n"
					  + "       <br>\r\n"
					  + "       <br>\r\n"
					  + "      \r\n"
					  + "      <div class=\"col-md-8 col-lg-6 col-xl-4 offset-xl-1\">     \r\n"
					  + "        <form method=\"get\" action=\"/RealEstateREST/rest/WebRealEstate/rent2\">\r\n"
					  + "          <div class=\"d-flex flex-row align-items-center justify-content-center justify-content-lg-start\">\r\n"
					  + "            <h1 style=\"color:blue\">Real Estate Calculator</h1><br>\r\n"
					  + "            \r\n"
					  + "          </div>\r\n"
					  + "\r\n"
					  + "         \r\n"
					  + "          \r\n"
					  + "          <div class=\"form-outline mb-4\">\r\n"
					  + "            <p class=\"intro\">Calculate how much money you can obtain from a potential rental property, by calculating your rental income and substracting your mortgage monthly payments </p>\r\n"
					  + "          \r\n"
					  + "            <input type=\"number\" name=\"purchasePrice\" id=\"form3Example3\" class=\"form-control form-control-lg\"\r\n"
					  + "              placeholder=\"Purchase Price in dollars\" />\r\n"
					  + "            <label class=\"form-label\" for=\"form3Example3\">Purchase Price of your property</label>\r\n"
					  + "            \r\n"
					  + "          </div>\r\n"
					  + "          \r\n"
					  + "           <div class=\"form-outline mb-4\">\r\n"
					  + "            <input type=\"number\" name=\"downPayment\" id=\"form3Example3\" class=\"form-control form-control-lg\"\r\n"
					  + "              placeholder=\"Down-payment in dollars\" value=" + Math.round(rental.getDownPayment()) +   " />\r\n"
					  + "            <label class=\"form-label\" for=\"form3Example3\">Down-payment</label>\r\n"
					  + "          </div>\r\n"
					  + "          \r\n"
					  + "           <div class=\"form-outline mb-4\">\r\n"
					  + "            <input type=\"number\" name=\"interestRate\" id=\"form3Example3\" class=\"form-control form-control-lg\"\r\n"
					  + "              placeholder=\"Interest Rate %\" value=" + rental.getInterestRate() +   " />\r\n"
					  + "            <label class=\"form-label\" for=\"form3Example3\">Interest Rate</label>\r\n"
					  + "          </div>\r\n"
					  + "          \r\n"
					  + "           <div class=\"form-outline mb-4\">\r\n"
					  + "            <input type=\"number\" name=\"amortizationPeriod\" id=\"form3Example3\" class=\"form-control form-control-lg\"\r\n"
					  + "              placeholder=\"Number of months it would take to pay the property\" value=" + Math.round(rental.getAmortizationPeriod()) +   " />\r\n"
					  + "            <label class=\"form-label\" for=\"form3Example3\">Amortization Period(months) Usually 300 months: </label>\r\n"
					  + "          </div>\r\n"
					  + "          \r\n"
					  + "           <div class=\"form-outline mb-4\">\r\n"
					  + "            <input type=\"number\" name=\"monthlyRentProfit\" id=\"form3Example3\" class=\"form-control form-control-lg\"\r\n"
					  + "              placeholder=\"Montly profit you would like to obtain in dollars\" value=" +  Math.round(rental.getMonthlyRentProfit()) +   " />\r\n"
					  + "            <label class=\"form-label\" for=\"form3Example3\">How much you would like to get monthly from renting your property?</label>\r\n"
					  + "          </div>\r\n"
					  + "\r\n"
					  + "         \r\n"
					  + "          <div class=\"text-center text-lg-start mt-4 pt-2\">\r\n"
					  + "            <button type=\"submit\" class=\"btn btn-primary btn-lg\"\r\n"
					  + "              style=\"padding-left: 2.5rem; padding-right: 2.5rem;\">Calculate my profits</button>\r\n"
					  + "              \r\n"
					  + "            \r\n"
					  + "          </div>\r\n"
					  + "\r\n"
					  + "        </form>\r\n"
					  + "      </div>\r\n"
					  + "    </div>\r\n"
					  + "  </div>\r\n"
					  + "  \r\n"
					  + "\r\n"
					  + "</section>\r\n"
					  + "\r\n"
					  + "</body>\r\n"
					  + "\r\n"
					  + "<!--  footer -->\r\n"
					  + "\r\n"
					  + "<footer class=\"text-white text-center text-lg-start bg-primary\">\r\n"
					  + "    <!-- Grid container -->\r\n"
					  + "    <div class=\"container p-4\">\r\n"
					  + "      <!--Grid row-->\r\n"
					  + "      <div class=\"row mt-4\">\r\n"
					  + "        <!--Grid column-->\r\n"
					  + "        <div class=\"col-lg-4 col-md-12 mb-4 mb-md-0\">\r\n"
					  + "          <h5 class=\"text-uppercase mb-4\">About my Web application :)</h5>\r\n"
					  + "  \r\n"
					  + "          <p>\r\n"
					  + "            Hello and I hope you are having fun looking at this calculator :)\r\n"
					  + "            \r\n"
					  + "          </p>\r\n"
					  + "  \r\n"
					  + "          <p>\r\n"
					  + "            More details:\r\n"
					  + "            The form data is sent to my HTTP endpoint, this HTTP GET method connects to my Java class, all calculations are done in that class. Then the HTTP GET method fetch the final results from my Java Class and return them back to the client in the form of HTML.\r\n"
					  + "\r\n"
					  + "          </p>\r\n"
					  + "  \r\n"
					  + "        </div>\r\n"
					  + "        <!--Grid column-->\r\n"
					  + "  \r\n"
					  + "        <!--Grid column-->\r\n"
					  + "        <div class=\"col-lg-4 col-md-6 mb-4 mb-md-0\">\r\n"
					  + "          <h5 class=\"profile\">Cesar Paredes --- Software Engineer</h5>\r\n"
					  + "          \r\n"
					  + "          <!-- Linkedin -->\r\n"
					  + "			<i class=\"fab fa-linkedin-in\"></i>\r\n"
					  + "  \r\n"
					  + "          \r\n"
					  + "  \r\n"
					  + "          <ul class=\"fa-ul\" style=\"margin-left: 1.65em;\">\r\n"
					  + "          <li class=\"mb-3\">\r\n"
					  + "              <a href=\"https://github.com/Cesar-Paredes\" target=\"_blank\" class=\"link-dark\">GitHub</a>\r\n"
					  + "            </li>\r\n"
					  + "            <li class=\"mb-3\">\r\n"
					  + "              <a href=\"https://www.linkedin.com/in/cesarparedes1/\" target=\"_blank\" class=\"text-white\">LinkedIn</a>\r\n"
					  + "            </li>\r\n"
					  + "            \r\n"
					  + "            \r\n"
					  + "          </ul>\r\n"
					  + "        </div>\r\n"
					  + "        <!--Grid column-->\r\n"
					  + "  \r\n"
					  + "        <!--Grid column-->\r\n"
					  + "        <div class=\"col-lg-4 col-md-6 mb-4 mb-md-0\">\r\n"
					  + "          <h5 class=\"text-uppercase mb-4\">Languages used in this web app</h5>\r\n"
					  + "  \r\n"
					  + "          <table class=\"table text-center text-white\">\r\n"
					  + "            <tbody class=\"font-weight-normal\">\r\n"
					  + "              <tr>\r\n"
					  + "                <td>Back-End:</td>\r\n"
					  + "                <td>REST architecture with JAVA JERSEY</td>\r\n"
					  + "              </tr>\r\n"
					  + "              <tr>\r\n"
					  + "                <td>Front-End</td>\r\n"
					  + "                <td>Bootstrap CSS, HTML and some JS</td>\r\n"
					  + "              </tr>\r\n"
					  + "              \r\n"
					  + "            </tbody>\r\n"
					  + "          </table>\r\n"
					  + "        </div>\r\n"
					  + "        <!--Grid column-->\r\n"
					  + "      </div>\r\n"
					  + "      <!--Grid row-->\r\n"
					  + "    </div>\r\n"
					  + "    <!-- Grid container -->\r\n"
					  + "  \r\n"
					  + "    <!-- Copyright -->\r\n"
					  + "    <div class=\"text-center p-3\" style=\"background-color: rgba(0, 0, 0, 0.2);\">\r\n"
					  + "      © 2022 Copyright\r\n"
					  + "      \r\n"
					  + "    </div>\r\n"
					  + "    <!-- Copyright -->\r\n"
					  + "  </footer>\r\n"
					  + "  \r\n"
					  + "\r\n"
					  + "\r\n"
					  + "\r\n"
					  + "</html>";
					  
			  
		  }
		  
		  
		  
	  
		  return 
				 "<!DOCTYPE html>\r\n"
				 + "<html>\r\n"
				 + "<head>\r\n"
				 + "\r\n"
				 + "<meta charset=\"UTF-8\">\r\n"
				 + " <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				 + " <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				 + "\r\n"
				 + "<!-- bootstrap -->\r\n"
				 + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n"
				 + "<!-- <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\r\n"
				 + "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script> -->\r\n"
				 + "\r\n"
				 + "<!-- jquery library and jsdelivr -->\r\n"
				 + "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
				 + "<script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\r\n"
				 + "<!-- <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\"></script> -->\r\n"
				 + "\r\n"
				 + "\r\n"
				 + "<!--  this is the style CSS  -->\r\n"
				 + "<style>\r\n"
				 + "	.divider:after,\r\n"
				 + ".divider:before {\r\n"
				 + "content: \"\";\r\n"
				 + "flex: 1;\r\n"
				 + "height: 1px;\r\n"
				 + "background: #eee;\r\n"
				 + "}\r\n"
				 + ".h-custom {\r\n"
				 + "height: calc(100% - 73px);\r\n"
				 + "}\r\n"
				 + "@media (max-width: 450px) {\r\n"
				 + ".h-custom {\r\n"
				 + "height: 100%;\r\n"
				 + "}\r\n"
				 + "}\r\n"
				 + "\r\n"
				 + ".form-label{\r\n"
				 + "font-size:15px;\r\n"
				 + "}\r\n"
				 + "\r\n"
				 + "p{\r\n"
				 + "font-size:15px;}\r\n"
				 + "\r\n"
				 + ".mb-3{\r\n"
				 + "	font-size:25px;\r\n"
				 + "}\r\n"
				 + ".profile{\r\n"
				 + "	font-size:20px;\r\n"
				 + "	background-color:black;\r\n"
				 + "	text-align: center;\r\n"
				 + "}\r\n"
				 + "\r\n"
				 + ".font-weight-normal{\r\n"
				 + "	font-size:17px;\r\n"
				 + "}\r\n"
				 + "\r\n"
				 + ".list-group{\r\n"
				 + "  margin-top: 100px;\r\n"
				 + "  font-size: 20px;\r\n"
				 + "}\r\n"
				 + "\r\n"
				 + ".list-group p{\r\n"
				 + "  font-size: 20px;\r\n"
				 + "}\r\n"
				 + "\r\n"
				 + ".btn-lg{\r\n"
				 + "  font-size: 20px;\r\n"
				 + " \r\n"
				 + "}\r\n"
				 + "\r\n"
				 + ".justify-content-lg-start h1{\r\n"
				 + "  font-size: 40px;\r\n"
				 + "  color:blue;\r\n"
				 + "}\r\n"
				 + "\r\n"
				 + ".intro{\r\n"
				 + "  color: rgb(60, 5, 149);\r\n"
				 + "  font-weight: 500;\r\n"
				 + "}\r\n"
				 + "\r\n"
				 + ".bg-primary{\r\n"
				 + "  margin-top: 500px;\r\n"
				 + "}\r\n"
				 + "\r\n"
				 + "</style>\r\n"
				 + "\r\n"
				 + "\r\n"
				 + "<title>Real Estate Calculator</title>\r\n"
				 + "</head>\r\n"
				 + "<body>\r\n"
				 + "\r\n"
				 + "\r\n"
				 + "	<section class=\"vh-100\">\r\n"
				 + "  <div class=\"container-fluid h-custom\">\r\n"
				 + "    \r\n"
				 + "  \r\n"
				 + "    <div class=\"row d-flex justify-content-center align-items-center h-100\"> \r\n"
				 + "      <div class=\"col-md-9 col-lg-6 col-xl-5\">\r\n"
				 + "        <img src=\"https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp\"\r\n"
				 + "          class=\"img-fluid\" alt=\"Sample image\">\r\n"
				 + "   \r\n"
				 + "      </div>\r\n"
				 + "      \r\n"
				 + "      <div class=\"col-md-8 col-lg-6 col-xl-4 offset-xl-1\">     \r\n"
				 + "        <form method=\"get\" action=\"/RealEstateREST/rest/WebRealEstate/rent2\">\r\n"
				 + "          <div class=\"d-flex flex-row align-items-center justify-content-center justify-content-lg-start\">\r\n"
				 + "            <h1>Real Estate Calculator</h1><br>\r\n"
				 + "            \r\n"
				 + "          </div>\r\n"
				 + "\r\n"
				 + "         \r\n"
				 + "          \r\n"
				 + "          <div class=\"form-outline mb-4\">\r\n"
				 + "            <p class=\"intro\">Calculate how much money you can obtain from a potential rental property, by calculating your rental income and substracting your mortgage monthly payments </p>\r\n"
				 + "          \r\n"
				 + "            <input type=\"number\" name=\"purchasePrice\" id=\"form3Example3\" class=\"form-control form-control-lg\"\r\n"
				 + "              placeholder=\"Purchase Price in dollars\"  value= " + Math.round(rental.getPurchasePrice()) +   " />\r\n"
				 + "            <label class=\"form-label\" for=\"form3Example3\">Purchase Price of your property</label>\r\n"
				 + "            \r\n"
				 + "          </div>\r\n"
				 + "          \r\n"
				 + "           <div class=\"form-outline mb-4\">\r\n"
				 + "            <input type=\"number\" name=\"downPayment\" id=\"form3Example3\" class=\"form-control form-control-lg\"\r\n"
				 + "              placeholder=\"Down-payment in dollars\" value=" + Math.round(rental.getDownPayment()) +   "  />\r\n"
				 + "            <label class=\"form-label\" for=\"form3Example3\">Down-payment</label>\r\n"
				 + "          </div>\r\n"
				 + "          \r\n"
				 + "           <div class=\"form-outline mb-4\">\r\n"
				 + "            <input type=\"number\" name=\"interestRate\" id=\"form3Example3\" class=\"form-control form-control-lg\"\r\n"
				 + "              placeholder=\"Interest Rate %\" value=" + Math.round(rental.getInterestRate()) +   "  />\r\n"
				 + "            <label class=\"form-label\" for=\"form3Example3\">Interest Rate</label>\r\n"
				 + "          </div>\r\n"
				 + "          \r\n"
				 + "           <div class=\"form-outline mb-4\">\r\n"
				 + "            <input type=\"number\" name=\"amortizationPeriod\" id=\"form3Example3\" class=\"form-control form-control-lg\"\r\n"
				 + "              placeholder=\"Number of months it would take to pay the property\" value=" + Math.round(rental.getAmortizationPeriod()) +   " />\r\n"
				 + "            <label class=\"form-label\" for=\"form3Example3\">Amortization Period(months) Usually 300 months: </label>\r\n"
				 + "          </div>\r\n"
				 + "          \r\n"
				 + "           <div class=\"form-outline mb-4\">\r\n"
				 + "            <input type=\"number\" name=\"monthlyRentProfit\" id=\"form3Example3\" class=\"form-control form-control-lg\"\r\n"
				 + "              placeholder=\"Montly profit you would like to obtain in dollars\" value= " + Math.round(rental.getMonthlyRentProfit()) +   "  />\r\n"
				 + "            <label class=\"form-label\" for=\"form3Example3\">How much would you like to get monthly from renting your property?</label>\r\n"
				 + "          </div>\r\n"
				 + "\r\n"
				 + "         \r\n"
				 + "          <div class=\"text-center text-lg-start mt-4 pt-2\">\r\n"
				 + "            <button type=\"submit\" class=\"btn btn-primary btn-lg\"\r\n"
				 + "              style=\"padding-left: 2.5rem; padding-right: 2.5rem;\">Calculate my profit</button>\r\n"
				 + "                 \r\n"
				 + "            </div>\r\n"
				 
				 
				 //list
				 
				 + "            <ul class=\"list-group\">\r\n"
				 + "              <p style=\"font-weight: 900;\">Your payments: </p>\r\n"
				 + "              <li class=\"list-group-item\">Mortgage monthly payments: $" +  Math.round(rental.getMortgagePayments())  + "</li>\r\n"
				 + "              <li class=\"list-group-item\">Mortgage annual payments: $"  +  Math.round(rental.getMortgagePayments())* 12 +  " </li>\r\n"
				 + "              <br>\r\n"
				 + "              <p style=\"font-weight: 900;\">Property rental price to achieve $" + rental.getMonthlyRentProfit()  + " net income per month</p>\r\n"
				 + "              <li class=\"list-group-item\">Rent your property for: $" + Math.round(rental.getMonthlyRent()) +  "</li>\r\n"
				 + "              <li class=\"list-group-item\">Your gross rental income would be: $" + Math.round(rental.getGrossRentalIncome()) + "</li>\r\n"
				 + "               <li class=\"list-group-item\">Your annual net income would be: $" + Math.round(rental.getNetRentalIncome())  + " </li>\r\n"
				 + "            </ul>\r\n"
				 + "            <div>\r\n"
				 + "          \r\n"
				 
				 
				 
				 + "\r\n"
				 + "          </div>\r\n"
				 + "        </form>\r\n"
				 + "        <br>       \r\n"
				 + "      </div>\r\n"
				 + "    </div>\r\n"
				 + "  </div>\r\n"
				 + "\r\n"
				 + "</section>\r\n"
				 + "\r\n"
				 + "\r\n"
				 + "\r\n"
				 + "</body>\r\n"
				 + "\r\n"
				 + "<!--  footer -->\r\n"
				 + "\r\n"
				 + "<footer class=\"text-white text-center text-lg-start bg-primary\">\r\n"
				 + "    <!-- Grid container -->\r\n"
				 + "    <div class=\"container p-4\">\r\n"
				 + "      <!--Grid row-->\r\n"
				 + "      <div class=\"row mt-4\">\r\n"
				 + "        <!--Grid column-->\r\n"
				 + "        <div class=\"col-lg-4 col-md-12 mb-4 mb-md-0\">\r\n"
				 + "          <h5 class=\"text-uppercase mb-4\">About my Web application :)</h5>\r\n"
				 + "  \r\n"
				 + "          <p>\r\n"
				 + "            Hello and I hope you are having fun looking at this calculator :)\r\n"       
				 + "          </p>\r\n"
				 + "  \r\n"
				 + "          <p>\r\n"
				 + "            Details:\r\n"
				 + "            The form data is sent to my HTTP endpoint, this HTTP GET method connects to my Java class, all calculations are done in that class. Then the HTTP GET method fetch the final results from my Java Class and return them back to the client in the form of HTML.\r\n"
				 + ".\r\n"
				 + "          </p>\r\n"
				 + "  \r\n"
				 + "        </div>\r\n"
				 + "        <!--Grid column-->\r\n"
				 + "  \r\n"
				 + "        <!--Grid column-->\r\n"
				 + "        <div class=\"col-lg-4 col-md-6 mb-4 mb-md-0\">\r\n"
				 + "          <h5 class=\"profile\">Cesar Paredes --- Software Engineer</h5>\r\n"
				 + "          \r\n"
				 + "          <!-- Linkedin -->\r\n"
				 + "			<i class=\"fab fa-linkedin-in\"></i>\r\n"
				 + "  \r\n"
				 + "          \r\n"
				 + "  \r\n"
				 + "          <ul class=\"fa-ul\" style=\"margin-left: 1.65em;\">\r\n"
				 + "          <li class=\"mb-3\">\r\n"
				 + "              <a href=\"https://github.com/Cesar-Paredes\" target=\"_blank\" class=\"link-dark\">GitHub</a>\r\n"
				 + "            </li>\r\n"
				 + "            <li class=\"mb-3\">\r\n"
				 + "              <a href=\"https://www.linkedin.com/in/cesarparedes1/\" target=\"_blank\" class=\"text-white\">LinkedIn</a>\r\n"
				 + "            </li>\r\n"
				 + "            \r\n"
				 + "            \r\n"
				 + "          </ul>\r\n"
				 + "        </div>\r\n"
				 + "        <!--Grid column-->\r\n"
				 + "  \r\n"
				 + "        <!--Grid column-->\r\n"
				 + "        <div class=\"col-lg-4 col-md-6 mb-4 mb-md-0\">\r\n"
				 + "          <h5 class=\"text-uppercase mb-4\">Languages used in this web app</h5>\r\n"
				 + "  \r\n"
				 + "          <table class=\"table text-center text-white\">\r\n"
				 + "            <tbody class=\"font-weight-normal\">\r\n"
				 + "              <tr>\r\n"
				 + "                <td>Back-End:</td>\r\n"
				 + "                <td>REST architecture with JAVA JERSEY</td>\r\n"
				 + "              </tr>\r\n"
				 + "              <tr>\r\n"
				 + "                <td>Front-End</td>\r\n"
				 + "                <td>Bootstrap CSS, HTML and some JS</td>\r\n"
				 + "              </tr>\r\n"
				 + "              \r\n"
				 + "            </tbody>\r\n"
				 + "          </table>\r\n"
				 + "        </div>\r\n"
				 + "        <!--Grid column-->\r\n"
				 + "      </div>\r\n"
				 + "      <!--Grid row-->\r\n"
				 + "    </div>\r\n"
				 + "    <!-- Grid container -->\r\n"
				 + "  \r\n"
				 + "    <!-- Copyright -->\r\n"
				 + "    <div class=\"text-center p-3\" style=\"background-color: rgba(0, 0, 0, 0.2);\">\r\n"
				 + "      © 2022 Copyright\r\n"
				 + "      \r\n"
				 + "    </div>\r\n"
				 + "    <!-- Copyright -->\r\n"
				 + "  </footer>\r\n"
				 + "  \r\n"
				 + "</html>";
		 		  
	}
	
	
	
	
	
//	
	//this is a simple method that will tell you how much is you municipal property annual taxes
	//in your area.
	
		@GET
		@Path("annualTaxes/")
		@Produces(MediaType.APPLICATION_JSON)
		public String rentalProperty2(
				@QueryParam("location") String location) {
			
			AnnualTaxes taxes = new AnnualTaxes();
			
			if(location.equalsIgnoreCase("montreal west" )) {
				return "According to our database: " + location + " - $"+ taxes.getMontrealWest() + " annual property taxes.";
			}
			
			else if(location.equalsIgnoreCase("montreal east" )) {
				return   "According to our database: " + location + " - $" + taxes.getMontrealEast()+" annual property taxes.";
			}
				
			else if(location.equalsIgnoreCase("montreal north" )) {
				return  "According to our database: " + location + " - $" + taxes.getMontrealNorth()+" annual property taxes.";
			}
			else if(location.equalsIgnoreCase("vaudreuil" )) {
				return  "According to our database: " + location + " - $" +  taxes.getVaudreuil()+" annual property taxes.";
			}
			
			else if(location.equalsIgnoreCase("laval" )) {
				return "According to our database: " + location + " - $" + taxes.getLaval()+" annual property taxes.";
			}
			
			return "Your area was not found in our database, please try again!";			 		 
		}
		
		
		//this will let the user help us CREATE our annual tax database according to the area
		@POST
		@Path("annualTaxesCreate/")
		@Produces(MediaType.APPLICATION_JSON)
		public String rentalProperty3(
				@FormParam("location") String location,
				@FormParam("annualTaxes") double annualTaxes){
			
			AnnualTaxes taxes = new AnnualTaxes();
			
			if(location.equalsIgnoreCase("montreal west" )) {
				taxes.setMontrealWest(annualTaxes);
				return "Thank you for contributing to our database: " + location + " - $" + taxes.getMontrealWest() + " annual property taxes.";
			}
			
			else if(location.equalsIgnoreCase("montreal east" )) {
				taxes.setMontrealEast(annualTaxes);
				return "Thank you for contributing to our database: "  + location + " - $" + taxes.getMontrealEast()+" annual property taxes.";
			}
				
			else if(location.equalsIgnoreCase("montreal north" )) {
				 taxes.setMontrealNorth(annualTaxes);
				 return "Thank you for contributing to our database: "  + location + " - $" + taxes.getMontrealNorth()+" annual property taxes.";
			}
			else if(location.equalsIgnoreCase("vaudreuil" )) {
				 taxes.setVaudreuil(annualTaxes);
				 return "Thank you for contributing to our database: "  + location + " - $" + taxes.getVaudreuil()+" annual property taxes.";
			}
			
			else if(location.equalsIgnoreCase("laval" )) {
				 taxes.setLaval(annualTaxes);
				 return "Thank you for contributing to our database: " + taxes.getLaval()+" annual property taxes.";
			}
			
			return "Your area was not found in our database, please try again!";			 		 
		}
}

		
		

	  
	   
	   

	   
	   
	   
	   
	   
	   

