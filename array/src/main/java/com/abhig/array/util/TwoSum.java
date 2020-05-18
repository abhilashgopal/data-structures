package com.abhig.array.util;

import java.util.HashMap;
import java.util.Map;

import com.abhig.ds.util.Assert;

public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		// Check if numbers is null
		Assert.notNull(nums, "Array cannot be null");

		// Create an empty HashMap
		Map<Integer, Integer> compliments = new HashMap<>();

		// Loop over numbers, check if item is in HashMap.
		// If yes, return indices. Else, add the item's compliment with index in HashMap
		int[] indices = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (compliments.containsKey(nums[i])) {
				indices[0] = compliments.get(nums[i]);
				indices[1] = i;
				return indices;
			} else {
				compliments.put(target - nums[i], i);
			}
		}

		return indices;
	}

}
