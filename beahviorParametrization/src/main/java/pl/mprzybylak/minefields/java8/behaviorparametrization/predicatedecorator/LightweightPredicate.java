package pl.mprzybylak.minefields.java8.behaviorparametrization.predicatedecorator;

import pl.mprzybylak.minefields.java8.behaviorparametrization.entity.Apple;


public class LightweightPredicate extends AbstractApplePredicate {

	public LightweightPredicate() {
	}

	public LightweightPredicate(ApplePredicate predicate) {
		this.predicate = predicate;
	}
	
	@Override
	public boolean predicateDefinition(Apple apple) {
		return apple.getWeight() < 100;
	}

}
