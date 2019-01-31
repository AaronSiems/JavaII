package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coins")
public class Coin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="COIN")
	private String coin;
	
	@Column(name="YEAR")
	private int year;
	
	@Column(name="MINT")
	private String mint;

	
	
	//super
	public Coin() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//constructor
	public Coin(String coin, int year, String mint) {
		super();
		this.coin = coin;
		this.year = year;
		this.mint = mint;
	}
	
	
	//return description
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
