package io.codextension.algorithm;

import java.util.*;

/**
 * Created by elie on 23.04.17.
 */
public final class MapUtils {
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, SortOrder order) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				if (order == SortOrder.DESCENDING) {
					return (o2.getValue()).compareTo(o1.getValue());
				} else {
					return (o1.getValue()).compareTo(o2.getValue());
				}
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}

		return result;
	}

	public enum SortOrder {
		ASCENDING,
		DESCENDING
	}

}
