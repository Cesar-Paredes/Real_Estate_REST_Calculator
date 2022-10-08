package realEstateREST;

public class Rental {


    private double purchasePrice=0;
    private double grossRentalAnnualIncome =0;
    private double monthlyRentTenantPay =0;
    private double interestRate=0;
    private double amortizationPeriod=0;
    private double downPayment=0;
    private double mortgageMonthlyPayments =0;
    private double netAnnualRentalIncome =0;
    private double monthlyRentProfit=0;
    private double mortgageAnnualPayments=0;
    private double rentAfterAmortizationPeriod=0;



    //this is what i expect to get every month
    public double getMonthlyRentProfit() {
        return monthlyRentProfit;
    }

    public void setMonthlyRentProfit(double profits) {
        this.monthlyRentProfit = profits;
    }

    //tenant would pay this
    public void setMonthlyRentTenantPay() {
            this.monthlyRentTenantPay = this.mortgageMonthlyPayments + monthlyRentProfit;

        }


    public double getMonthlyRentTenantPay() {
        return this.monthlyRentTenantPay;
    }

    //we call this method when the amortization is when is less than 12 months only, after the amortization period the tenant will pay this amount
    //to meet the profit criteria of the user
    public double getMonthlyRentAfterAmortizationPeriod(){
        this.rentAfterAmortizationPeriod =  monthlyRentProfit;
        return rentAfterAmortizationPeriod;
    }



    //annual gross income out of renting your property
    public void setGrossAnnualRentalIncome() {
        double months;

        if(getAmortizationPeriod() >= 12)
            this.grossRentalAnnualIncome = monthlyRentTenantPay * 12;
        
        else {
        	this.grossRentalAnnualIncome = monthlyRentTenantPay * getAmortizationPeriod();
            this.grossRentalAnnualIncome += (monthlyRentProfit * (12-getAmortizationPeriod()));    
        }
           



    }

    public double getGrossAnnualRentalIncome() {
        return grossRentalAnnualIncome;
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

    public double getMonthlyMortgagePayments() {

        //when values are 0, mortgage payments might return a Nan
        if(Double.isNaN(this.mortgageMonthlyPayments)){
            return 0;
        }
        return mortgageMonthlyPayments;
    }

    public void setMonthlyMortgagePayments() {
//		this.mortgagePayments = (getPurchasePrice() - getDownPayment() * interestRate) * Math.pow((1 + (interestRate/12)),getAmortizationPeriod()) /
//								(Math.pow((1 + interestRate),amortizationPeriod) - 1);
        double months ;

        //when values are 0, mortgage payments might return a Nan
        if(Double.isNaN(this.mortgageMonthlyPayments)){
            this.mortgageMonthlyPayments = 0;
        }

        //usually 12 months(a year) unless the amortization period is less than 12, otherwise if the amortization period is less than 12 months
        //it would give me a logical error in the annual payment and gross rental income when the mortgagePayments formula is executed
        if(getAmortizationPeriod() < 12)
            months = amortizationPeriod;
        else
            months = 12;

        //interest rate of 0 would give us logical errors, also amortization =0 would give us problems in this formula
        if(this.interestRate > 0 && getAmortizationPeriod() > 1)
            this.mortgageMonthlyPayments =  ((getPurchasePrice()-getDownPayment())* (( (getInterestRate()/100) /months )*(Math.pow( 1 + ((getInterestRate()/100)/months ), getAmortizationPeriod()) ) ) )/
                    ( (Math.pow( 1 + ((getInterestRate()/100)/months ), getAmortizationPeriod()) ) -1 ) ;

        //this would also give me a problem with the mortgagePayments formula
        else if(this.interestRate>=0 && (this.amortizationPeriod == 0 || this.amortizationPeriod == 1)){
            this.mortgageMonthlyPayments =  (getPurchasePrice())* (1+(getInterestRate()/100)) ;

        }
        else
            //if interest rate is 0 we do this, otherwise it will have logical errors when amortization is 0
            //it doestn take in consideration the downpayment
            //and also when amortization is 0 and interest rate is > 0
            this.mortgageMonthlyPayments = (getPurchasePrice()-getDownPayment()) / months;





    }

    public double getAnnualNetRentalIncome() {
        return netAnnualRentalIncome;
    }

    public void setAnnualNetRentalIncome() {

        if(getAmortizationPeriod() >= 12)
            netAnnualRentalIncome = grossRentalAnnualIncome - (mortgageMonthlyPayments *12);
        //if is less than a year, we would take the mortgagePayments for only the amortization period then continue with what the user wants to get per month
        //otherwise we would get a huge income per year
        else
            //this get the income you get for the amortization period
            netAnnualRentalIncome = grossRentalAnnualIncome - (mortgageMonthlyPayments * amortizationPeriod);
    }

    public double getMortgageAnnualPayments(){
        return this.mortgageAnnualPayments;
    }

    public void setMortgageAnnualPayments(){

        if(getAmortizationPeriod() >=12)
            this.mortgageAnnualPayments = mortgageMonthlyPayments * 12;
        
        else if(this.interestRate>=0 && (this.amortizationPeriod == 0 || this.amortizationPeriod == 1))
            this.mortgageAnnualPayments = getPurchasePrice() * (1+(getInterestRate()/100));

        else
            this.mortgageAnnualPayments = (mortgageMonthlyPayments * getAmortizationPeriod()) + this.downPayment;
    }
}















