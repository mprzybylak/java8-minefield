package pl.mprzybylak.minefields.java8.stream.collectors.collectorinterface;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;


/**
 * 
 * @param <T> [T]ype of items to be collected
 * @param <A> [A]ccumulator (where the partial results will be stored)
 * @param <R> [R]esult of collect operation
 */
public class SimpleCollector<T> implements Collector<T, List<T>, List<T>> {

	/* (non-Javadoc)
	 * @see java.util.stream.Collector#accumulator()
	 * Purpose of this method is to provide "reduction" function.
	 * Reduction function is function that will "fold" value of accumulator and n-th element of stream
	 * result of folding should be stored in accumulator
	 */
	@Override
	public BiConsumer<List<T>, T> accumulator() {
		return List::add;
	}

	/* (non-Javadoc)
	 * @see java.util.stream.Collector#characteristics()
	 * Purpose of this method is to provide "hints" to stream processing logic
	 * that would help to determine how this collector should act in parallel environment
	 */
	@Override
	public Set<java.util.stream.Collector.Characteristics> characteristics() { 
		return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED));
	}

	/* (non-Javadoc)
	 * @see java.util.stream.Collector#combiner()
	 * When stream is procesed in parallel - there will be a moment when 
	 * partial results of each thread should be combined into one result.
	 * Purpose of this method is to provide function that will do this combine
	 * operation
	 */
	@Override
	public BinaryOperator<List<T>> combiner() {
		return (l1, l2) -> {
			l1.addAll(l2);
			return l1;
		};
	}

	/* (non-Javadoc)
	 * @see java.util.stream.Collector#finisher()
	 * Purpose of this function is to provide function object that will perform
	 * final transformation on accumulator after stream is traversed
	 */
	@Override
	public Function<List<T>, List<T>> finisher() {
		return Function.identity(); 
	}

	/* (non-Javadoc)
	 * @see java.util.stream.Collector#supplier()
	 * 
	 * Purpose of this method is to provide "empty" result object where real result
	 * will be "accumulated" 
	 */
	@Override
	public Supplier<List<T>> supplier() {
		return LinkedList<T>::new;
	}



}
