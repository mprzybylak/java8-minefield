package pl.mprzybylak.minefields.java8.behaviorparametrization.entity;

public class Apple {

	private String color;
	private int weight;
	private Taste taste;
	
	public Apple(String color, int weight, Taste taste) {
		this.color = color;
		this.weight = weight;
		this.taste = taste;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public Taste getTaste() {
		return taste;
	}
	
	@Override
	public String toString() {
		return color + " " + weight + " " + taste;
	}
	
}

