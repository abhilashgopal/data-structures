package com.abhig.array;

import com.abhig.ds.util.Assert;

public class DynamicArray<E> {

	private static final int DEFAULT_SIZE = 10;

	private Object[] data;

	private int size;

	public DynamicArray() {
		this.data = new Object[DEFAULT_SIZE];
		this.size = 0;
	}

	public DynamicArray(int size) {
		this.data = new Object[size];
		this.size = 0;
	}

	/**
	 * Returns the size of the array.
	 * 
	 * @return returns an {@code int} indicating the size of the array.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns {@code true} if array is empty.
	 * 
	 * @return returns {@code true} if {@code size} is zero, {@code false}
	 *         otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Adds the item to the end of this array.
	 * <p>
	 * Time complexity is O(1) most times, O(n) sometimes.
	 * 
	 * @param item the item to add.
	 */
	public void add(E item) {
		// Check if item is null
		Assert.notNull(item, "item cannot be null");

		// Check if array is full (size == data.length)
		if (size == data.length) {
			increaseCapacity();
		}

		// Add item
		data[size++] = item;
	}

	// Creating a new array and copying the data - O(n)
	private void increaseCapacity() {
		Object[] temp = data;
		data = new Object[temp.length + DEFAULT_SIZE];

		for (int i = 0; i < temp.length; i++) {
			data[i] = temp[i];
		}
	}

	/**
	 * Adds the item at the specified position.
	 * <p>
	 * Time complexity is O(n).
	 * 
	 * @param index the position at which the item should be added.
	 * @param item  the item to add.
	 */
	public void addAt(int index, E item) {
		// Check if item is null
		Assert.notNull(item, "item cannot be null");

		// Check for index range (0 <= index < size)
		Assert.isTrue(0 <= index && index < size, "Index out of bound");

		// Check if array is full
		if (size == data.length) {
			increaseCapacity();
		}

		// Move items to right - O(n)
		for (int i = size; i > index; i--) {
			data[i] = data[i - 1];
		}

		// Add item
		data[index] = item;
		size++;
	}

	/**
	 * Returns the item at the specified position.
	 * <p>
	 * Time complexity is O(1).
	 * 
	 * @param index the position to retrieve the item from.
	 * @return the item at {@code index}.
	 */
	@SuppressWarnings("unchecked")
	public E get(int index) {
		// Check for index range (0 <= index < size)
		Assert.isTrue(0 <= index && index < size, "Index out of bound: " + index);

		return (E) data[index];
	}

	/**
	 * Returns the position of the first occurrence of the specified item.
	 * <p>
	 * Time complexity is O(n).
	 * 
	 * @param item the item to search for.
	 * @return index of the {@code item}.
	 */
	public int indexOf(E item) {
		for (int i = 0; i < size; i++) {
			if (data[i] == item) {
				return i;
			}
		}

		return -1;
	}
	
	/**
	 * Deletes the first occurrence of the specified item.
	 * <p>
	 * Time complexity is O(n).
	 * 
	 * @param item the item to be deleted.
	 */
	public void delete(E item) {
		// Check item for null
		Assert.notNull(item, "item cannot be null");

		// Search item, return if not found
		int index = indexOf(item);

		if (index == -1) {
			return;
		}

		// Move items to left, make last item null
		for (int i = index; i < size; i++) {
			data[i] = data[i + 1];
		}

		data[--size] = null;
	}

	/**
	 * Deletes the item at the specified position.
	 * <p>
	 * Time complexity is O(n).
	 * 
	 * @param index the position of the item to delete.
	 */
	public void deleteAt(int index) {
		// Check for index range (0 <= index < size)
		Assert.isTrue(0 <= index && index < size, "Index out of bound");

		// Move items to left, make last item null
		for (int i = index; i < size; i++) {
			data[i] = data[i + 1];
		}

		data[--size] = null;
	}

	/**
	 * Reverses the order of items in the array
	 * <p>
	 * Time complexity is O(n/2) ~ O(n)
	 */
	public void reverse() {
		// For each item, exchange it with it's compliment (1st with last, 2nd with
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
