package realEstateREST;

public class Rental {


    private double purchasePrice;
    private double grossRentalIncome;
    private double monthlyRent;
    private double interestRate;
    private double amortizationPeriod;
    private double downPayment;
    private double mortgagePayments;
    private double netRentalIncome;
    private double monthlyRentProfit;


    //tenant would pay this
    public void setMonthlyRent() {
        this.monthlyRent = mortgagePayments + monthlyRentProfit;
    }

    public double getMonthlyRent() {
        return this.monthlyRent;
    }



    //annual gross income out of renting your property
    public void setGrossRentalIncome() {
        this.grossRentalIncome = monthlyRent * 12;
    }

    public double getGrossRentalIncome() {
        return grossRentalIncome;
    }


    //this will show what is the percentage of the down-payment from the purchase price
    public double downPaymentPercentage() {
        return (this.downPayment/this.purchasePrice) * 100;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchase) {
        this.purchasePrice = purchase;
    }


    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    //number of months we want to pay the loan
    public double getAmortizationPeriod() {
        return amortizationPeriod;
    }

    public void setAmortizationPeriod(double amortizationPeriod) {
        this.amortizationPeriod = amortizationPeriod;
    }

    public double getInterestRate() {
        return interestRate * 100;
    }

    //sets the interest rate in decimals. ex 6% is 0.06
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate/100;
    }

    public double getMortgagePayments() {
        return mortgagePayments;
    }

    public void setMortgagePayments() {
//		this.mortgagePayments = (getPurchasePrice() - getDownPayment() * interestRate) * Math.pow((1 + (interestRate/12)),getAmortizationPeriod()) /
//								(Math.pow((1 + interestRate),amortizationPeriod) - 1);

        this.mortgagePayments =  ((getPurchasePrice()-getDownPayment())* (( (getInterestRate()/100) /12 )*(Math.pow( 1 + ((getInterestRate()/100)/12 ), getAmortizationPeriod()) ) ) )/
                ( (Math.pow( 1 + ((getInterestRate()/100)/12 ), getAmortizationPeriod()) ) -1 ) ;
    }

    public double getNetRentalIncome() {
        return netRentalIncome;
    }

    public void setNetRentalIncome() {
        netRentalIncome = grossRentalIncome - (mortgagePayments*12);
    }

    public double getMonthlyRentProfit() {
        return monthlyRentProfit;
    }

    public void setMonthlyRentProfit(double profits) {
        this.monthlyRentProfit = mortgagePayments + profits;
    }

}


