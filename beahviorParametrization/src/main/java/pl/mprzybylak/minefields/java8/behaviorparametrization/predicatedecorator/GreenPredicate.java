package pl.mprzybylak.minefields.java8.behaviorparametrization.predicatedecorator;

import pl.mprzybylak.minefields.java8.behaviorparametrization.entity.Apple;

public class GreenPredicate extends AbstractApplePredicate {

	public GreenPredicate() {
	}
	
	public GreenPredicate(ApplePredicate predicate) {
		this.predicate = predicate;
	}
	
	@Override
	public boolean predicateDefinition(Apple apple) {
		return apple.getColor().equals("green");
	}

}
