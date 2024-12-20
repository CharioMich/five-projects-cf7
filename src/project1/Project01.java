package project1;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.nio.charset.StandardCharsets;

/**
 *  Project 01 solution attempt for CF7
 *  To test code modify file paths to the desired locations
 */

public class Project01 {

    public static void main(String[] args) {

        final int LEN = 6;
        String line;
        int[] sixTable = new int[LEN];
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        // File paths
        String inFile = "C:/Users/someUser/numbers.txt";
        String outFile = "C:/Users/someUser/outNumbers.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inFile));
                PrintStream ps = new PrintStream(new FileOutputStream(outFile, true), true, StandardCharsets.UTF_8)) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                for (String part : parts) {
                    int number = Integer.parseInt(part.trim());
                    numbers.add(number);
                }
            }

            int size = numbers.size();

            for (int i = 0; i <= size - LEN; i++) {
                for (int j = i + 1; j <= size - LEN + 1; j++) {
                    for (int k = j + 1; k <= size - LEN + 2; k++) {
                        for (int l = k + 1; l <= size - LEN + 3; l++) {
                            for (int m = l + 1; m <= size - LEN + 4; m++) {
                                for (int h = m + 1; h < size; h++) {
                                    sixTable[0] = numbers.get(i);
                                    sixTable[1] = numbers.get(j);
                                    sixTable[2] = numbers.get(k);
                                    sixTable[3] = numbers.get(l);
                                    sixTable[4] = numbers.get(m);
                                    sixTable[5] = numbers.get(h);

                                    if (fourEven(sixTable) && fourOdd(sixTable) && twoConsecutive(sixTable) && threeSameEnding(sixTable) && threeSameTens(sixTable)) {
                                        ps.printf(Arrays.toString(sixTable) + '\n');
                                    }
                                }
                            }
                        }
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Filtering functions below this point

    public static boolean fourEven (int[] table) {
        int counter = 0;
        for (int num : table) {
            if (num % 2 == 0) {
                counter++;
            }
        }
        return counter <= 4;
    }

    public static boolean fourOdd (int[] table) {
        int counter = 0;
        for (int num : table) {
            if (num % 2 == 1) counter++;
        }
        return counter <= 4;
    }

    public static boolean twoConsecutive (int[] table) {
        int counter = 0;
        for (int i = 0; i < table.length - 2; i++) {
            if (table[i] == table[i + 1] - 1 && table[i + 1] == table[i + 2] - 1) {
                counter++;
            }
        }
        return counter <= 1;
    }

    public static boolean threeSameEnding (int[] table) {
        boolean maxThree = true;
        int[] endings = new int[10];

        for (int num : table) {
            endings[num % 10]++;
        }

        for (int digit : endings) {
            if (digit > 3) {
                maxThree = false;
                break;
            }
        }
        return maxThree;
    }

    public static boolean threeSameTens (int[] table) {
        boolean maxThree = true;
        // Numbers in file are only from 1 to 49 so the size of the possible "tens" table is 5 including those numbers from 0-9
        int[] tens = new int[5];

        for (int num : table) {
            tens[num / 10]++;
        }

        for (int count : tens) {
            if (count > 3) {
                maxThree = false;
                break;
            }
        }
        return maxThree;
    }

}