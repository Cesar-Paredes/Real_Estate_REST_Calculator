package realEstateSOAP;

public class Refinance {
	
	private double homeValue;//value of home
	private double maxRefinance;//home value maximum amount banks will consider - 80% of home value
	private double currentMortgageBalance;//total amount you have left to pay your mortgage
	
	private double cashAvailable;//total access to cash you have from your property
	
	private final double  MAX_PERCENTAGE = 0.8; //banks will only consider 80%
	
	
	
	public double getCashAvailable() {
		return cashAvailable;
	}

	public void setCashAvailable() {
		this.cashAvailable = maxRefinance - currentMortgageBalance;
	}

	

	public double getCurrentMortgageBalance() {
		return currentMortgageBalance;
	}

	public void setCurrentMortgageBalance(double currentMortgageBalance) {
		this.currentMortgageBalance = currentMortgageBalance;
	}


	
	public double getMaxRefinance() {
		return maxRefinance;
	}

	public void setMaxRefinance() {
		maxRefinance = homeValue * MAX_PERCENTAGE;
	}
	
	
	public double getHomeValue() {
		return homeValue;
	}
	
	public void setHomeValue(double homeValue) {
		this.homeValue = homeValue;
	}
	
	public double getMAX_PERCENTAGE() {
		return MAX_PERCENTAGE;
	}

	
	public String toString() { return "Home value: " + homeValue + "\n" +
	  "Maximun mortgage percentage: " + MAX_PERCENTAGE + "\n" +
	  "Banks will consider only 80% of the home value: " + maxRefinance + "\n" +
	  "Current mortgage balance: " + currentMortgageBalance + "\n" +
	  "-----------------------------------------------------------------" + "\n"+
	  "Total Cash available to access: " + cashAvailable + "\n" + "\n" +
	  "Note your new mortgage would be: " + (currentMortgageBalance +
	  cashAvailable); }
	 
	
	
	
	
	
	
	

}
