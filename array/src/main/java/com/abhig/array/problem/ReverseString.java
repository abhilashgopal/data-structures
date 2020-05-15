package com.abhig.array.problem;

import com.abhig.ds.util.Assert;

public class ReverseString {

	public String reverseString(String s) {
		// Check for null and empty
		Assert.notBlank(s, "String is null or blank");

		// Convert to char array - Probably O(n)
		char[] charArray = s.toCharArray();

		// For each element, exchange it with it's compliment (1st with last, 2nd with
		// last but one = i with size-1-i). Stop at mid. O(n/2) => O(n)
		for (int i = 0; i < charArray.length - 1 - i; i++) {
			char c = charArray[i];
			charArray[i] = charArray[charArray.length - 1 - i];
			charArray[charArray.length - 1 - i] = c;
		}

		// Convert array to string.
		// This will probably be O(n) again. Instead of converting String to array, loop
		// over String and build another using StringBuilder. Memory will be O(n) then,
		// but it's the same even now
		return new String(charArray);
	}
}
