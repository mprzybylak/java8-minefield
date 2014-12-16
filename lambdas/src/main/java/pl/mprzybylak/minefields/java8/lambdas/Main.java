package pl.mprzybylak.minefields.java8.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
	
	
	public static void main(String[] args) {
		Apple first = new Apple(1,2);
		Apple second = new Apple(2, 4);
		
		List<Apple> apples = new ArrayList<>();
		apples.add(first);
		apples.add(second);
		
		apples.sort(Comparator.comparing(Apple::getWeight));
		// reverse
		apples.sort(Comparator.comparing(Apple::getWeight).reversed());

		// comparator chain
		apples.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getSize));
		
		Predicate<Apple> heavierThanTen = (Apple a) -> a.getWeight() > 10;
		Predicate<Apple> largerThanTen = (Apple a) -> a.getSize() > 10;
		
		Predicate<Apple> composed = heavierThanTen.or(largerThanTen);
		
		
		Supplier<Apple> appleFactory = Apple::new;
		System.out.println(appleFactory.get());
		
		
		// function composition
		Function<Integer, Integer> f = (x) -> x * 2;
		Function<Integer, Integer> g = (x) -> x / 2;
		f.compose(g); // = f(g(x))
		f.andThen(g); // = g(f(x))
		
	}
}
