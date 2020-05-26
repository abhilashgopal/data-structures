package com.abhig.array.util;

import java.util.HashMap;
import java.util.Map;

import com.abhig.ds.util.Assert;

// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		// Check if numbers is null
		Assert.notNull(nums, "Array cannot be null");

		// Create an empty HashMap
		Map<Integer, Integer> complements = new HashMap<>();

		// Loop over numbers, check if item is in HashMap.
		// If yes, return indices. Else, add the item's compliment with index in HashMap
		for (int i = 0; i < nums.length; i++) {
			if (complements.containsKey(nums[i])) {
				return new int[] { complements.get(nums[i]), i };
			}
			complements.put(target - nums[i], i);
		}

		throw new IllegalArgumentException("Items not found");
	}

}
