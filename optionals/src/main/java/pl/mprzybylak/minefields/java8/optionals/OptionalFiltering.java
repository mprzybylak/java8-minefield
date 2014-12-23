package pl.mprzybylak.minefields.java8.optionals;

import java.util.Optional;

public class OptionalFiltering {
	public static void main(String[] args) {

		Optional<String> optional = Optional.of("Test");
		
		// filter will return empty optional if predicate did not pass
		optional.filter(o -> "Test".equals(o)).ifPresent(o -> System.out.println(o));
		
	}
}
