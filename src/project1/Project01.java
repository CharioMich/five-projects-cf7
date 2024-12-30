package project1;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.nio.charset.StandardCharsets;

/**
 *  Project 01 solution attempt for CF7 (Five-Projects PDF Chapter.10 "Structured Programming")
 *  To test code modify file paths to the desired locations
 */
public class Project01 {

    public static void main(String[] args) {

        final int LEN = 6;
        String line;
        int[] sixArr = new int[LEN];
        int[] numbers = new int[49];
        int topIndex = 0;

        // File paths
        String inFile = "C:/temp/numbers.txt";
        String outFile = "C:/temp/outNumbers.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inFile));
                PrintStream ps = new PrintStream(new FileOutputStream(outFile, true), true, StandardCharsets.UTF_8)) {

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                for (String part : parts) {
                    int number = Integer.parseInt(part.trim());
                    numbers[topIndex] = number;
                    topIndex++;
                    if (topIndex >= 49) {
                        throw new Exception("Input file contains more than 49 numbers.");
                    }
                }
            }

            Arrays.sort(numbers, 0, topIndex);
            int size = topIndex;

            for (int i = 0; i <= size - LEN; i++) {
                for (int j = i + 1; j <= size - LEN + 1; j++) {
                    for (int k = j + 1; k <= size - LEN + 2; k++) {
                        for (int l = k + 1; l <= size - LEN + 3; l++) {
                            for (int m = l + 1; m <= size - LEN + 4; m++) {
                                for (int h = m + 1; h < size; h++) {
                                    sixArr[0] = numbers[i];
                                    sixArr[1] = numbers[j];
                                    sixArr[2] = numbers[k];
                                    sixArr[3] = numbers[l];
                                    sixArr[4] = numbers[m];
                                    sixArr[5] = numbers[h];
                                    if (fourEven(sixArr) && fourOdd(sixArr) && twoConsecutive(sixArr) && threeSameEnding(sixArr) && threeSameTens(sixArr)) {
                                        ps.println(Arrays.toString(sixArr) + '\n');
                                        ps.flush();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Filtering functions below this point

    public static boolean fourEven (int[] table) {
        int counter = 0;
        for (int num : table) {
            if (num % 2 == 0) counter++;
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