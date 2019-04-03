package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coins {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String coin;
	private int year;
	private String mint;

	
	
	//super
	public Coins() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//constructor
	public Coins(String coin, int year, String mint) {
		super();
		this.coin = coin;
		this.year = year;
		this.mint = mint;
	}
	
	//complete constructor
	public Coins(long id, String coin, int year, String mint) {
		super();
		this.id = id;
		this.coin = coin;
		this.year = year;
		this.mint = mint;
	}


	//return description (to string)
	public String returnDesc() {
		return coin + " from " + year + ", minted at: " + mint;
	}

	
	
	
	//get & set
	
	public String getCoin() {
		return coin;
	}

	public void setCoin(String coin) {
		this.coin = coin;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMint() {
		return mint;
	}

	public void setMint(String mint) {
		this.mint = mint;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
}
