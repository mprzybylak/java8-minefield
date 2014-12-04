package pl.mprzybylak.minefields.java8.behaviorparametrization;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import pl.mprzybylak.minefields.java8.behaviorparametrization.entity.Apple;
import pl.mprzybylak.minefields.java8.behaviorparametrization.entity.Taste;
import pl.mprzybylak.minefields.java8.behaviorparametrization.predicatedecorator.ApplePredicate;
import pl.mprzybylak.minefields.java8.behaviorparametrization.predicatedecorator.GreenPredicate;
import pl.mprzybylak.minefields.java8.behaviorparametrization.predicatedecorator.LightweightPredicate;

public class AppleExample {
	
	public static void main(String[] args) {

		List<Apple> apples = apples();
		
		// filter only green apples
		List<Apple> greenOnes = new ArrayList<Apple>();
		for(Apple apple : apples) {
			if(apple.getColor().equals("green")) {
				greenOnes.add(apple);
			}
		}
		System.out.println(greenOnes);
		
		// decorator version
		List<Apple> greenAndLightOnes = new ArrayList<Apple>();
		for(Apple apple : apples) {
			if(new GreenPredicate(new LightweightPredicate()).test(apple)) {
				greenAndLightOnes.add(apple);
			}
		}
		System.out.println(greenAndLightOnes);
		
		// with method
		List<Apple> newGreenOnes = filter(apples, new GreenPredicate());
		System.out.println(newGreenOnes);
		
		// with lambda
		List<Apple> onceAgainGreenOnes = filter(apples, (Apple apple) -> apple.getColor().equals("green"));
		System.out.println(onceAgainGreenOnes);
	
		// real predicate
		List<Apple> andAgainGreenOnes = filterWithPredicate(apples, (Apple apple) -> apple.getColor().equals("green"));
		System.out.println(andAgainGreenOnes);
	}
	
	private static List<Apple> filter(List<Apple> apples, ApplePredicate predicate) {
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple : apples) {
			if(predicate.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	private static <T> List<T> filterWithPredicate(List<T> list, Predicate<T> predicate) {
		List<T> results = new ArrayList<T>();
		for(T t : list) {
			if(predicate.test(t)) {
				results.add(t);
			}
		}
		return results;
	}

	private static List<Apple> apples() {
		List<Apple> apples = new ArrayList<Apple>(10);
		for(int i = 0; i < 100; ++i) {
			apples.add(new Apple( i % 2 == 0 ? "green" : "red",
					i * 2, i % 5 == 0 ? Taste.SOUR : Taste.SWEET ));
		}
		return apples;
	}
}
