package pl.mprzybylak.minefields.java8.optionals;

import java.util.Optional;

public class FlatMapExample {


	public static void main(String[] args) {
		Optional<OptionalPerson> person = Optional.of(new OptionalPerson());
		Optional<OptionalInsurance> insurance = person.flatMap(OptionalPerson::getCar).flatMap(OptionalCar::getInsurance); // we need to use flatMap, because map will return nested Optional<Optional<...>>
		
		System.out.println(insurance.map(OptionalInsurance::getName).orElse("Unknown"));
		
	}
}

class OptionalPerson {
	private OptionalCar car = new OptionalCar();
	public Optional<OptionalCar> getCar() {
		return Optional.of(car);
	}
}

class OptionalCar {
	private OptionalInsurance insurance = new OptionalInsurance();
	public Optional<OptionalInsurance> getInsurance() {
		return Optional.of(insurance);
	}
}

class OptionalInsurance {
	private String name;
	public String getName() {
		return name;
	}
}