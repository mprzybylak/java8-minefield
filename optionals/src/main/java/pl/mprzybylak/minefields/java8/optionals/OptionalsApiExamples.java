package pl.mprzybylak.minefields.java8.optionals;

import java.util.Optional;

public class OptionalsApiExamples {

	public static void main(String[] args) {
		
		Optional<String> optional = Optional.of("Test");
		
		System.out.println(optional.orElse("Unknown"));
		System.out.println(optional.orElseGet(() -> "Unknown")); // supplier will be executed when optional is empty - so "else" value is lazy-like
		
		System.out.println(optional.orElseThrow(NullPointerException::new)); // you can throw you own type of exception when optional is empty
		optional.ifPresent(v -> System.out.println(v));
	}
}
