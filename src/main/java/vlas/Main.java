//cloneable

package vlas;

import vlas.entity.Storage;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        try{
        int numberForSearch = 31;
        Storage intStorage = new Storage(6);
        Comparator<Integer> ascendingComparator = Integer::compareTo;

        intStorage.set(0, 1.666);
        intStorage.set(1, 31);
        intStorage.add(112);
        intStorage.add(102);
        intStorage.set(4, 133);
        intStorage.set(5, 12);

        System.out.println(intStorage);

        int index1 = intStorage.find(112);
            if (index1 != -1) {
                String found = String.format("Found! It's place: %d", index1);
                System.out.println(found);
            } else {
                System.out.println("No such element");
            }

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

         } catch (IndexOutOfBoundsException | NoSuchElementException e) {
               System.out.println(e);
        }
    }
}



