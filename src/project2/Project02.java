package project2;

import java.util.ArrayList;

public class Project02 {

    public static void main(String[] args) {

        int[] table = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int localMax = table[0];
        ArrayList<Integer> subArr = new ArrayList<Integer>();

        for (int i = 1; i < table.length - 1; i++) {

            localMax = Math.max(localMax + table[i], table[i + 1]);
        }
    }
}
