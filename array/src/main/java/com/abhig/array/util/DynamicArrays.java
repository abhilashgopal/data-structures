package com.abhig.array.util;

import com.abhig.array.DynamicArray;
import com.abhig.ds.util.Assert;

public class DynamicArrays {

	/**
	 * Merges two sorted {@code DynamicArray} and returns a new one with items from
	 * both arrays.
	 * <p>
	 * Time complexity is O(n)
	 * <p>
	 * Space complexity is O(m + n)
	 * 
	 * @param <E> the type of objects in the two arrays
	 * @param d1  sorted array 1
	 * @param d2  sorted array 2
	 * @return a sorted array with items from {@code d1} and {@code d2}
	 */
	public static <E extends Comparable<E>> DynamicArray<E> mergeSorted(DynamicArray<E> d1, DynamicArray<E> d2) {
		// Check for null and empty
		Assert.isTrue(d1 != null && !d1.isEmpty(), "Array should not be null or empty");
		Assert.isTrue(d2 != null && !d2.isEmpty(), "Array should not be null or empty");

		// Check if arrays are sorted ?

		// Create an empty array
		DynamicArray<E> mergedArray = new DynamicArray<>(d1.size() + d2.size());

		// Compare d1[i] with d2[j], add lowest to new array, increment i or j - O(n)
		int i = 0;
		int j = 0;
		while (i < d1.size() && j < d2.size()) {
			if (d1.get(i).compareTo(d2.get(j)) <= 0) {
				mergedArray.add(d1.get(i++));
			} else {
				mergedArray.add(d2.get(j++));
			}
		}

		// Add remaining - either i will be equal to d1.size or j will be equal to
		// d2.size. Add the other.
		int k;
		DynamicArray<E> temp;
		if (i != d1.size()) {
			k = i;
			temp = d1;
		} else {
			k = j;
			temp = d2;
		}

		while (k < temp.size()) {
			mergedArray.add(temp.get(k++));
		}

		// return new array
		return mergedArray;
	}

}
