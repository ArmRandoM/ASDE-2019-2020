package it.unical.asde.hibernatedemo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/* In order to map the class to the database we need:
 * 1. the @Entity annotation;
 * 2. the empty constructor;
 * 3. getters and setters for the fields.
 * There are also diffent way to generate id values:
 * 1. sequence starting from 1 and so on;
 * 2. auto works with all the different databases. 
 */

@Entity
public class User {
	
	// In this case the username field is the primary key
	@Id
	private String username;
	
	/* The address is annotated with the @Embedded annotation because this is a value 
	 * that we want to embed.Tipically for address we don't have an additional table
	 * if we don't want to have an additional value and we want to embed the value of 
	 * the address in the User table we can specify that the address is embedded.
	 */
	@Embedded
	private Address address;

	/* In this case we have the User Class has a list of simple objects or a list of 
	 * embeddable objects. This is the case in which we don't need a specific class 
	 * for the phone numbers because they are just strings.
	 * We don't have an external entity but still we have a collection of that.We can
	 * handle the list of strings in the database with additional table and 
	 * put a foreign key from the phone number to the user, by using the annotation 
	 * @ElementCollection HIBERNATE will automatically create the additional table and
	 * do all the stuff for us while we keep using the simple maintenance of the phone
	 * numbers in the User class.In this case we have a list of elements, we cannot sto-
	 * re a list of elements in a table, in the User table we cannot put the numbers di-
	 * rectly because they are list, they are collections of elements. What we can do 
	 * we can specify the element collection using the annotation @ElementCollection 
	 * and HIBERNATE will create the PhoneNumber table for us and add e foreign key to 
	 * the User. If we want to query the element collection it is not easy, sometimes 
	 * is not possible directly.E.g. if we want to query a person by a given number it 
	 * is not easy to do that, in that case if we want to query the collection is better
	 * to use a relation and an external entity.
	 */
	@ElementCollection
	private List<String> phoneNumbers;

	/* A user can have different cars. A user can have more than one car and this is
	 * a one-to-many association instead.
	 * In order to map many-to-one relation we use @ManyToOne annotation, in order to
	 * map one-to-many relation we use @OneToMany annotation.
	 * The table that is responsible to handle this type of relation is the car table 
	 * because in the database the user is stored as foreign key.
	 * In Java we want to use list of objects we don't have to follow exactly the para-
	 * digm of the database because HIBERNATE will work for us.
	 * HIBERNATE knows that it is a one-to-many relation so it knows that it has to 
	 * create a foreign key from the car table to the user table.
	 * In order to not create two different foreign keys in the Car class we use the ar-
	 * gument mappedBy to specify the column that is handling this mapping and in this
	 * case is "owner".
	 * The mappedBy accepts a parameter which specifies the field that is handling the
	 * relation. Now they are the same relation and HIBERNATE will not create two foreign
	 * keys in the Car Class side, but only one column.
	 * In this case we added a cascade operation, as you know in databases there are cas-
	 * cading operations and in this case we are cascading all the operations but we can 
	 * select what kind of operations we want to cascade.
	 * E.g. we can cascade the persist in case we want to persist the cars together with 
	 * the user, if we don't put the cascade than we create a user, we add some cars and 
	 * then we try to save the user at this point we will get an error, the error is that 
	 * the cars are not already in the database, we have to save the cars first and then 
	 * the user or we can cascade all the operations. 
	 * When we delete the user and we define the cascade operations than once we remove
	 * the user that also the cars we'll be removed automatically.
	 * If we need only one of these operations to be cascaded we have to select the type
	 * of cascading that we want. 
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private List<Car> userCars;

	/* This date will be automatically converted from Java Date in an SQL Date, without 
	 * the need of changing the format and so on, it should work automatically.
	 */
	private Date registrationDate;

	public User() {
		super();
	}

	public User(String username, Address address, List<String> phoneNumbers, List<Car> userCars,
			Date registrationDate) {
		super();
		this.username = username;
		this.address = address;
		this.phoneNumbers = phoneNumbers;
		this.userCars = userCars;
		this.registrationDate = registrationDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<Car> getUserCars() {
		return userCars;
	}

	public void setUserCars(List<Car> userCars) {
		this.userCars = userCars;
	}

}
