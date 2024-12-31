package project2;

import java.util.*;
/**
 * Project 2 solution attempt for CF7 (Five-Projects PDF Chapter.10 "Structured Programming")
 * View attached png file for a more detailed explanation.
 */
public class Project02 {

    public static void main(String[] args) {

        int[] table = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // Input array
        int[] localMaxesArr = new int[table.length]; // Array to store maximum values of table's elements on each position of table
        int localMax = table[0];
        int startIndex = 0;
        ArrayList<Integer> outSubArr = new ArrayList<Integer>();

        // Starting loop (to populate localMaxesArr) from index 1 since we've already initiated localmax with the array's 0 position
        for (int i = 1; i < table.length; i++) {
            localMax = Math.max(localMax + table[i], table[i]);
            localMaxesArr[i] = localMax;
            /*
            If the value on the i-th element is greater than the "localmax" of the already parsed elements,
            then we give "localmax" the value of that (i-th) element and save the index since it's a
            candidate for the sub array's beginning index.
             */
            if (localMax == table[i]) {
                startIndex = i;
            }
        }
        int maxIndex = getMaxIndex(localMaxesArr); // The ending index of the sub array

        // Populate the output maximum sub array using the indexes
        for (int i = startIndex; i <= maxIndex; i++) {
            outSubArr.add(table[i]);
        }
        System.out.println(outSubArr);
    }

    /**
     * Helper function. Finds the max value of a table and returns its index.
     * @param table array of integers.
     * @return the index of the table's element with the maximum value
     */
    public static int getMaxIndex (int[] table) {
        int max = table[0];
        int maxIndex = 0;

        for (int i = 1; i < table.length; i++) {
            if (table[i] > max) {
                max = table[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
