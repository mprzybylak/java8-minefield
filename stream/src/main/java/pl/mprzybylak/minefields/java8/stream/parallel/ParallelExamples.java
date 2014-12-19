package pl.mprzybylak.minefields.java8.stream.parallel;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelExamples {

	public static void main(String[] args) {
		
		// simple parallel sum
		long sum = LongStream.rangeClosed(1, 1000).parallel().reduce(0L, Long::sum);
		System.out.println(sum);
		
		// amount of processors available in system
		System.out.println(Runtime.getRuntime().availableProcessors());
		
	}
	
}
