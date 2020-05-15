package com.abhig.array;

import com.abhig.ds.util.Assert;

public class DynamicArray<E> {

	private static final int DEFAULT_SIZE = 10;

	private Object[] data;

	private int size;

	public DynamicArray() {
		data = new Object[DEFAULT_SIZE];
		size = 0;
	}

	public int size() {
		return size;
	}

	// add - O(1) most times, O(n) sometimes
	public void add(E element) {
		// Check if element is null
		Assert.notNull(element, "Element cannot be null");

		// Check if array is full (size == data.length)
		if (size == data.length) {
			increaseCapacity();
		}

		// Add element
		data[size++] = element;
	}

	// Creating a new array and copying the data - O(n)
	private void increaseCapacity() {
		Object[] temp = data;
		data = new Object[temp.length + DEFAULT_SIZE];

		for (int i = 0; i < temp.length; i++) {
			data[i] = temp[i];
		}
	}

	// addAt - O(n)
	public void addAt(int index, E element) {
		// Check if element is null
		Assert.notNull(element, "Element cannot be null");

		// Check for index range (0 <= index < size)
		Assert.isTrue(0 <= index && index < size, "Index out of bound");

		// Check if array is full
		if (size == data.length) {
			increaseCapacity();
		}

		// Move elements to right - O(n)
		for (int i = size; i > index; i--) {
			data[i] = data[i - 1];
		}

		// Add element
		data[index] = element;
		size++;
	}

	// get
	@SuppressWarnings("unchecked")
	public E get(int index) {
		// Check for index range (0 <= index < size)
		Assert.isTrue(0 <= index && index < size, "Index out of bound");

		return (E) data[index];
	}

	// delete - O(n)
	public void delete(E element) {
		// Check element for null
		Assert.notNull(element, "Element cannot be null");

		// Search element, return if not found
		int index = indexOf(element);

		if (index == -1) {
			return;
		}

		// Move elements to left, make last element null
		for (int i = index; i < size; i++) {
			data[i] = data[i + 1];
		}

		data[--size] = null;
	}

	// indexOf O(n)
	public int indexOf(E element) {
		for (int i = 0; i < size; i++) {
			if (data[i] == element) {
				return i;
			}
		}

		return -1;
	}

	// deleteAt O(n)
	public void deleteAt(int index) {
		// Check for index range (0 <= index < size)
		Assert.isTrue(0 <= index && index < size, "Index out of bound");

		// Move elements to left, make last element null
		for (int i = index; i < size; i++) {
			data[i] = data[i + 1];
		}

		data[--size] = null;
	}

	// reverse O(n/2) => O(n)
	public void reverse() {
		// For each element, exchange it with it's compliment (1st with last, 2nd with
		// last but one = i with size-1-i). Stop at mid. O(n/2) => O(n)
		for (int i = 0; i < size - 1 - i; i++) {
			Object temp = data[i];
			data[i] = data[size - 1 - i];
			data[size - 1 - i] = temp;
		}
	}

	@Override
	public String toString() {
		if (size == 0) {
			return "empty";
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(String.valueOf(data[i]));
			if (i != size - 1) {
				sb.append(",");
			}
		}
		return sb.toString();
	}

}
