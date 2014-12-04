package pl.mprzybylak.minefields.java8.behaviorparametrization.predicatedecorator;

import pl.mprzybylak.minefields.java8.behaviorparametrization.entity.Apple;

public interface ApplePredicate {
	boolean test(Apple apple);
}
