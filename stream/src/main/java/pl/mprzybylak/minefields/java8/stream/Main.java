package pl.mprzybylak.minefields.java8.stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.IntStream.Builder;

public class Main {
	

	private static int sum;

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		List<Integer> l2 = list.stream()
				.filter((i) -> i < 4 )
				.filter((i) -> i < 2)
				.collect(Collectors.toList());
		
		System.out.println(list.stream().reduce(0, Integer:: sum));
		
		if(list.stream().anyMatch((Integer p) -> p%2 == 0)) {
			System.out.println("Even");
		}
		
		if(list.stream().allMatch(p -> p%2 != 0)) {
		}
		else {
			System.out.println("Not only odd");
		}
		
		System.out.println(l2);
		
		
		
		
		
		List<Money> moneyList = Arrays.asList(
				new Money("pl",100), 
				new Money("pl", 20), 
				new Money("eur", 10),
				new Money("eur", 20),
				new Money("usd", 100)
				);
		
		// old way
		Map<String, List<Money>> moneyMap = new HashMap<>();
		for(Money m : moneyList) {
			List<Money> currencyList = moneyMap.get(m.getCurrency());
			if(currencyList == null) {
				currencyList = new ArrayList<Money>();
				moneyMap.put(m.getCurrency(), currencyList);
			}
			currencyList.add(m);
		}
		System.out.println(moneyMap);
		
		// new way
		Map<String, List<Money>> mMap = moneyList.stream().collect(groupingBy(Money::getCurrency));
		System.out.println(mMap);
		
		moneyList.stream().collect(groupingBy(Money::getCurrency, mapping(Money::getValue, toList())));
		Map<String, Integer> moneySum = moneyList.stream().collect(groupingBy(Money::getCurrency, Collectors.summingInt(Money::getValue)));
		System.out.println(moneySum);
		
		
		mMap.forEach((s, l) -> System.out.println(s + " " + l));

		Builder builder = IntStream.builder();
		IntStream build = builder.add(1).add(1).add(2).build();
		
		IntSummaryStatistics statistics = moneyList.stream().collect(Collectors.summarizingInt(Money::getValue));
		
		// partitioning
		Map<Boolean, List<Money>> partition = moneyList.stream().collect(Collectors.partitioningBy((Money m) -> m.getCurrency().equals("pl")));
		System.out.println(partition);
		
		// operation on partitioned data
		Map<Boolean, Money> highestMoneyInPartition = moneyList.stream().collect(
				partitioningBy((Money m) -> m.getCurrency().equals("pl"),
						collectingAndThen(
								maxBy(comparingInt(Money::getValue)), 
								Optional::get)));
		System.out.println(highestMoneyInPartition);
	}
}
