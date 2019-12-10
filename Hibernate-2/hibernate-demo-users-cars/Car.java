package it.unical.asde.hibernatedemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Car {

	// In this case the id of the car is the plate.
	@Id
	private String plate;
	
	private String model;
	
	private String brand;
	
	/* In order to let know HIBERNATE that the owner is the inverse relation of  
	 * user-cars we use the @ManyToOne annotation.
	 * Here they are not linked, HIBERNATE will create two relations one from 
	 * the owner to the user and an extra column for handling the list. In the
	 * car we would have two additional columns, two additional foreign keys.
	 * Two foreign keys to the user because the two relations are not linked to-
	 * gether.
	 * In this case we have added the inverse relation, in the car we have added 
	 * the owner and in the owner we have added its cars and this is redundant,
	 * if we don't do anything HIBERNATE will create two foreign keys to the user
	 * because it doesn't know that one is the inverse of the other. 
	 * In this case we will have two additional columns one for each relation.
	 */
	@ManyToOne
	private User owner;

	public Car() {
		super();
	}
	

	public Car(String plate, String model, String brand, User owner) {
		super();
		this.plate = plate;
		this.model = model;
		this.brand = brand;
		this.owner = owner;
	}


	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	

	
	
	
	
}
