package it.unical.asde.hibernatedemo.model;

import javax.persistence.Embeddable;

/* The address is a separate object that will be embedded in the user and 
 * are annotate with the @Embedded annotation.
 * We specified that the address is an embeddable class. What appens is 
 * that the User table will have the city, the street and the street num-
 * ber.The User table will not have a foreign key for an address table,
 * the address table doesn't exist and all the field of the address are 
 * in the User table.
 */
@Embeddable
public class Address {
	
	private String city;
	private String street;
	private Integer streetNumber;
	
	public Address(String city, String street, Integer streetNumber) {
		super();
		this.city = city;
		this.street = street;
		this.streetNumber = streetNumber;
	}

	public Address() {
		super();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(Integer streetNumber) {
		this.streetNumber = streetNumber;
	}
}
