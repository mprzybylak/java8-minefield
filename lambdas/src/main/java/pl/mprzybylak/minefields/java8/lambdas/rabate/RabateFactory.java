package pl.mprzybylak.minefields.java8.lambdas.rabate;

import java.util.function.Supplier;

public enum RabateFactory {
	
	NO_RABATE(NoRabate::new),
	NORMAL_RABATE(RegularRabate::new),
	VIP_RABATE(VipRabate::new);

	private Supplier<Rabate> rabateSupplier;

	private RabateFactory(Supplier<Rabate> rabateSupplier) {
		this.rabateSupplier = rabateSupplier;
	}
	
	public Rabate get() {
		return rabateSupplier.get();
	}
	
}