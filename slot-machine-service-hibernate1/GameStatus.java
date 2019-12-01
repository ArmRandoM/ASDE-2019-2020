package it.unical.asde.slotmachineservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/* This is the class that we want to map to the database, using annotations.
 * We want essentially that this class become a table in the database. 
 * The way to do it is to annotate the class, in order to specify that it is 
 * an entity. In order to do it we have to add the @Entity annotation. 
 * The best choice is to use the annotation defined in the Java Persistence 
 * because they will work even if we will replace HIBERNATE with something 
 * else. 
 * By default all the private fields are already mapped automatically in the 
 * database. We not have to write extra annotation in the private fields un-
 * -less we want some specific behaviour.
 */

@Entity
public class GameStatus {
	
	/* The type conversion is done automatically by HIBERNATE. HIBERNATE au-
	 * -tomatically sees that coins is an integer and It will find a proper 
	 * type in the database.  
	 * If there is a special field that we don't want to persist in the data-
	 * -base there is a special annotation @transient. If we annotate a priva-
	 * -te field to be transient it will not be mapped to the database.
	 * Transient also effects the serialization when we serialize or deseriali-
	 * ze with Jackson that is the library that we automatically use when we
	 * send data from the client to the server. E.g. if we want that the coins
	 * field is transient, we don't want to save the coins to the database but 
	 * still we want to get the coins to the client (to React), if we add tran-
	 * -sient it will not be serialized, the JSon will not contain the coins, 
	 * we have to add @JsonInclude annotation to be sure that the field will 
	 * be serialized as JSon when we return this type of objects from the Rest 
	 * Controller. 
	 * In the Rest Controller we return some Java Object, but they are sent to 
	 * the client JSon. As before we didn't write anything on how to translate 
	 * an object to JSon because because spring automatically uses a library 
	 * whose name is Jackson to transform an object to a JSon. If we use the @tr-
	 * ansient annotation the private field should not be serialized and it works
	 * both for the database mapping and for the JSon mapping. If we write @tran-
	 * sient it means that the database will not store the private field. 
	 * Of course we cannot use @Transient and @Column together. 
	 * With @Transient annotation we say that the field should not be saved in the
	 * database and should not be serialized. In order to serialize it we have to 
	 * annotate it with @JsonInclude.
	 */
	
	/* We want that the string user is the primary key. In order to say that
	 * it is the primary key we have to annotate it with @Id.
	 */
	@Id
	private String user;
	
	/* In this case we want that the coins will not be null. By default the 
	 * fields are nullable, they can assume also the null value (which is a
	 * special value in the database). 
	 * If we want that the coins will be not null we have to add the @Column
	 * annotation and say that "nullable" is false.  
	 */
	@Column(nullable = false)
	private Integer coins;
	
	/* Finally there is an important thing that we have to add and it is the 
	 * empty constructor. The entities need the empty constructor, we have 
	 * always to add the empty constructor to our entity.
	 */
	public GameStatus() {
		super();
	}
	
	public GameStatus(String user, Integer coins) {
		super();
		this.user = user;
		this.coins = coins;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Integer getCoins() {
		return coins;
	}
	public void setCoins(Integer coins) {
		this.coins = coins;
	}
	
	
	
}
