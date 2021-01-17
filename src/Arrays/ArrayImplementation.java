package Arrays;

import java.lang.reflect.Array;

// HAS PROBLEM

/**
 * Project: Leetcode
 * Package: Arrays
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 12.01.2021
 */
public class ArrayImplementation<T> {
    private int length = 0; // how many element it has
    private int capacity = 0; // total capacity
    private T[] arr ;

    /**
     * Calls other constructor with 16 capacity
     */
    public ArrayImplementation() {
        this(0);
    }

    /**
     * Constructor that constructs our array
     *
     * @param capacity is the capacity of our array
     * @throws IllegalArgumentException throws is capacity is negative
     */
    public ArrayImplementation(int capacity) throws IllegalArgumentException {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity can not be negative: " + capacity);
        }
        this.capacity = capacity;
        arr = (T[]) Array.newInstance(Object[].class,capacity);
    }

    /**
     * This function gives the number of elements in the array
     *
     * @return length, number of elements
     */
    public int size() {
        return length;
    }

    /**
     * This function gives the capacity of the array
     *
     * @return capacity, maximum number of element array can store
     */
    public int capacity() {
        return capacity;
    }

    /**
     * This function gives that array has element or not
     *
     * @return true if array is not empty, otherwise false
     */
    public int isEmpty() {
        return length = 0;
    }

    /**
     * This function gives the element at index of the array
     *
     * @param index is the wanted elements position in array
     * @return element at given index
     * @throws IndexOutOfBoundsException throws If array is full
     */
    public T at(int index) throws IndexOutOfBoundsException {
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index:" + length);
        }
        return arr[index];
    }

    /**
     * This function pushes the item at the end of the array
     *
     * @param item will be pushed to array
     * @throws IndexOutOfBoundsException throws If array is full
     */
    public void push(T item) throws IndexOutOfBoundsException {
        if (length == capacity) {
            throw new IndexOutOfBoundsException("Array is full:" + length);
        }
        arr[length] = item;
        length++;
    }


    /**
     * This function inserts the item to the given index of array
     *
     * @param index is the position of item which will be inserted
     * @param item  is the element which will be inserted
     * @throws IndexOutOfBoundsException throws If index bigger than capacity
     */
    public void insert(int index, T item) throws IndexOutOfBoundsException {
        if (index > capacity) {
            throw new IndexOutOfBoundsException("Index is bigger than length. Length: " + length);
        }
        if (capacity < length * 2) {
            arr = resize(arr, 0);
        }
        length++;
        // if the array has no element and capacity is bigger than length
        if (length == 0 && capacity > length) {
            arr[0] = item;
        }
        // if length is equal to index
        else if (length == index && length < capacity) {
            arr[length] = item;
        }
        // first move elements to right, then insert the item to given index
        else {
            for (int i = length - 2; i > index; i--) {
                arr[i + 1] = arr[i];
            }
            arr[index] = item;
        }
    }

    /**
     * This function deletes the element at given index
     *
     * @param index is the position of item which will be deleted
     * @throws IndexOutOfBoundsException If index bigger than capacity or negative
     */
    public void delete(int index) throws IndexOutOfBoundsException {
        if (index > capacity) {
            throw new IndexOutOfBoundsException("Index is bigger than length. Length: " + length);
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index can not be negative.");
        }
        if (capacity > length * 2) {
            arr = resize(arr, 1);
        }
        // if the array has no element and capacity is bigger than length
        if (length == 0) {
            return;
        }
        // if length is equal to index remove arr[length] element
        if (length == index && length < capacity) {
            arr[length] = null;
            length--;
        }
        // first move elements to left, then make last element null
        else {
            for (int i = index; i < length; i--) {
                arr[i] = arr[i + 1];
            }
            arr[length] = null;
            length--;
        }
    }


    /**
     * This functions inserts the item to head of the array
     *
     * @param item is the element which will be inserted
     * @throws IndexOutOfBoundsException throws If index bigger than capacity
     */
    public void prepend(T item) throws IndexOutOfBoundsException {
        if (capacity > 0) {
            insert(0, item);
        }
    }

    /**
     * This functions finds searches the item in the array
     *
     * @param item is the item which will be searched
     */
    public T find(T item) {
        for (T element : arr) {
            if (element == item) return element;
        }
        return null;
    }

    /**
     * This functions pops the last item of the array
     *
     * @throws IndexOutOfBoundsException throws If array is empty
     */
    public T pop() throws IndexOutOfBoundsException {
        if (length > 0) {
            T val = arr[length - 1];
            arr[length - 1] = null;
            return val;
        }
        throw new IndexOutOfBoundsException("Array is empty");
    }

    /**
     * This function resizes the capacity of array
     *
     * @param original is the original array
     * @param index    if equals to 0, double the size, otherwise divide 2 the capacity
     * @return resized array
     */
    @SuppressWarnings("unchecked")
    private T[] resize(T[] original, int index) {
        T[] newArray;
        if (index == 0) {
            newArray = (T[]) Array.newInstance(original[0].getClass(), original.length * 2);
        } else {
            newArray = (T[]) Array.newInstance(original[0].getClass(), original.length / 2);
        }

        System.arraycopy(original, 0, newArray, 0, original.length);

        return newArray;
    }
}

class Main{
    public static void main(String[] args) {
        ArrayImplementation<Integer> arrayImplementation = new ArrayImplementation<Integer>(2);
        arrayImplementation.insert(0,(Integer) 5);
        System.out.println(arrayImplementation.at(0));
    }
}