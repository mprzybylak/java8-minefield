package pl.mprzybylak.minefields.java8.stream;

public class Money {

	String currency;
	int value;
	
	public Money(String currency, int value) {
		this.currency = currency;
		this.value = value;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public int getValue() {
		return value;
	}
	
	
}
