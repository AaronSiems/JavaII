package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="collections")
public class Collection {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(
			name="coins_in_collection",
			joinColumns= {@JoinColumn(name="COLLECTION_ID", referencedColumnName="ID")},
			inverseJoinColumns= {@JoinColumn(name="COIN_ID", referencedColumnName="ID", unique=true)}
	)
	private List<Coin> listOfCoins;
	

	public Collection() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Collection(String name, List<Coin> listOfCoins) {
		super();
		this.name = name;
		this.listOfCoins = listOfCoins;
	}


	public Collection(int id, String name, List<Coin> listOfCoins) {
		super();
		this.id = id;
		this.name = name;
		this.listOfCoins = listOfCoins;
	}
	
	


	public Collection(String name) {
		super();
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Coin> getListOfCoins() {
		return listOfCoins;
	}


	public void setListOfCoins(List<Coin> listOfCoins) {
		this.listOfCoins = listOfCoins;
	}


	@Override
	public String toString() {
		return "Collection [id=" + id + ", name=" + name + ", listOfCoins=" + listOfCoins + "]";
	}


	
	
	
	
	
}
