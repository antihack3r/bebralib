/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 */

package ru.antihack3r.bebralib.data;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MoreLists {
	
	public static <T> Collector<T, List<T>, ArrayList<T>> toArrayList() {
		return new Collector<T, List<T>, ArrayList<T>>() {
			@Override
			public Supplier<List<T>> supplier() {
				return ArrayList::new;
			}
			
			@Override
			public BiConsumer<List<T>, T> accumulator() {
				return List::add;
			}
			
			@Override
			public BinaryOperator<List<T>> combiner() {
				return (left, right) -> { left.addAll(right); return left; };
			}
			
			@Override
			public Function<List<T>, ArrayList<T>> finisher() {
				return i -> (ArrayList<T>) i;
			}
			
			@Override
			public Set<Characteristics> characteristics() {
				return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
			}
		};
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
		return list.stream().filter(predicate).collect(Collectors.toList());
	}
	
	public static <T> List<T> sort(List<T> list, Comparator<T> comparator) {
		return list.stream().sorted(comparator).collect(Collectors.toList());
	}
	
}
