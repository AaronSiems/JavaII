package model;

public class CansToCoins {
	
	private final double RATE = 0.05;
	private int cans;
	private double total;
	
	public CansToCoins() {
		super();
	}
	public CansToCoins(int cans) {
		super();
		this.cans = cans;
		this.total = calculateTotal();
	}
	
	public double calculateTotal() {
		return (this.cans * this.RATE);
	}
	
	
	
	public int getCans() {
		return cans;
	}
	public void setCans(int cans) {
		this.cans = cans;
	}
	public String getTotal() {
		String amount = String.format("%.2f", this.total);
		return amount;
	}
	public double getRATE() {
		return RATE;
	}
	
	

}
