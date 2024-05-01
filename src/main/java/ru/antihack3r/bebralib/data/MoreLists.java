/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 */

package ru.antihack3r.bebralib.data;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Some more list utilities.
 */
public class MoreLists {
	
	/**
	 * Collects to an {@link ArrayList}.
	 * @return an {@link ArrayList} containing the values in the original order.
	 * @param <T> a type of value in the list.
	 */
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
	
	/**
	 * Filters {@code list} using a given {@code predicate}.
	 * @param list a list which needs to be filtered.
	 * @param predicate a predicate to be used to filter {@code list}.
	 * @return a filtered {@code list}.
	 * @param <T> a type of value in {@code list}.
	 */
	public static <T> @Nonnull List<T> filter(@Nonnull List<T> list, @Nonnull Predicate<T> predicate) {
		return list.stream().filter(predicate).collect(Collectors.toList());
	}
	/**
	 * Sorts {@code list} using a given {@code comparator}.
	 * @param list a list which needs to be sorted.
	 * @param comparator a comparator to be used to sort {@code list}.
	 * @return a sorted {@code list}.
	 * @param <T> a type of value in {@code list}.
	 */
	public static <T> List<T> sort(List<T> list, Comparator<T> comparator) {
		return list.stream().sorted(comparator).collect(Collectors.toList());
	}
	
}
