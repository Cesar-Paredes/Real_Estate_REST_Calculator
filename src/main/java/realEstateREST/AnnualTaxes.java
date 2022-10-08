package realEstateREST;

//this is a database of the annual taxes according to the area
//only in Montreal and some surrounding cities

public class AnnualTaxes {
	
	private  double montrealWest = 6000;
	private  double montrealEast = 5000;
	private  double montrealNorth = 1500;
	private  double vaudreuil = 5000;
	private  double laval = 6000;
	
	
	
	public double getMontrealWest() {
		return montrealWest;
	}
	public double getMontrealEast() {
		return montrealEast;
	}
	public double getMontrealNorth() {
		return montrealNorth;
	}
	public double getVaudreuil() {
		return vaudreuil;
	}
	public double getLaval() {
		return laval;
	}
	public void setMontrealWest(double montrealWest) {
		this.montrealWest = montrealWest;
	}
	public void setMontrealEast(double montrealEast) {
		this.montrealEast = montrealEast;
	}
	public void setMontrealNorth(double montrealNorth) {
		this.montrealNorth = montrealNorth;
	}
	public void setVaudreuil(double vaudreuil) {
		this.vaudreuil = vaudreuil;
	}
	public void setLaval(double laval) {
		this.laval = laval;
	}
	
	
	
	

}
