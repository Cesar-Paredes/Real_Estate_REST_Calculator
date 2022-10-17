<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->

<!-- jquery library and jsdelivr -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script> -->








<!--  this is the style CSS  -->
<style>
	.divider:after,
.divider:before {
content: "";
flex: 1;
height: 1px;
background: #eee;
}
.h-custom {
height: calc(100% - 73px);
}
@media (max-width: 450px) {
.h-custom {
height: 100%;
}
}

.form-label{
font-size:15px;
}

p{
font-size:15px;}

.mb-3{
	font-size:25px;
}
.profile{
	font-size:20px;
	background-color:black;
	text-align: center;
}

.font-weight-normal{
	font-size:17px;
}

.list-group{
  margin-top: 100px;
  font-size: 20px;
}

.list-group p{
  font-size: 20px;
}

/* form button "calculate profit"  */
.btn-lg{
  font-size: 20px;
  
}


/* title in h1 */
.justify-content-lg-start h1{
  font-size: 40px;
  color:blue;
}


/* text under the title */
.intro{
  color: rgb(60, 5, 149);
  font-weight: 500;
}

/* github link  */
.link-dark{
font-weight:bold;
}

/* form  */
.offset-xl-1{
	
}

/* footer  */
.bg-primary{
	margin-top: 200px;
}



</style>


<title>Real Estate Calculator</title>
</head>
<body>


	<section class="vh-100">
  <div class="container-fluid h-custom">
  
  
  
    <div class="row d-flex justify-content-center align-items-center h-100"> 
      <div class="col-md-9 col-lg-6 col-xl-5">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
          class="img-fluid" alt="Sample image">

          
      </div>

    
      
       <br>
       <br>
      
      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">     
        <form method="get" action="/RealEstateREST/rest/WebRealEstate/rent2">
          <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
            <h1>Real Estate Calculator</h1><br>
            
          </div>

         
          
          <div class="form-outline mb-4">
            <p class="intro">Calculate how much money you can obtain from your rental property, by calculating your rental income and substracting your mortgage monthly payments </p>
          
            <input type="number" name="purchasePrice" id="form3Example3" class="form-control form-control-lg"
              placeholder="Purchase Price in dollars" />
            <label class="form-label" for="form3Example3">Purchase Price of your property</label>
            
          </div>
          
           <div class="form-outline mb-4">
            <input type="number" name="downPayment" id="form3Example3" class="form-control form-control-lg"
              placeholder="Down-payment in dollars" />
            <label class="form-label" for="form3Example3">Down-payment</label>
          </div>
          
           <div class="form-outline mb-4">
            <input type="number" name="interestRate" id="form3Example3" class="form-control form-control-lg"
              placeholder="Interest Rate %" />
            <label class="form-label" for="form3Example3">Interest Rate</label>
          </div>
          
           <div class="form-outline mb-4">
            <input type="number" name="amortizationPeriod" id="form3Example3" class="form-control form-control-lg"
              placeholder="Number of months it would take to pay the property" />
            <label class="form-label" for="form3Example3">Amortization Period(months) Usually 300 months: </label>
          </div>
          
           <div class="form-outline mb-4">
            <input type="number" name="monthlyRentProfit"  id="form3Example3" class="form-control form-control-lg"
              placeholder="Montly profit you would like to obtain in dollars" />
            <label class="form-label" for="form3Example3">How much would you like to get monthly from renting your property?</label>
          </div>

         
          <div class="text-center text-lg-start mt-4 pt-2">
            <button type="submit" class="btn btn-primary btn-lg"
              style="padding-left: 2.5rem; padding-right: 2.5rem;">Calculate my profit</button>
                 
          </div>
        </form>
        
      </div>
    </div>
  </div>

</section>



</body>

<!--  footer -->

<footer class="text-white text-center text-lg-start bg-primary">
    <!-- Grid container -->
    <div class="container p-4">
      <!--Grid row-->
      <div class="row mt-4">
        <!--Grid column-->
        <div class="col-lg-4 col-md-12 mb-4 mb-md-0">
          <h5 class="text-uppercase mb-4">About my Web application :)</h5>
  
          <p>
           Hello, and I hope you are having fun looking at this calculator :)         
          </p>
          
          <h3>System environment:</h3>
         
          <p>        	
          	I used Digital Ocean for my hosting services, unfortunately, they don't have the auto-deploy option for Java web apps so I had to do everything myself from the Ubuntu console which was great because 
          	I had the chance to practice my Linux skills :)
          </p>
          
          
          <p>
            More details:<br>
            The form data is sent to my HTTP endpoint, this HTTP GET method 
            connects to my Java class, and all calculations are done in that class. 
            Then the HTTP GET method fetches the final results from my Java Class and returns them to the client 
            in the form of HTML.
          </p>
         
          	
          	
          	
          	          	
          	
          	
          
  
        </div>
        <!--Grid column-->
  
        <!--Grid column-->
        <div class="col-lg-4 col-md-6 mb-4 mb-md-0">
          <h5 class="profile">$Cesar Paredes ["Software Developer"]</h5>
          
          <!-- Linkedin -->
			<i class="fab fa-linkedin-in"></i>
  
          
  
          <ul class="fa-ul" style="margin-left: 1.65em;">
          <li class="mb-3">
              <a href="https://github.com/Cesar-Paredes" target="_blank" class="link-dark">GitHub</a>
            </li>
            <li class="mb-3">
              <a href="https://www.linkedin.com/in/cesarparedes1/" target="_blank" class="text-white">LinkedIn</a>
            </li>
            <li class="mb-3">
              <a href="https://github.com/Cesar-Paredes/Real_Estate_REST_Calculator" target="_blank" style="color:orange">CODE for this Web App</a>
            </li>
            
            
          </ul>
        </div>
        <!--Grid column-->
  
        <!--Grid column-->
        <div class="col-lg-4 col-md-6 mb-4 mb-md-0">
          <h5 class="text-uppercase mb-4">Languages used in this web app</h5>
  
          <table class="table text-center text-white">
            <tbody class="font-weight-normal">
              <tr>
                <td>Back-End:</td>
                <td>REST architecture, JAVA JERSEY, Linux Ubuntu OS</td>
              </tr>
              <tr>
                <td>Front-End</td>
                <td>HTML, CSS, Bootstrap and JS</td>
              </tr>
            </tbody>     
          </table>
          
           <h3>Steps on the server Ubuntu console command line:</h3>
          <ul>
          	        	
          	<li><p>Set up the Java environment by installing JDK and JRE 11.</p></li>
          	<li><p>Install maven.</p></li>
          	<li><p>Clone the Payara glassfish server  6 (6.2.3) using Git commands.</p></li>
          	<li><p>Execute a maven build.</p></li>
          	<li><p>Use Payara glassfish to deploy my project.</p></li>
                 
          </ul>
          
          
        </div>
        
        <!--Grid column-->
      </div>
      <!--Grid row-->
    </div>
    <!-- Grid container -->
  
    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
      © 2022 Copyright - Cesar Paredes
      
    </div>
    <!-- Copyright -->
  </footer>
  



</html>