package com.abhig.array.util;

import java.util.HashSet;
import java.util.Set;

import com.abhig.ds.util.Assert;

public class ContainsDuplicate {

	public static boolean containsDuplicate(int[] nums) {
		Assert.notNull(nums, "Array cannot be null");

		Set<Integer> items = new HashSet<>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			if (!items.add(nums[i])) {
				return true;
			}
		}

		return false;
	}

}