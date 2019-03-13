package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Drink {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String color;
	private double price;
	
	public Drink() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public Drink(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}





	public Drink(String name, String color, double price) {
		super();
		this.name = name;
		this.color = color;
		this.price = price;
	}




	public Drink(long id, String name, String color, double price) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
	}




	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Drink [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + "]";
	}
	
	
	
}
