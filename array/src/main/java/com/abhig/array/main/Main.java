package com.abhig.array.main;

import com.abhig.array.DynamicArray;

public class Main {

	public static void main(String[] args) {
		DynamicArray<Integer> dynamicArray = new DynamicArray<>();
		System.out.println(dynamicArray + " | Size = " + dynamicArray.size());
		System.out.println();
		dynamicArray.add(1);
		dynamicArray.add(2);
		dynamicArray.add(3);
		dynamicArray.add(4);
		dynamicArray.add(5);
		System.out.println(dynamicArray + " | Size = " + dynamicArray.size());
		System.out.println();
		dynamicArray.addAt(1, 6);
		System.out.println(dynamicArray + " | Size = " + dynamicArray.size());
		System.out.println();
		dynamicArray.delete(6);
		System.out.println(dynamicArray + " | Size = " + dynamicArray.size());
		System.out.println();
		dynamicArray.addAt(4, 6);
		System.out.println(dynamicArray + " | Size = " + dynamicArray.size());
		System.out.println();
		dynamicArray.deleteAt(4);
		System.out.println(dynamicArray + " | Size = " + dynamicArray.size());
		System.out.println();
		dynamicArray.add(6);
		dynamicArray.reverse();
		System.out.println(dynamicArray + " | Size = " + dynamicArray.size());
	}

}
