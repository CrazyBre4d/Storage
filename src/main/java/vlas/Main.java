package vlas;

import vlas.entity.Storage;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        try{
        int numberForSearch = 31;
        Storage<Integer> intStorage = new Storage<>(5);
        Comparator<Integer> ascendingComparator = Integer::compareTo;

        intStorage.set(0, 1);
        intStorage.set(1, null);
        intStorage.add(112);
        intStorage.set(3, 133);
        intStorage.set(4, 12);

        System.out.println(intStorage);

        intStorage.find(112);
        intStorage.sort();

        System.out.println(intStorage);

        int index = intStorage.binarySearch(numberForSearch, ascendingComparator);
        String found = String.format("Element detected: %d", index);
        intStorage.binarySearch(numberForSearch,ascendingComparator);

        if (index != -1) {
            System.out.println(found);
        } else {
            System.out.println("No such element");
        }
        } catch (IndexOutOfBoundsException | NoSuchElementException | NullPointerException e) {
            System.out.println(e);
        }
    }
}



