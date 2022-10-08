package realEstateSOAP;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

//I put all dependencies for SOAP, and this class, and so far the REST app still working


@WebService
@SOAPBinding(style=Style.RPC)
public class WebRealEstateService {

	@WebMethod
	public String refinance(double homeValue, double currentMortgageBalance) {

		Refinance refinance = new Refinance();
		
		refinance.setHomeValue(homeValue);
		refinance.setCurrentMortgageBalance(currentMortgageBalance);
		refinance.setMaxRefinance();
		refinance.setCashAvailable();
		
		return refinance.toString();
		
	
	}

	@WebMethod
	public Refinance refinance2(double homeValue, double currentMortgageBalance) {

		Refinance refinance = new Refinance();
		
		refinance.setHomeValue(homeValue);
		refinance.setCurrentMortgageBalance(currentMortgageBalance);
		refinance.setMaxRefinance();
		refinance.setCashAvailable();
		
		return refinance;
		
	
	}

}
