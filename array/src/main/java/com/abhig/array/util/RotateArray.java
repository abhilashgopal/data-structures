package com.abhig.array.util;

// Given an array, rotate the array to the right by k steps, where k is non-negative.
public class RotateArray {
	public static void rotate(int[] nums, int k) {
		// Check if nums is null
		if (nums == null) {
			throw new IllegalArgumentException("Array cannot be empty");
		}

		// Check if k is positive
		if (k < 0) {
			throw new IllegalArgumentException("K is invalid");
		}
		
		int[] newArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
          newArray[(i + k) % nums.length] = nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
          nums[i] = newArray[i];
        }
	}
}
