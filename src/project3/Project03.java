package project3;

import java.io.*;

/**
 * Project 3 solution attempt for CF7 (Five-Projects PDF Chapter.10 "Structured Programming")
 * Reads characters from a txt file and stores them into a 128x2 array.
 * Then prints each character and the amount of times it appears in the text file, ordered by character.
 */
public class Project03 {

    public static void main(String[] args) {

        int[][] arr = new int[128][2];
        String inFile = "C:/temp/lorem.txt";

        try (FileReader fileReader = new FileReader(inFile)) {
            int i;
            while ((i = fileReader.read()) != -1) {
                // Filter spaces
                if (i == 32 || i == 13 || i == 10 || i == 9) {
                    continue;
                } else if (arr[i][0] == 0) {
                    arr[i][0] = i;
                    arr[i][1]++;
                } else arr[i][1]++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        printStats(arr);
    }

    public static void printStats (int[][] arr) {
        for (int[] ch : arr) {
            if (ch[0] != 0) {
                String ending = ch[1] == 1 ? " time." : " times.";
                System.out.println("Character: " + "'" + (char) ch[0] + "'," + " occurred " + ch[1] + ending);
            }
        }
    }
}
