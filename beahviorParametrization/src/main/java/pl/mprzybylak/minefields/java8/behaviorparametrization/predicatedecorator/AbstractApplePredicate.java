package pl.mprzybylak.minefields.java8.behaviorparametrization.predicatedecorator;

import pl.mprzybylak.minefields.java8.behaviorparametrization.entity.Apple;

public abstract class AbstractApplePredicate implements ApplePredicate {

	protected ApplePredicate predicate;

	abstract boolean predicateDefinition(Apple apple);
	
	@Override
	public boolean test(Apple apple) {
		return predicateDefinition(apple) && ((predicate == null) ? true : predicate.test(apple));
	}

	
	
}
