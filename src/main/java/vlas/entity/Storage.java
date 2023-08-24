package vlas.entity;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Storage<T extends Number>  {
    private T[] data;
    
    public Storage() {}

    public Storage(T[] initialArray) {
        data = Arrays.copyOf(initialArray, initialArray.length);
    }

    public Storage(int capacity) {
        data = (T[]) new Number[capacity];
    }

    public void set(int index, T value) {
        if (index >= 0 && index < data.length) {
            data[index] = value;
        } else {
           throw new IndexOutOfBoundsException("set: No such cell exists");
        }
    }

    public T get(int index) {
        if ((index >= 0 && index < data.length)) {
            return data[index];
        } else {
            throw new NoSuchElementException("get: No such cell exists");
        }
    }

    public void remove(int index) {
        if (index >= 0 && index < data.length) {
            data[index] = null;
        } else {
            throw new NoSuchElementException(" remove: No such cell exists");
        }
    }

    public void add(T value) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = value;
                return;
            }
        }
        T[] newData = Arrays.copyOf(data, data.length + 1);
        newData[newData.length - 1] = value;
        data = newData;
    }

   public void find(T value) {
        boolean found = false;
        
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && data[i].equals(value)) {
                System.out.println("Detected! It's place: " + i);
                found = true;
                break;  
            }
        }
        
        if (!found) {
            throw new NoSuchElementException("find: No such element exists");
        }
    }


    public void sort() {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i] != null && data[i + 1] != null && data[i].doubleValue() > data[i + 1].doubleValue()) {
                    T temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
    public int binarySearch(T target, Comparator<T> comparator) {
        for (int i = 0; i < data.length; i++) {
             if (data[i] == null) {
                 throw new NullPointerException("binarySearch: Fill the array");}}

        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = comparator.compare(data[mid], target);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public int length() {
        return data.length;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
