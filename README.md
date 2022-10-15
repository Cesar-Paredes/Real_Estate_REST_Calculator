# Real_Estate_REST_Calculator
Java Web application using my own REST API (Web services)
<br/>  
++++++++++++++++++++++++++++++++
<h3 align="left"> 🚀Live Project:🚀</h3>                                                       
<p align="left">                                                                                                    
<a href="http://138.197.150.253:8080/RealEstateREST/RealEstateForm.jsp" target="_blank">Real Estate Calculator</a>  
<br/>                                                                                                                
++++++++++++++++++++++++++++++++
<br/>  

I created a real estate calculator that takes different factors into consideration such as interest rate, <br/>
amortization period, purchase price, downpayment, and targeted potential profit.<br/>

Front-end: HTML, CSS, Bootstrap and some JS.<br/>

Back-end: Maven project with REST architecture and Java Jersey.<br/>
<br/>
This app was deployed locally using a Payara glassfish server 6 (6.2.3)<br/>


![image](https://user-images.githubusercontent.com/35407350/195676684-5ac0e612-abde-4b8a-bedd-793d7d6fa26c.png)

<br/>

![image](https://user-images.githubusercontent.com/35407350/195676764-6bb7955f-c3fe-4f5c-9f6c-6ad2670e55b7.png)
<br/>

![image](https://user-images.githubusercontent.com/35407350/195676854-ba1f4936-25d7-4023-8139-f28d1dcefd05.png)

<br/>


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

                  	

