package pl.mprzybylak.minefields.java8.stream;

public class Money {

	private String currency;
	private int value;

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

	@Override
	public String toString() {
		return value + currency ;
	}

}
