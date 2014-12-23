package pl.mprzybylak.minefields.java8.optionals;

import java.util.Optional;

public class Optionals {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Optional<Car> emptyOptional = Optional.empty(); // empty optional
		Optional<Car> nonEmpty = Optional.of(new Car()); // non empty optional or null pointer exception

		Optional<Insurance> emptyOptionalInsurance = emptyOptional.map(Car::getInsurance); 
		Optional<Insurance> nonEmptyOptionalInsurance = nonEmpty.map(Car::getInsurance);
	}
}

class Person {
	private Car car;
	public Car getCar() {
		return car;
	} 
}

class Car {
	private Insurance insurance;
	public Insurance getInsurance() {
		return insurance;
	}
}

class Insurance {
	private String name;
	public String getName() {
		return name;
	}
}