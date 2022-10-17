package realEstateREST;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

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
	
	
	//return the values in HTML
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
		  
		  rental.setMonthlyMortgagePayments();//it will set the mortgage payment you need to pay to the bank
		  rental.setMonthlyRentTenantPay();//what the tenant would pay
		  rental.setGrossAnnualRentalIncome();//it will calculate the gross rental income
		  rental.setAnnualNetRentalIncome();
		  rental.setMortgageAnnualPayments();
		  
		  //if purchasePrice is left blank, it would be 0 and we would set up an error message to the user
		  if(purchasePrice<=0) {
			    
			  String rawString =  
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
					  
					  //CSS
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
					  +"/* footer  */\r\n"
					  + ".bg-primary{\r\n"
					  + "	margin-top: 200px;\r\n"
					  + "}"
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
					  + " <p>\r\n"
					  + "           Hello, and I hope you are having fun looking at this calculator :)         \r\n"
					  + "          </p>\r\n"
					  + "          \r\n"
					  + "          <p>System environment:</p>\r\n"
					  + "         \r\n"
					  + "          <p>        	\r\n"
					  + "          	I used Digital Ocean for my hosting services, unfortunately, they don't have the auto-deploy option for Java web apps so I had to do everything myself from the Ubuntu console which was great because \r\n"
					  + "          	I had the chance to practice my Linux skills :)\r\n"
					  + "          </p>\r\n"
					  + "          \r\n"
					  + "          \r\n"
					  + "          <p>\r\n"
					  + "            Details:<br>\r\n"
					  + "            The form data is sent to my HTTP endpoint, this HTTP GET method \r\n"
					  + "            connects to my Java class, and all calculations are done in that class. \r\n"
					  + "            Then the HTTP GET method fetches the final results from my Java Class and returns them to the client \r\n"
					  + "            in the form of HTML.\r\n"
					  + "          </p>"
					  + "  \r\n"
					  + "        </div>\r\n"
					  + "        <!--Grid column-->\r\n"
					  + "  \r\n"
					  + "        <!--Grid column-->\r\n"
					  + "        <div class=\"col-lg-4 col-md-6 mb-4 mb-md-0\">\r\n"
					  + "          <h5 class=\"profile\">$Cesar Paredes [\"Software Developer\"]</h5>\r\n"
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
					  + " 			<li class=\"mb-3\">\r\n"
					  + "              <a href=\"https://github.com/Cesar-Paredes/Real_Estate_REST_Calculator\" target=\"_blank\" style=\"color:orange\">CODE for this Web App</a>\r\n"
					  + "            </li>"
					  + "            \r\n"
					  + "          </ul>\r\n"
					  + "        </div>\r\n"
					  + "        <!--Grid column-->\r\n"
					  + "  \r\n"
					  + "        <!--Grid column-->\r\n"
					  + "<div class=\"col-lg-4 col-md-6 mb-4 mb-md-0\">\r\n"
					  + "          <h5 class=\"text-uppercase mb-4\">Languages used in this web app</h5>\r\n"
					  + "  \r\n"
					  + "          <table class=\"table text-center text-white\">\r\n"
					  + "            <tbody class=\"font-weight-normal\">\r\n"
					  + "              <tr>\r\n"
					  + "                <td>Back-End:</td>\r\n"
					  + "                <td>REST architecture, JAVA JERSEY, Linux Ubuntu OS</td>\r\n"
					  + "              </tr>\r\n"
					  + "              <tr>\r\n"
					  + "                <td>Front-End</td>\r\n"
					  + "                <td>HTML, CSS, Bootstrap and JS</td>\r\n"
					  + "              </tr>\r\n"
					  + "            </tbody>     \r\n"
					  + "          </table>\r\n"
					  + "          \r\n"
					  + "           <h3>Steps on the server Ubuntu console command line:</h3>\r\n"
					  + "          <ul>\r\n"
					  + "          	        	\r\n"
					  + "          	<li><p>Set up the Java environment by installing JDK and JRE 11.</p></li>\r\n"
					  + "          	<li><p>Install maven.</p></li>\r\n"
					  + "          	<li><p>Clone the Payara glassfish server  6 (6.2.3) using Git commands.</p></li>\r\n"
					  + "          	<li><p>Execute a maven build.</p></li>\r\n"
					  + "          	<li><p>Use Payara glassfish to deploy my project.</p></li>\r\n"
					  + "                 \r\n"
					  + "          </ul>\r\n"
					  + "          \r\n"
					  + "          \r\n"
					  + "        </div>"
					  + "        <!--Grid column-->\r\n"
					  + "      </div>\r\n"
					  + "      <!--Grid row-->\r\n"
					  + "    </div>\r\n"
					  + "    <!-- Grid container -->\r\n"
					  + "  \r\n"
					  + "    <!-- Copyright -->\r\n"
					  + "    <div class=\"text-center p-3\" style=\"background-color: rgba(0, 0, 0, 0.2);\">\r\n"
					  + "      � 2022 Copyright - Cesar Paredes\r\n"
					  + "      \r\n"
					  + "    </div>\r\n"
					  + "    <!-- Copyright -->\r\n"
					  + "  </footer>\r\n"
					  + "  \r\n"
					  + "\r\n"
					  + "\r\n"
					  + "\r\n"
					  + "</html>";
			  
			  ByteBuffer buffer = StandardCharsets.UTF_8.encode(rawString); 
			  String utf8EncodedString = StandardCharsets.UTF_8.decode(buffer).toString();
			  
			  return utf8EncodedString;
			  
		  }
		  
	  
		  String rawString =  
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
				 + "              <li class=\"list-group-item\">Mortgage monthly payments: $" +  Math.round(rental.getMonthlyMortgagePayments())  + "</li>\r\n"
				 + "              <li class=\"list-group-item\">Mortgage annual payments: $"  +  Math.round(rental.getMortgageAnnualPayments()) +  " </li>\r\n"
				 + "              <br>\r\n"
				 + "              <p style=\"font-weight: 900;\">Property rental price to achieve $" + rental.getMonthlyRentProfit()  + " net income per month</p>\r\n"
				 + "              <li class=\"list-group-item\">Rent your property for: $" + Math.round(rental.getMonthlyRentTenantPay()) +  "</li>\r\n"
				 + "              <li class=\"list-group-item\">Your gross rental income would be: $" + Math.round(rental.getGrossAnnualRentalIncome()) + "</li>\r\n"
				 + "               <li class=\"list-group-item\">Your annual net income would be: $" + Math.round(rental.getAnnualNetRentalIncome())  + " </li>\r\n"
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
				  + " <p>\r\n"
				  + "           Hello, and I hope you are having fun looking at this calculator :)         \r\n"
				  + "          </p>\r\n"
				  + "          \r\n"
				  + "          <p>System environment:</p>\r\n"
				  + "         \r\n"
				  + "          <p>        	\r\n"
				  + "          	I used Digital Ocean for my hosting services, unfortunately, they don't have the auto-deploy option for Java web apps so I had to do everything myself from the Ubuntu console which was great because \r\n"
				  + "          	I had the chance to practice my Linux skills :)\r\n"
				  + "          </p>\r\n"
				  + "          \r\n"
				  + "          \r\n"
				  + "          <p>\r\n"
				  + "            Details:<br>\r\n"
				  + "            The form data is sent to my HTTP endpoint, this HTTP GET method \r\n"
				  + "            connects to my Java class, and all calculations are done in that class. \r\n"
				  + "            Then the HTTP GET method fetches the final results from my Java Class and returns them to the client \r\n"
				  + "            in the form of HTML.\r\n"
				  + "          </p>"
				  + "  \r\n"
				  + "        </div>\r\n"
				  + "        <!--Grid column-->\r\n"
				  + "  \r\n"
				  + "        <!--Grid column-->\r\n"
				  + "        <div class=\"col-lg-4 col-md-6 mb-4 mb-md-0\">\r\n"
				  + "          <h5 class=\"profile\">$Cesar Paredes [\"Software Developer\"]</h5>\r\n"
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
				  + " 			<li class=\"mb-3\">\r\n"
				  + "              <a href=\"https://github.com/Cesar-Paredes/Real_Estate_REST_Calculator\" target=\"_blank\" style=\"color:orange\">CODE for this Web App</a>\r\n"
				  + "            </li>"
				  + "            \r\n"
				  + "          </ul>\r\n"
				  + "        </div>\r\n"
				  + "        <!--Grid column-->\r\n"
				  + "  \r\n"
				  + "        <!--Grid column-->\r\n"
				  + "<div class=\"col-lg-4 col-md-6 mb-4 mb-md-0\">\r\n"
				  + "          <h5 class=\"text-uppercase mb-4\">Languages used in this web app</h5>\r\n"
				  + "  \r\n"
				  + "          <table class=\"table text-center text-white\">\r\n"
				  + "            <tbody class=\"font-weight-normal\">\r\n"
				  + "              <tr>\r\n"
				  + "                <td>Back-End:</td>\r\n"
				  + "                <td>REST architecture, JAVA JERSEY, Linux Ubuntu OS</td>\r\n"
				  + "              </tr>\r\n"
				  + "              <tr>\r\n"
				  + "                <td>Front-End</td>\r\n"
				  + "                <td>HTML, CSS, Bootstrap and JS</td>\r\n"
				  + "              </tr>\r\n"
				  + "            </tbody>     \r\n"
				  + "          </table>\r\n"
				  + "          \r\n"
				  + "           <h3>Steps on the server Ubuntu console command line:</h3>\r\n"
				  + "          <ul>\r\n"
				  + "          	        	\r\n"
				  + "          	<li><p>Set up the Java environment by installing JDK and JRE 11.</p></li>\r\n"
				  + "          	<li><p>Install maven.</p></li>\r\n"
				  + "          	<li><p>Clone the Payara glassfish server  6 (6.2.3) using Git commands.</p></li>\r\n"
				  + "          	<li><p>Execute a maven build.</p></li>\r\n"
				  + "          	<li><p>Use Payara glassfish to deploy my project.</p></li>\r\n"
				  + "                 \r\n"
				  + "          </ul>\r\n"
				  + "          \r\n"
				  + "          \r\n"
				  + "        </div>"
				  + "        <!--Grid column-->\r\n"
				  + "      </div>\r\n"
				  + "      <!--Grid row-->\r\n"
				  + "    </div>\r\n"
				  + "    <!-- Grid container -->\r\n"
				  + "  \r\n"
				  + "    <!-- Copyright -->\r\n"
				  + "    <div class=\"text-center p-3\" style=\"background-color: rgba(0, 0, 0, 0.2);\">\r\n"
				  + "      � 2022 Copyright - Cesar Paredes\r\n"
				  + "      \r\n"
				  + "    </div>\r\n"
				  + "    <!-- Copyright -->\r\n"
				  + "  </footer>\r\n"
				  + "  \r\n"
				  + "\r\n"
				  + "\r\n"
				  + "\r\n"
				  + "</html>";
		  
		  ByteBuffer buffer = StandardCharsets.UTF_8.encode(rawString); 
		  String utf8EncodedString = StandardCharsets.UTF_8.decode(buffer).toString();
		  
		  return utf8EncodedString;
		 		  
	}
	

}

		
		

	  
	   
	   

	   
	   
	   
	   
	   
	   

