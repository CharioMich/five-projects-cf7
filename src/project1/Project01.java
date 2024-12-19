package project1;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Project01 {

    public static void main(String[] args) {

        final int len = 6;
        String line;
        int[] sixTable = {len};
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        String inFile = "C:/Users/babio/numbers.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inFile))) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                for (String part : parts) {
                    int number = Integer.parseInt(part.trim());
                    numbers.add(number);
                }
            }
            //System.out.println(numbers);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error 12345");
        }

        int l = numbers.size();

        for (int i = 0; i < l - len; i++) {
            for (int j = )
        }

    }
}