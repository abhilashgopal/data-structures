package com.abhig.array.util;

import com.abhig.ds.util.Assert;

public class MoveZeros {

	public static void moveZeroes(int[] nums) {
		Assert.notNull(nums, "Array cannot be null");

		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != 0) {
				nums[i++] = nums[j];
			}
		}

		while (i < nums.length) {
			nums[i++] = 0;
		}
	}
}
