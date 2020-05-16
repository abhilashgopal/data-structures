package com.abhig.array.main;

import com.abhig.array.DynamicArray;
import com.abhig.array.util.DynamicArrays;

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
		System.out.println();
		
		DynamicArray<Integer> d1 = new DynamicArray<>();
		d1.add(0);
		d1.add(8);
		d1.add(9);
		d1.add(10);
		System.out.println("D1 " + d1);
		DynamicArray<Integer> d2 = new DynamicArray<>();
		d2.add(1);
		d2.add(3);
		d2.add(4);
		System.out.println("D2 " + d2);
		System.out.println("Merged: " + DynamicArrays.mergeSorted(d2, d1));
	}

}
