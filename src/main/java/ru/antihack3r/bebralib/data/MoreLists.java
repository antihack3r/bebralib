/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/rusnuker/bebralib
 */

package ru.antihack3r.bebralib.data;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MoreLists {
	
	public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
		return list.stream().filter(predicate).collect(Collectors.toList());
	}
	
	public static <T> List<T> sort(List<T> list, Comparator<T> comparator) {
		return list.stream().sorted(comparator).collect(Collectors.toList());
	}
	
}
