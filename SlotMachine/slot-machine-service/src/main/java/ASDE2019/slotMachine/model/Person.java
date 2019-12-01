package ASDE2019.slotMachine.model;

public class Person {
	
	private String username;
	
	private String password;
	
	private Integer coinsNumber;

	public Person(String username, String password, Integer coinsNumber) {
		super();
		this.username = username;
		this.password = password;
		this.coinsNumber = coinsNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCoinsNumber() {
		return coinsNumber;
	}

	public void setCoinsNumber(Integer coinsNumber) {
		this.coinsNumber = coinsNumber;
	}
}
