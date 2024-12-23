package project2;

import java.util.*;

public class Project02 {

    public static void main(String[] args) {

        int[] table = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] localMaxesTable = new int[table.length];
        int localMax = table[0];
        int startIndex = 0;
        ArrayList<Integer> outSubArr = new ArrayList<Integer>();

        for (int i = 1; i < table.length; i++) {
            localMax = Math.max(localMax + table[i], table[i]);
            localMaxesTable[i] = localMax;

            if (localMax == table[i]) {
                startIndex = i;
            }
        }
        //System.out.println(Arrays.toString(localMaxesTable));
        int maxIndex = getMaxIndex(localMaxesTable);

        // Populate the output maximum sub array using the indexes
        for (int i = startIndex; i <= maxIndex; i++) {
            outSubArr.add(table[i]);
        }
        System.out.println(outSubArr);
    }


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
